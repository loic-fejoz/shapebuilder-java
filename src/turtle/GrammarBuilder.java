/**
 * 
 */
package turtle;

import java.io.IOException;

import shapegrammar.Node;

/**
 * @author loicfejoz
 *
 */
public class GrammarBuilder {
	
	public static GrammarBuilder grammar() {
		return new GrammarBuilder();
	}

	private TurtleInterpreter<Turtle> interp;
	private int maxIteration;
	private Node<? super Turtle> axiom;
	private double defaultAngle;
	private String axioms;

	public GrammarBuilder() {
		interp = new TurtleInterpreter<>();
	}

	public GrammarBuilder maxIterationIs(final int n) {
		this.maxIteration = n;
		return this;
	}
	
	public GrammarBuilder defaultDegreeAngleIs(final double d) {
		defaultAngle = d * Math.PI / 180.0;
		return this;
	}
	
	public GrammarBuilder initialAxiomIs(final String value) {
		axioms = value;
		return this;
	}
	
	public GrammarBuilder declare(final char name, final String extension, final String defaultRendering) {
		interp.declareRule(name, extension, defaultRendering);
		return this;
	}
	
	public void save(final String path) throws IOException {
		axiom = interp.createAxiom(axioms);
		interp.evaluate(axiom, maxIteration);
		interp.writeToFile(axiom, path, defaultAngle);
	}

	public GrammarBuilder declare(final RuleBuilder aRule) {
		return declare(aRule.name, aRule.extension, aRule.defaultRendering);
	}
}

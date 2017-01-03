/**
 * 
 */
package turtle;

import java.io.IOException;
import java.util.Random;

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
		interp = new TurtleInterpreter<>(new Random());
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

	public void save(final String path) throws IOException {
		axiom = interp.createAxiom(axioms);
		interp.evaluate(axiom, maxIteration);
		interp.writeToFile(axiom, path, defaultAngle);
	}

	public GrammarBuilder declare(final RuleBuilder aRule) {
		aRule.declare(this);
		return this;
	}
	
	public GrammarBuilder declare(final StochasticUserRuleBuilder aRule) {
		aRule.declare(this);
		return this;
	}

	public void declare(char name, UserRuleDeclaration<Turtle> ruleDecl) {
		interp.declareRule(name, ruleDecl);
	}

	public <R extends Turtle> void declare(char name, final StochasticUserRuleDeclaration<Turtle> ruleDecl) {
		interp.declareRule(name, ruleDecl);
	}
}

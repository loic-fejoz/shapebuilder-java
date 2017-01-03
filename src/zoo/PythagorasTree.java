/**
 * 
 */
package zoo;

import static turtle.GrammarBuilder.grammar;
import static turtle.RuleBuilder.aRule;

import java.io.IOException;

/**
 * @author loic
 *
 */
public class PythagorasTree {
	
	public static void main(final String[] args) throws IOException {
		grammar()
		.maxIterationIs(5)
		.defaultDegreeAngleIs(45.0)
		.initialAxiomIs("A")
		.declare(
				aRule('A')
				.withExtension("B[+A]-A")
				.withDefaultRendering("F"))
		.declare(
				aRule('B')
				.withExtension("BB")
				.withDefaultRendering("F"))
		.save("/tmp/pythagoras-tree.svg");
	}

}

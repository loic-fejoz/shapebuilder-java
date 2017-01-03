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
public class SierpinskiTriangle {
	
	public static void main(final String[] args) throws IOException {
		grammar()
		.maxIterationIs(5)
		.defaultDegreeAngleIs(60.0)
		.initialAxiomIs("A-B-B")
		.declare(
				aRule('A')
				.withExtension("A-B+A+B-A")
				.withDefaultRendering("F"))
		.declare(
				aRule('B')
				.withExtension("BB")
				.withDefaultRendering("F"))
		.save("/tmp/sierpinski-triangle.svg");
	}

}

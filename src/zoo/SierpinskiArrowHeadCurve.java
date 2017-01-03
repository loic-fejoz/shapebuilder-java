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
public class SierpinskiArrowHeadCurve {
	
	public static void main(final String[] args) throws IOException {
		grammar()
		.maxIterationIs(5)
		.defaultDegreeAngleIs(60.0)
		.initialAxiomIs("A")
		.declare(
				aRule('A')
				.withExtension("+B-A-B+")
				.withDefaultRendering("F"))
		.declare(
				aRule('B')
				.withExtension("-A+B+A-")
				.withDefaultRendering("F"))
		.save("/tmp/sierpinski-arrowhead-curve.svg");
	}

}

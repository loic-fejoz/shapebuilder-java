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
public class FractalPlant {
	
	public static void main(final String[] args) throws IOException {
		grammar()
			.maxIterationIs(5)
			.defaultDegreeAngleIs(25.0)
			.initialAxiomIs("A")
			.declare(
					aRule('A')
					.withExtension("B-[[A]+A]+B[+BA]-A"))
			.declare(
					aRule('B')
					.withExtension("BB")
					.withDefaultRendering("F"))
			.save("/tmp/fractal.svg");
	}

}

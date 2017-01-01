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
public class HilbertCurve {
	
	public static void main(final String[] args) throws IOException {
		grammar()
			.maxIterationIs(5)
			.defaultDegreeAngleIs(90)
			.initialAxiomIs("A")
			.declare(aRule('A').withExtension("-BF+AFA+FB-"))
			.declare(aRule('B').withExtension("+AF-BFB-FA+"))
			.save("/tmp/hilbert-curve.svg");
	}

}

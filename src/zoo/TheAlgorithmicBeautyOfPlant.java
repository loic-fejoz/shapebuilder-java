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
public class TheAlgorithmicBeautyOfPlant {
	
	public static void main(final String[] args) throws IOException {
		// Examples from book /The Algorithmic Beauty of Plants/.
		// See http://algorithmicbotany.org/papers/#abop
		// page 7-8 Quadratic Koch Island
		grammar()
			.maxIterationIs(3)
			.defaultDegreeAngleIs(90)
			.initialAxiomIs("A-A-A-A")
			.declare(
					aRule('A')
					.withExtension("A-A+A+AA-A-A+A")
					.withDefaultRendering("F"))
			.save("/tmp/quadratic-koch-island.svg");
		// page 10 - b
		grammar()
			.maxIterationIs(4)
			.defaultDegreeAngleIs(90)
			.initialAxiomIs("A-A-A-A")
			.declare(
					aRule('A')
					.withExtension("AA-A-A-A-AA")
					.withDefaultRendering("F"))
			.save("/tmp/koch-curve-b.svg");
		// page 10 - d
		grammar()
			.maxIterationIs(4)
			.defaultDegreeAngleIs(90)
			.initialAxiomIs("A-A-A-A")
			.declare(
					aRule('A')
					.withExtension("AA-A--A-A")
					.withDefaultRendering("F"))
			.save("/tmp/koch-curve-d.svg");
		// page 12 - a
		grammar()
			.maxIterationIs(4)
			.defaultDegreeAngleIs(60)
			.initialAxiomIs("A")
			.declare(
					aRule('A')
					.withExtension("A+B++B-A--AA-B+")
					.withDefaultRendering("F"))
			.declare(
					aRule('B')
					.withExtension("-A+BB++B+A--A-B")
					.withDefaultRendering("F"))
			.save("/tmp/fass-a.svg");
		// page 25 - a
		grammar()
			.maxIterationIs(5)
			.defaultDegreeAngleIs(25.7)
			.initialAxiomIs("A")
			.declare(
					aRule('A')
					.withExtension("A[+A]A[-A]A")
					.withDefaultRendering("F"))
			.save("/tmp/plant-25-a.svg");
		// page 25 - b
		grammar()
			.maxIterationIs(5)
			.defaultDegreeAngleIs(20)
			.initialAxiomIs("A")
			.declare(
					aRule('A')
					.withExtension("A[+A]A[-A][A]")
					.withDefaultRendering("F"))
			.save("/tmp/plant-25-b.svg");
		// page 25 - c
		grammar()
			.maxIterationIs(4)
			.defaultDegreeAngleIs(22.5)
			.initialAxiomIs("A")
			.declare(
					aRule('A')
					.withExtension("AA-[-A+A+A]+[+A-A-A]")
					.withDefaultRendering("F"))
			.save("/tmp/plant-25-c.svg");
		// page 25 - d
		grammar()
			.maxIterationIs(7)
			.defaultDegreeAngleIs(20)
			.initialAxiomIs("X")
			.declare(
					aRule('X')
					.withExtension("A[+X]A[-X]+X"))
			.declare(
					aRule('A')
					.withExtension("AA")
					.withDefaultRendering("F"))
			.save("/tmp/plant-25-d.svg");
		// page 25 - e
		grammar()
			.maxIterationIs(7)
			.defaultDegreeAngleIs(25.7)
			.initialAxiomIs("X")
			.declare(
					aRule('X')
					.withExtension("A[+X][-X]AX"))
			.declare(
					aRule('A')
					.withExtension("AA")
					.withDefaultRendering("F"))
			.save("/tmp/plant-25-e.svg");
		// page 25 - f
		grammar()
			.maxIterationIs(5)
			.defaultDegreeAngleIs(22.5)
			.initialAxiomIs("X")
			.declare(
					aRule('X')
					.withExtension("A-[[X]+X]+A[+AX]-X"))
			.declare(
					aRule('A')
					.withExtension("AA")
					.withDefaultRendering("F"))
			.save("/tmp/plant-25-f.svg");
	}

}

/**
 * 
 */
package zoo;

import java.io.IOException;

import shapegrammar.Node;
import turtle.TextualTurtle;
import turtle.Turtle;
import turtle.TurtleInterpreter;

/**
 * @author loic
 *
 */
public class HilbertCurve {
	
	public static void main(final String[] args) throws IOException {
		final TurtleInterpreter<Turtle> interp = new TurtleInterpreter<>();
		interp.declareRule('A', "-BF+AFA+FB-", "");
		interp.declareRule('B', "+AF-BFB-FA+", "");
		final Node<? super Turtle> axiom = interp.createAxiom("A");
		interp.evaluate(axiom, 1);
		axiom.render(new TextualTurtle());
		for(int i = 0; i < 5; i++) {
			System.out.println();
			interp.evaluate();
			axiom.render(new TextualTurtle());
		}
		interp.writeToFile(axiom, "/tmp/hilbert-curve.svg", Math.PI / 2.0);
	}

}

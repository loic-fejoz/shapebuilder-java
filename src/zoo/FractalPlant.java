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
public class FractalPlant {
	
	public static void main(final String[] args) throws IOException {
		final TurtleInterpreter<Turtle> interp = new TurtleInterpreter<>();
		// (X → F−[[X]+X]+F[+FX]−X), (F → FF)
		interp.declareRule('A', "B-[[A]+A]+B[+BA]-A", "");
		interp.declareRule('B', "BB", "F");
		final Node<? super Turtle> axiom = interp.createAxiom("A");
		interp.evaluate(axiom, 1);
		axiom.render(new TextualTurtle());
		for(int i = 0; i < 5; i++) {
			System.out.println();
			interp.evaluate();
			axiom.render(new TextualTurtle());
		}
		interp.writeToFile(axiom, "/tmp/fractal.svg", 25.0 * Math.PI / 180.0);
	}

}

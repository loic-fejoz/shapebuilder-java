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
public class PythagorasTree {
	
	public static void main(final String[] args) throws IOException {
		final TurtleInterpreter<Turtle> interp = new TurtleInterpreter<>();
		// (1 → 11), (0 → 1[0]0)
		interp.declareRule('A', "B[+A]-A", "F");
		interp.declareRule('B', "BB", "F");
		final Node<? super Turtle> axiom = interp.createAxiom("A");
		interp.evaluate(axiom, 1);
		axiom.render(new TextualTurtle());
		for(int i = 0; i < 4; i++) {
			System.out.println();
			interp.evaluate();
			axiom.render(new TextualTurtle());
		}
		interp.writeToFile(axiom, "/tmp/pythagoras-tree.svg", Math.PI / 4.0);
	}

}

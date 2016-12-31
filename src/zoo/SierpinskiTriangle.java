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
public class SierpinskiTriangle {
	
	public static void main(final String[] args) throws IOException {
		final TurtleInterpreter<Turtle> interp = new TurtleInterpreter<>();
		interp.declareRule('A', "A-B+A+B-A", "F");
		interp.declareRule('B', "BB", "F");
		final Node<? super Turtle> axiom = interp.createAxiom("A-B-B");
		interp.evaluate(axiom, 1);
		axiom.render(new TextualTurtle());
		for(int i = 0; i < 5; i++) {
			System.out.println();
			interp.evaluate();
			axiom.render(new TextualTurtle());
		}
		interp.writeToFile(axiom, "/tmp/sierpinski-triangle.svg", 2.0 * Math.PI / 3.0);
	}

}

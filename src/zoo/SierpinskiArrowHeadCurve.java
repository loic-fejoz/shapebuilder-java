/**
 * 
 */
package zoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import shapegrammar.Node;
import turtle.SVGTurtle;
import turtle.TextualTurtle;
import turtle.Turtle;
import turtle.TurtleInterpreter;

/**
 * @author loic
 *
 */
public class SierpinskiArrowHeadCurve {
	
	public static void main(final String[] args) throws IOException {
		final TurtleInterpreter<Turtle> interp = new TurtleInterpreter<>();
		//(A → +B−A−B+), (B → −A+B+A−)
		interp.declareRule('A', "+B-A-B+", "F");
		interp.declareRule('B', "-A+B+A-", "F");
		final Node<? super Turtle> axiom = interp.createAxiom("A");
		interp.evaluate(axiom, 1);
		axiom.render(new TextualTurtle());
		for(int i = 0; i < 5; i++) {
			System.out.println();
			interp.evaluate();
			axiom.render(new TextualTurtle());
		}
		FileWriter output = new FileWriter(new File("/tmp/sierpinski-arrowhead-curve.svg"));
		final SVGTurtle svgTurtle = new SVGTurtle(output);
		svgTurtle.setDefaultAngle(Math.PI / 3.0);
		axiom.render(svgTurtle);
		svgTurtle.close();
		output.close();
	}

}

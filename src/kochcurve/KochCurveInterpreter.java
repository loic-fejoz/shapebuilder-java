package kochcurve;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import turtle.SVGTurtle;
import turtle.TextualTurtle;
import turtle.TurtleInterpreter;

public class KochCurveInterpreter extends TurtleInterpreter {
	
	public static void main(final String[] args) throws IOException {
		
		final KochCurveInterpreter interp = new KochCurveInterpreter();
		final FRule axiom = new FRule();
		interp.evaluate(axiom, 0);
		axiom.render(new TextualTurtle());
		for(int i = 0; i < 5; i++) {
			System.out.println();
			interp.evaluate();
			axiom.render(new TextualTurtle());
		}
		FileWriter output = new FileWriter(new File("/tmp/koch-curve.svg"));
		final SVGTurtle svgTurtle = new SVGTurtle(output);
		axiom.render(svgTurtle);
		svgTurtle.close();
		output.close();
	}
}

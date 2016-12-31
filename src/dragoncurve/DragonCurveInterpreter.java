package dragoncurve;

import static dragoncurve.DragonCurveFactory.x;
import static turtle.TurtleFactory.f;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import shapegrammar.Axiom;
import shapegrammar.Interpreter;
import turtle.SVGTurtle;

public class DragonCurveInterpreter extends Interpreter<DragonRenderer> {
	
	public static void main(final String[] args) throws IOException {
		
		final DragonCurveInterpreter interp = new DragonCurveInterpreter();
		final Axiom<DragonRenderer> axiom = new Axiom<DragonRenderer>(f(), x());
		interp.evaluate(axiom, 0);
		axiom.render(new TextualDragonRenderer());
		for(int i = 0; i < 10; i++) {
			System.out.println();
			interp.evaluate();
			axiom.render(new TextualDragonRenderer());
		}
		FileWriter output = new FileWriter(new File("/tmp/dragon-curve.svg"));
		final SVGTurtle svgTurtle = new SVGTurtle(output);
		final DragonRendererImpl dragonSvgTurtle = new DragonRendererImpl(svgTurtle);
		axiom.render(dragonSvgTurtle);
		svgTurtle.close();
		output.close();
	}
}

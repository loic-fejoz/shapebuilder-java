package turtle;

import shapegrammar.TerminalShape;

public interface TurtleGrammar<G> {
	TerminalShape<G, Turtle> plus();
	TerminalShape<G, Turtle> minus();
	
	double getAngle();
}

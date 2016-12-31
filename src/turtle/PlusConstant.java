package turtle;

import shapegrammar.TerminalShape;

public class PlusConstant<G extends TurtleGrammar<G>> extends TerminalShape<G, Turtle> {
	@Override
	public void render(final Turtle turtle) {
		turtle.left();
	}
}

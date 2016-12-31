package turtle;

import shapegrammar.TerminalShape;

public class MinusConstant<G extends TurtleGrammar<G>> extends TerminalShape<G, Turtle> {

	@Override
	public void render(final Turtle turtle) {
		turtle.right();
	}

}

package turtle;

import shapegrammar.TerminalShape;

public class MinusConstant extends TerminalShape<Turtle> {

	@Override
	public void render(final Turtle turtle) {
		turtle.right();
	}

}

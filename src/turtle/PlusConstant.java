package turtle;

import shapegrammar.TerminalShape;

public class PlusConstant extends TerminalShape<Turtle> {
	@Override
	public void render(final Turtle turtle) {
		turtle.left();
	}
}

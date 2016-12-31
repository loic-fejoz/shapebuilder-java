package turtle;

import shapegrammar.Interpreter;
import shapegrammar.TerminalShape;

public abstract class TurtleInterpreter<G extends TurtleGrammar<G>> extends Interpreter<G, Turtle> implements TurtleGrammar<G> {
	
	@Override
	public TerminalShape<G, Turtle> plus() {
		PlusConstant<G> res = new PlusConstant<G>();
		return res;
	}

	@Override
	public TerminalShape<G, Turtle> minus() {
		return new MinusConstant<G>();
	}

	@Override
	public double getAngle() {
		return 90;
	}
}

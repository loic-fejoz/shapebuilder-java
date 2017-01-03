package kochcurve;

import static kochcurve.KochCurveFactory.f;
import static turtle.TurtleFactory.minus;
import static turtle.TurtleFactory.plus;

import java.util.Arrays;
import java.util.List;

import shapegrammar.Node;
import shapegrammar.Rule;
import turtle.Turtle;

public class FRule extends Rule<Turtle> {

	@Override
	public List<Node<? super Turtle>> call() {
		//F → F+F−F−F+F
		return Arrays.asList(
				f(),
				plus(),
				f(),
				minus(),
				f(),
				minus(),
				f(),
				plus(),
				f());
	}

	@Override
	public void renderDefault(Turtle turtle) {
		turtle.forward();
	}
}

package kochcurve;

import java.util.Arrays;
import java.util.List;

import shapegrammar.Node;
import shapegrammar.Rule;
import turtle.Turtle;

public class FRule<G extends KochCurveGrammar<G>> extends Rule<G, Turtle> {

	@Override
	public List<Node<G, Turtle>> call() {
		//F → F+F−F−F+F
		return Arrays.asList(
				grammar.f(),
				grammar.plus(),
				grammar.f(),
				grammar.minus(),
				grammar.f(),
				grammar.minus(),
				grammar.f(),
				grammar.plus(),
				grammar.f());
	}

	@Override
	protected void renderDefault(Turtle turtle) {
		turtle.forward();
	}
}

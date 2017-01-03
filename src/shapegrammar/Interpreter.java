/**
 * 
 */
package shapegrammar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import turtle.StochasticUserRule;

/**
 * @author loic
 *
 */
public class Interpreter<R> {
	
	public Node<? super R> initialShape;
	public List<Rule<? super R>> notYetEvaluated;
	protected Random rand;

	public Interpreter(final Random rnd) {
		rand = rnd;
		assert(rand != null);
	}
	
	public void evaluate(final Node<? super R> axiom, final int depth) {
		initialShape = axiom;
		for(int i = 0; i < depth; ++i) {
			evaluate();
		}
	}
	
	public void evaluate() {
		if (notYetEvaluated == null) {
			notYetEvaluated = new LinkedList<>();
			evaluateNode(initialShape);
		} else {
			final List<Rule<? super R>> currentlyNotEvaluated = new LinkedList<>(notYetEvaluated);
			notYetEvaluated = new LinkedList<>();
			for(Rule<? super R> rule: currentlyNotEvaluated) {
				evaluateNode(rule);
			}
		}
		
	}

	protected void evaluateNode(final Node<? super R> rule) {
		if (rule instanceof StochasticUserRule) {
			((StochasticUserRule<? super R>)rule).setRandomGenerator(rand);
		}
		rule.run();
		for(Node<? super R> newChild: rule.get()) {
			if (newChild instanceof Rule) {
				notYetEvaluated.add((Rule<? super R>) newChild);
			}
		}
	}
}

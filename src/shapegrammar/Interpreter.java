/**
 * 
 */
package shapegrammar;

import java.util.LinkedList;
import java.util.List;

/**
 * @author loic
 *
 */
public abstract class Interpreter<R> {
	
	public Node<R> initialShape;
	public List<Rule<R>> notYetEvaluated;

	public Interpreter() {
	}
	
	public void evaluate(final Node<R> axiom, final int depth) {
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
			final List<Rule<R>> currentlyNotEvaluated = new LinkedList<>(notYetEvaluated);
			notYetEvaluated = new LinkedList<>();
			for(Rule<R> rule: currentlyNotEvaluated) {
				evaluateNode(rule);
			}
		}
		
	}

	private void evaluateNode(final Node<R> rule) {
		rule.run();
		for(Node<R> newChild: rule.get()) {
			if (newChild instanceof Rule) {
				notYetEvaluated.add((Rule<R>) newChild);
			}
		}
	}
}

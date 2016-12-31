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
public abstract class Interpreter<G, R> {
	
	public Node<G, R> initialShape;
	public List<Rule<G, R>> notYetEvaluated;

	public Interpreter() {
	}
	
	public void evaluate(final Node<G, R> axiom, final int depth) {
		initialShape = axiom;
		for(int i = 0; i < depth; ++i) {
			evaluate();
		}
	}
	
	public void evaluate() {
		if (notYetEvaluated == null) {
			notYetEvaluated = new LinkedList<>();
			initialShape.grammar = getGrammar();
			initialShape.run();
		} else {
			final List<Rule<G, R>> currentlyNotEvaluated = new LinkedList<>(notYetEvaluated);
			notYetEvaluated = new LinkedList<>();
			for(Rule<G, R> rule: currentlyNotEvaluated) {
				rule.grammar = getGrammar();
				rule.run();
			}
		}
		
	}

	protected abstract G getGrammar();
}

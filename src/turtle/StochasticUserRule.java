/**
 * 
 */
package turtle;

import java.util.List;
import java.util.Random;

import org.apache.commons.math3.util.Pair;

import shapegrammar.Node;
import shapegrammar.Rule;

/**
 * @author loicfejoz
 *
 */
public class StochasticUserRule<R extends Turtle> extends Rule<R> {
	
	protected StochasticUserRuleDeclaration<R> decl;
	private TurtleInterpreter<R> interpreter;
	protected int index;
	protected Random rand;

	public StochasticUserRule(final TurtleInterpreter<R> interpreter, final StochasticUserRuleDeclaration<R> declaration) {
		this.interpreter = interpreter;
		if (declaration == null) {
			throw new IllegalArgumentException("declaration must not be null.");
		}
		decl = declaration;
	}
	
	@Override
	public void renderDefault(R renderer) {
		assert(index != -1);
		decl.get(index).renderDefault(renderer);
	}

	@Override
	public List<Node<? super R>> call() {
		final double rnd = rand.nextDouble();
		double acc = 0;
		UserRuleDeclaration<R> r = null;
		index = 0;
		for(Pair<Double, UserRuleDeclaration<R>> p: decl.subRules()) {
			acc += p.getFirst();
			index++;
			if (acc > rnd) {
				r = p.getSecond();
				break;
			}
		}
		System.out.println("indx=" + Integer.toString(index));
		assert(r != null);
		return interpreter.interpret(r.extension);
	}

	public void setRandomGenerator(Random generator) {
		rand = generator;
	}

}

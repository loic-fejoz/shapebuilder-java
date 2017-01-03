/**
 * 
 */
package turtle;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.Pair;

/**
 * @author loicfejoz
 *
 */
public class StochasticUserRuleDeclaration<R extends Turtle> {

	protected List<Pair<Double, UserRuleDeclaration<R>>> subRules;
	
	public StochasticUserRuleDeclaration() {
		super();
		subRules = new ArrayList<>();
	}
	
	public void addSubRule(final double probability, final UserRuleDeclaration<R> subRule) {
		subRules.add(new Pair<>(probability, subRule));
	}

	public UserRuleDeclaration<R> get(int index) {
		return subRules.get(index).getSecond();
	}

	public Iterable<Pair<Double, UserRuleDeclaration<R>>> subRules() {
		return subRules;
	}
}

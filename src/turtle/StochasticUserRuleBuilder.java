/**
 * 
 */
package turtle;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.math3.util.Pair;

/**
 * @author loicfejoz
 *
 */
public class StochasticUserRuleBuilder {
	
	public static StochasticUserRuleBuilder aStochasticRule(final char name) {
		return new StochasticUserRuleBuilder(name);
	}

	protected char name;
	protected List<Pair<Double, RuleBuilder>> subRules;
	private String defaultRendering;

	public StochasticUserRuleBuilder(char name) {
		this.name = name;
		subRules = new LinkedList<>();
	}

	public StochasticUserRuleBuilder subRule(double prob, final RuleBuilder rule) {
		subRules.add(new Pair<>(prob, rule));
		return this;
	}

	public StochasticUserRuleBuilder withDefaultRendering(String value) {
		this.defaultRendering = value;
		return this;
	}
	
	public <R extends Turtle> StochasticUserRuleDeclaration<R> build() {
		final StochasticUserRuleDeclaration<R> ruleDecl = new StochasticUserRuleDeclaration<>();
		for(Pair<Double, RuleBuilder> p: subRules) {
			final UserRuleDeclaration<R> userDecl = p.getSecond().build();
			userDecl.defaultRendering = defaultRendering;
			ruleDecl.addSubRule(p.getFirst(), userDecl);
		}
		return ruleDecl;
	}
	
	public char declare(final GrammarBuilder grammarBuilder) {
		grammarBuilder.declare(name, build());
		return name;
	}
}

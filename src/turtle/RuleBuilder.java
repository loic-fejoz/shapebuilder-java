/**
 * 
 */
package turtle;

import turtle.UserRuleDeclaration;

/**
 * @author loicfejoz
 *
 */
public class RuleBuilder {

	public static RuleBuilder aRule(final char name) {
		return new RuleBuilder(name);
	}
	
	protected char name;
	protected String extension = "";
	protected String defaultRendering = "";
	
	public RuleBuilder(final char name) {
		this.name = name;
	}

	public RuleBuilder withExtension(String value) {
		this.extension = value;
		return this;
	}

	public RuleBuilder withDefaultRendering(String value) {
		this.defaultRendering = value;
		return this;
	}

	public char declare(GrammarBuilder grammarBuilder) {
		grammarBuilder.declare(name, build());
		return name;
	}

	public <R extends Turtle> UserRuleDeclaration<R> build() {
		return new UserRuleDeclaration<R>(name, extension, defaultRendering);
	}
}

/**
 * 
 */
package turtle;

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
}

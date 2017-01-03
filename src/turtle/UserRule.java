/**
 * 
 */
package turtle;

import java.util.List;

import shapegrammar.Node;
import shapegrammar.Rule;

/**
 * @author loic
 *
 */
public class UserRule<R extends Turtle> extends Rule<R> {

	protected UserRuleDeclaration<R> decl;
	private TurtleInterpreter<R> interpreter;

	public UserRule(final TurtleInterpreter<R> interpreter, final UserRuleDeclaration<R> declaration) {
		this.interpreter = interpreter;
		if (declaration == null) {
			throw new IllegalArgumentException("declaration must not be null.");
		}
		decl = declaration;
	}

	@Override
	public void renderDefault(final R renderer) {
		decl.renderDefault(renderer);
	}

	@Override
	public List<Node<? super R>> call() {
		return interpreter.interpret(decl.extension);
	}

}

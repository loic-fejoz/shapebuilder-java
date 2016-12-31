/**
 * 
 */
package turtle;

import java.util.List;

import shapegrammar.Node;
import shapegrammar.Rule;
import turtle.TurtleInterpreter.UserRuleDeclaration;

/**
 * @author loic
 *
 */
public class UserRule<R extends Turtle> extends Rule<R> {

	protected UserRuleDeclaration decl;
	private TurtleInterpreter<R> interpreter;

	public UserRule(final TurtleInterpreter<R> interpreter, final UserRuleDeclaration declaration) {
		this.interpreter = interpreter;
		if (declaration == null) {
			throw new IllegalArgumentException("declaration must not be null.");
		}
		decl = declaration;
	}

	@Override
	protected void renderDefault(final R renderer) {
		for(char c: decl.defaultRendering.toCharArray()) {
			switch(c) {
			case 'F':
				renderer.forward();
				break;
			case '+':
				renderer.left();
				break;
			case '-':
				renderer.right();
				break;	
			}
		}
	}

	@Override
	public List<Node<? super R>> call() {
		return interpreter.interpret(decl.extension);
	}

}

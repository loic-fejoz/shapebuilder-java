/**
 * 
 */
package turtle;

import shapegrammar.TerminalShape;

/**
 * @author loic
 *
 */
public class PopConstant extends TerminalShape<Turtle> {

	@Override
	public void render(final Turtle turtle) {
		turtle.pop();
	}

}
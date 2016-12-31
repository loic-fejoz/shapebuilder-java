/**
 * 
 */
package turtle;

import shapegrammar.TerminalShape;

/**
 * @author loic
 *
 */
public class FConstant extends TerminalShape<Turtle> {

	@Override
	public void render(final Turtle turtle) {
		turtle.forward();
	}

}
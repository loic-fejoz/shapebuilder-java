/**
 * 
 */
package turtle;

import shapegrammar.TerminalShape;

/**
 * @author loic
 *
 */
public class PushConstant extends TerminalShape<Turtle> {

	@Override
	public void render(final Turtle turtle) {
		turtle.push();
	}

}
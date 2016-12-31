/**
 * 
 */
package turtle;

import shapegrammar.TerminalShape;

/**
 * @author loic
 *
 */
public class TurtleFactory {

	/**
	 * This is an helper class.
	 */
	private TurtleFactory() {
	}

	public static TerminalShape<Turtle> plus() {
		return new PlusConstant();
	}

	public static TerminalShape<Turtle> minus() {
		return new MinusConstant();
	}
	
	public static TerminalShape<Turtle> f() {
		return new FConstant();
	}
}

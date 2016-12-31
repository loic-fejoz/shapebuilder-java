/**
 * 
 */
package dragoncurve;

import turtle.Turtle;

/**
 * @author loic
 *
 */
public class DragonRendererImpl implements DragonRenderer {

	private Turtle turtle;

	/**
	 * 
	 */
	public DragonRendererImpl(final Turtle turtle) {
		this.turtle = turtle;
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#left()
	 */
	@Override
	public void left() {
		turtle.left();
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#right()
	 */
	@Override
	public void right() {
		turtle.right();
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#forward()
	 */
	@Override
	public void forward() {
		turtle.forward();
	}

	/* (non-Javadoc)
	 * @see dragoncurve.DragonRenderer#x()
	 */
	@Override
	public void x() {
	}

	/* (non-Javadoc)
	 * @see dragoncurve.DragonRenderer#y()
	 */
	@Override
	public void y() {
	}

}

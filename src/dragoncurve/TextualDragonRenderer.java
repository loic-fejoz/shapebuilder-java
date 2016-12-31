/**
 * 
 */
package dragoncurve;

import turtle.TextualTurtle;

/**
 * @author loic
 *
 */
public class TextualDragonRenderer extends TextualTurtle implements DragonRenderer {

	@Override
	public void x() {
		System.out.print("X");
	}

	@Override
	public void y() {
		System.out.print("Y");
	}

}

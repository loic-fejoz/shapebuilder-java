/**
 * 
 */
package turtle;

/**
 * @author loic
 *
 */
public class TextualTurtle implements Turtle {
	
	public void left() {
		System.out.print("+");
	}
	
	public void right() {
		System.out.print("-");
	}

	public void forward() {
		System.out.print("F");
	}

	@Override
	public void setDefaultAngle(double angle) {
	}

	@Override
	public void push() {
		System.out.print("[");
	}

	@Override
	public void pop() {
		System.out.print("]");
	}

}

/**
 * 
 */
package turtle;

import java.io.IOException;
import java.io.Writer;
import java.util.Stack;

import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

/**
 * @author loic
 *
 */
public class SVGTurtle implements Turtle {

	public class TurtleState {
		private Vector3D position;
		private Vector3D direction;
		
		public TurtleState(final TurtleState st) {
			position = st.position;
			direction = st.direction;
		}
		
		public TurtleState(final Vector3D p, final Vector3D d) {
			position = p;
			direction = d;
		}
	}

	private TurtleState state;
	private Stack<TurtleState> stack;
	private Writer w;
	private Rotation defaultAngle;

	public SVGTurtle(final Writer output) {
		stack = new Stack<>();
		state = new TurtleState(Vector3D.ZERO, new Vector3D(5, 0, 0));
		setDefaultAngle(Math.PI / 2);
		w = output;
		write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
				+ "<svg\n"
				+ "  xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
				+ "  xmlns:cc=\"http://creativecommons.org/ns#\"\n"
				+ "  xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
				+ "  xmlns:svg=\"http://www.w3.org/2000/svg\"\n"
				+ "  xmlns=\"http://www.w3.org/2000/svg\"\n"
				+ "  xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\"\n"
				+ "  version=\"1.1\"\n"
				+ "  x=\"0\"\n"
				+ "  y=\"0\"\n"
				+ "  width=\"210mm\"\n"
				+ "  height=\"297mm\"\n"
				+ "  viewBox=\"0 0 210 297\"\n"
				+ "  id=\"turtle-svg\">\n");
		startNewPath();
	}

	private void startNewPath() {
		write("  <path style=\"fill:none;stroke:#000000;stroke-width:0.2;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1\" \n");
		write("        d=\"");
		move("M");
	}

	private void move(final String command) {
		write(command);
		write(Double.toString(state.position.getX()));
		write(",");
		write(Double.toString(state.position.getY()));
		write(" ");
	}

	private void write(String string) {
		try {
			w.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#left()
	 */
	@Override
	public void left() {
		state.direction = defaultAngle.applyTo(state.direction);
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#right()
	 */
	@Override
	public void right() {
		state.direction = defaultAngle.applyInverseTo(state.direction);
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#forward()
	 */
	@Override
	public void forward() {
		state.position = state.position.add(state.direction);
		move("L");
	}
	
	public void endPath() {
		write("\"/>\n");
	}
	
	public void close() throws IOException {
		endPath();
		write("</svg>\n");
	}

	@Override
	public void setDefaultAngle(final double value) {
		defaultAngle = new Rotation(new Vector3D(0, 0, 1), value, RotationConvention.VECTOR_OPERATOR);;
	}

	@Override
	public void push() {
		stack.push(new TurtleState(state));
	}

	@Override
	public void pop() {
		endPath();
		state = stack.pop();
		startNewPath();
	}

}

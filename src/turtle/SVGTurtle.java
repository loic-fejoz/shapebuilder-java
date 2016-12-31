/**
 * 
 */
package turtle;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

/**
 * @author loic
 *
 */
public class SVGTurtle implements Turtle {

	private Vector3D position;
	private Vector3D direction;
	private Writer w;
	private Rotation defaultAngle;

	public SVGTurtle(final Writer output) {
		position = Vector3D.ZERO;
		direction = new Vector3D(5, 0, 0);
		setDefaultAngle(90);
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
		write(Double.toString(position.getX()));
		write(",");
		write(Double.toString(position.getY()));
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
		direction = defaultAngle.applyTo(direction);
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#right()
	 */
	@Override
	public void right() {
		direction = defaultAngle.applyInverseTo(direction);
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#forward()
	 */
	@Override
	public void forward() {
		position = position.add(direction);
		move("L");
	}
	
	public void close() throws IOException {
		write("\"/>\n");
		write("</svg>\n");
	}

	@Override
	public void setDefaultAngle(final double value) {
		defaultAngle = new Rotation(new Vector3D(0, 0, 1), value, RotationConvention.VECTOR_OPERATOR);;
	}

}

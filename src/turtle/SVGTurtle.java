/**
 * 
 */
package turtle;

import java.io.IOException;
import java.io.Writer;

/**
 * @author loic
 *
 */
public class SVGTurtle implements Turtle {

	private double position[]  = {0.0, 0.0};
	private double direction[] = {1.0, 0.0};
	private Writer w;

	public SVGTurtle(final Writer output) {
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
		write(Double.toString(position[0]));
		write(",");
		write(Double.toString(position[1]));
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
		if (direction[0] == 1.0) {
			direction[0] = 0.0;
			direction[1] = 1.0;
		} else if (direction[0] == -1.0) {
			direction[0] =  0.0;
			direction[1] = -1.0;
		} else if (direction[1] == 1.0) {
			direction[0] = -1.0;
			direction[1] =  0.0;
		} else if (direction[1] == -1.0) {
			direction[0] = 1.0;
			direction[1] = 0.0;
		}
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#right()
	 */
	@Override
	public void right() {
		if (direction[0] == 1.0) {
			direction[0] = 0.0;
			direction[1] = -1.0;
		} else if (direction[0] == -1.0) {
			direction[0] = 0.0;
			direction[1] = 1.0;
		} else if (direction[1] == 1.0) {
			direction[0] = 1.0;
			direction[1] = 0.0;
		} else if (direction[1] == -1.0) {
			direction[0] = -1.0;
			direction[1] = 0.0;
		}
	}

	/* (non-Javadoc)
	 * @see turtle.Turtle#forward()
	 */
	@Override
	public void forward() {
		position[0] += 5 * direction[0];
		position[1] += 5 * direction[1];
		move("L");
	}
	
	public void close() throws IOException {
		write("\"/>\n");
		write("</svg>\n");
	}

}

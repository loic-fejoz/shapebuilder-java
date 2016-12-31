/**
 * 
 */
package kochcurve;

import shapegrammar.Rule;
import turtle.Turtle;

/**
 * @author loic
 *
 */
public class KochCurveFactory {

	/**
	 * This is an helper class
	 */
	private KochCurveFactory() {
	}

	public static Rule<Turtle> f() {
		return new FRule();
	}
}

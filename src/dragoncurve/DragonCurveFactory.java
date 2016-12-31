/**
 * 
 */
package dragoncurve;

import shapegrammar.Rule;

/**
 * @author loic
 *
 */
public class DragonCurveFactory {

	/**
	 * This is an helper class
	 */
	private DragonCurveFactory() {
	}

	public static Rule<DragonRenderer> x() {
		return new XRule();
	}
	
	public static Rule<DragonRenderer> y() {
		return new YRule();
	}
}

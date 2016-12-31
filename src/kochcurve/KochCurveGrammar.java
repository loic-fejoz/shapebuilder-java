/**
 * 
 */
package kochcurve;

import shapegrammar.Node;
import turtle.Turtle;
import turtle.TurtleGrammar;

/**
 * @author loic
 *
 */
public interface KochCurveGrammar<G> extends TurtleGrammar<G> {
	Node<G, Turtle> f();
}

/**
 * 
 */
package shapegrammar;

import java.util.Collections;
import java.util.List;

/**
 * @author loic
 *
 */
public abstract class TerminalShape<G, R> extends Node<G, R> {
	public List<Node<G, R>> call() {
		return Collections.emptyList();
	}
	
	public abstract void render(R renderer);
}

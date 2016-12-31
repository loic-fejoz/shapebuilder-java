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
public abstract class TerminalShape<R> extends Node<R> {
	public List<Node<? super R>> call() {
		return Collections.emptyList();
	}
	
	public abstract void render(R renderer);
}

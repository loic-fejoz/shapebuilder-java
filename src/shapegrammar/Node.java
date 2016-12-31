/**
 * 
 */
package shapegrammar;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author loic
 *
 */
public abstract class Node<G, R> implements Callable<List<Node<G, R>>>, Runnable {
	
	public Scope scope;
	public Pivot pivot;
	
	public List<Node<G, R>> children;
	
	public G grammar;

	public void run() {
		if (children == null) {
			children = call();
		}
	}

	public abstract List<Node<G, R>> call();
	
	public void render(R renderer) {
		for(Node<G, R> child: children) {
			child.render(renderer);
		}
	}
}

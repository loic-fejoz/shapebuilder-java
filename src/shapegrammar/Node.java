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
public abstract class Node<R> implements Callable<List<Node<R>>>, Runnable {
	
	public Scope scope;
	public Pivot pivot;
	
	protected List<Node<R>> children;
	
	public void run() {
		if (children == null) {
			children = call();
		}
	}

	public abstract List<Node<R>> call();
	
	public void render(R renderer) {
		for(Node<R> child: children) {
			child.render(renderer);
		}
	}
	
	public List<Node<R>> get() {
		return children;
	}
}

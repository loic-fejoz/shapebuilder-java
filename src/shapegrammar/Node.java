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
public abstract class Node<R> implements Callable<List<Node<? super R>>>, Runnable {
	
	public Scope scope;
	public Pivot pivot;
	
	protected List<Node<? super R>> children;
	
	public void run() {
		if (children == null) {
			children = call();
		}
	}

	public abstract List<Node<? super R>> call();
	
	public void render(R renderer) {
		for(Node<? super R> child: children) {
			child.render(renderer);
		}
	}
	
	public List<Node<? super R>> get() {
		return children;
	}
}

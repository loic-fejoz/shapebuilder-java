/**
 * 
 */
package shapegrammar;

import java.util.Arrays;
import java.util.List;

/**
 * @author loic
 *
 */
public class Axiom<R> extends Node<R> {
	
	public Axiom() {
		children = null;
	}
	
	public Axiom(final Node<? super R>...children) {
		this.children = Arrays.asList(children);
	}

	public Axiom(final List<Node<? super R>> axiomsList) {
		children = axiomsList;
	}

	public void run() {
	}
	
	@Override
	public List<Node<? super R>> call() {
		return children;
	}

}

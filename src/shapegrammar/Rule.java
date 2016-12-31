package shapegrammar;

public abstract class Rule<G, R> extends Node<G, R> {
	public void render(final R renderer) {
		if (children == null) {
			renderDefault(renderer);
		} else {
			super.render(renderer);
		}
	}

	protected abstract void renderDefault(R renderer);
}

package shapegrammar;

public abstract class Rule<R> extends Node<R> {

	public void render(final R renderer) {
		if (children == null) {
			renderDefault(renderer);
		} else {
			super.render(renderer);
		}
	}

	public abstract void renderDefault(R renderer);

}

package dragoncurve;

import static dragoncurve.DragonCurveFactory.y;
import static turtle.TurtleFactory.f;
import static turtle.TurtleFactory.minus;

import java.util.Arrays;
import java.util.List;

import shapegrammar.Node;
import shapegrammar.Rule;

public class YRule extends Rule<DragonRenderer> {

	@Override
	public List<Node<? super DragonRenderer>> call() {
		//Y → −FX−Y
		return Arrays.asList(
				minus(),
				f(),
				y(),
				minus(),
				y());
	}

	@Override
	public void renderDefault(DragonRenderer turtle) {
		turtle.y();
	}
}

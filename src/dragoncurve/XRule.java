package dragoncurve;

import static dragoncurve.DragonCurveFactory.x;
import static dragoncurve.DragonCurveFactory.y;
import static turtle.TurtleFactory.f;
import static turtle.TurtleFactory.plus;

import java.util.Arrays;
import java.util.List;

import shapegrammar.Node;
import shapegrammar.Rule;

public class XRule extends Rule<DragonRenderer> {

	@Override
	public List<Node<? super DragonRenderer>> call() {
		//X → X+YF+
		return Arrays.asList(
				x(),
				plus(),
				y(),
				f(),
				plus());
	}

	@Override
	public void renderDefault(DragonRenderer turtle) {
		turtle.x();
	}
}

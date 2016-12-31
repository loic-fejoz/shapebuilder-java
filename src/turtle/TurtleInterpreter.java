package turtle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import shapegrammar.Axiom;
import shapegrammar.Interpreter;
import shapegrammar.Node;

public class TurtleInterpreter<R extends Turtle> extends Interpreter<R> {
	
	protected static class UserRuleDeclaration {
		public char name;
		public String extension;
		public String defaultRendering;
		
		public UserRuleDeclaration(final char name2, final String extension2, final String defaultRendering2) {
			name = name2;
			extension = extension2;
			defaultRendering = defaultRendering2;
		}
	}
	
	protected Map<Character, UserRuleDeclaration> userRules = new HashMap<>();
	
	public TurtleInterpreter() {
		super();
	}

	public void declareRule(final char name, final String extension, final String defaultRendering) {
		userRules.put(name, new UserRuleDeclaration(name, extension, defaultRendering));
	}

	public Node<? super R> createAxiom(final String axioms) {
		return new Axiom<R>(interpret(axioms));
	}

	public List<Node<? super R>> interpret(final String extension) {
		final List<Node<? super R>> axiomsList = new LinkedList<>();
		for(char c: extension.toCharArray()) {
			if (userRules.containsKey(c)) {
				final Node<? super R> child = new UserRule<R>(this, userRules.get(c));
				axiomsList.add(child);
			} else {
				switch(c) {
				case 'F':
					axiomsList.add(new FConstant());
					break;
				case '+':
					axiomsList.add(new PlusConstant());
					break;
				case '-':
					axiomsList.add(new MinusConstant());
					break;	
				}
			}
		}
		return axiomsList;
	}
}

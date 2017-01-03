package turtle;

public class UserRuleDeclaration<V extends Turtle> {
	public char name;
	public String extension;
	public String defaultRendering;
	
	public UserRuleDeclaration(final char name2, final String extension2, final String defaultRendering2) {
		name = name2;
		extension = extension2;
		defaultRendering = defaultRendering2;
	}

	public void renderDefault(V renderer) {
		for(char c: defaultRendering.toCharArray()) {
			switch(c) {
			case 'F':
				renderer.forward();
				break;
			case '+':
				renderer.left();
				break;
			case '-':
				renderer.right();
				break;
			case '[':
				renderer.push();
				break;
			case ']':
				renderer.pop();
				break;
			default:
				throw new IllegalArgumentException("Unknown: " + c);
			}
		}
	}
}

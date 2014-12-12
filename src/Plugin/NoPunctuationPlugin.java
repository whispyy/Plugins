package Plugin;

public class NoPunctuationPlugin implements Plugin {

	@Override
	public String transform(String s) {
		String s1  = s;
		return s1.replaceAll("\\W", "");
	}

	@Override
	public String getLabel() {
		return "NoPunctuationPlugin";
	}

}

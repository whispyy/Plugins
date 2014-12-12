package Plugin;


public class ToUpperCasePlugin implements Plugin {

	@Override
	public String transform(String s) {
		String s1 = s;
		return s1.toUpperCase();
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "ToUpperCase";
	}

}

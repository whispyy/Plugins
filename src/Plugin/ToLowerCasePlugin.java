package Plugin;

public class ToLowerCasePlugin implements Plugin {

	@Override
	public String transform(String s) {
		String s1 = s;
		return s1.toLowerCase();
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "ToLowerCase";
	}

}

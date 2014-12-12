package Plugin;


public class JessePinkman implements Plugin {

	public JessePinkman() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transform(String s) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (String line : s.split("\n")){
			sb.append(line + " ... beach\n");
		}
		return new String(sb);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Jesse Pinkman";
	}

}

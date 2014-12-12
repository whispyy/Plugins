package Plugin;


public class JessePinkmanPlugin implements Plugin {


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

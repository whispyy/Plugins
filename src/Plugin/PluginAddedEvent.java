package Plugin;

import java.io.File;

/**
 * 
 * @author Jean-Frédéric Durand, Timothée Lefevbre
 *
 */
public class PluginAddedEvent implements Plugin{

	private File f;
	protected Plugin i;
	public PluginAddedEvent(File file){
		Class<?> classTest;
		try {
			classTest = Class.forName("plugin."
					+ file.getName().replaceFirst("\\.class$", ""));
			this.i = (Plugin) classTest.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if(file != null && file.exists())
			this.f = file;
	}

	public String getFile() {
		return this.f.getName();
	}

	@Override
	public String transform(String s) {
		// TODO Auto-generated method stub
		return this.i.transform(s);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return this.i.getLabel();
	}

}

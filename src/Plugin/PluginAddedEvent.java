package Plugin;

import java.io.File;

/**
 * 
 * @author Jean-Fr�d�ric Durand, Timoth�e Lefevbre
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

	/**
	 * Gives the file's name
	 * @return the file's name
	 */
	public String getFile() {
		return this.f.getName();
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Plugin.Plugin#transform(java.lang.String)
	 */
	public String transform(String s) {
		// TODO Auto-generated method stub
		return this.i.transform(s);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Plugin.Plugin#getLabel()
	 */
	public String getLabel() {
		// TODO Auto-generated method stub
		return this.i.getLabel();
	}

}

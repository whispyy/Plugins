package Plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

/**
 * 
 * @author Jean-Frederic Durand, Timothee Lefebvre
 *
 */
public class PluginFilter implements FilenameFilter {
	
	@Override
	public boolean accept(File dir, String name){
		if(!fileExtensionIsClass(name)){
			return false;
		}
		Class<?> theClass = getClass(dir, name);
		if(theClass == null){
			return false;
		}
		return inheritFromPlugin(theClass) && 
				classInPluginsPackage(theClass) && 
				classHasParameterLessConstructor(theClass);
	}
	/**
	 * Check if fileExtension is a class
	 * @param filename the file to test
	 * @return true if it's a class
	 */
	protected boolean fileExtensionIsClass(String filename){
		return filename.endsWith(".class");
	}
	
	/**
	 * get the class
	 * @param dir a directory
	 * @param filename the file to get the class
	 * @return the class
	 */
	protected Class<?> getClass(File dir, String filename){
		String classname = filename.replaceFirst("\\.class$", ".");
		try{
			return Class.forName("plugins"+classname);
		}
		catch (ClassNotFoundException c){
			return null;
		}
	}
	
	/**
	 * Check if the class inherit from Plugin
	 * @param theClass to test
	 * @return true if the class inherit
	 */
	protected boolean inheritFromPlugin(Class<?> theClass){
		return Plugin.class.isAssignableFrom(theClass);
	}
	
	/**
	 * Check if the class is in plugins package
	 * @param theClass to test
	 * @return true if the class is in.
	 */
	protected boolean classInPluginsPackage(Class<?> theClass){
		return theClass.getPackage().getName().equals("Plugins");
	}
	
	/**
	 * Check if the class constructor has no parameter
	 * @param theClass to test
	 * @return true if the class constructer has no parameter.
	 */
	protected boolean classHasParameterLessConstructor(Class<?> theClass){
		for(Constructor<?> constructor: theClass.getConstructors()){
			if(constructor.getParameterTypes().length == 0)
				return true;
		}
		return false;
	}
	
}

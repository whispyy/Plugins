import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;


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
	
	protected boolean fileExtensionIsClass(String filename){
		return filename.endsWith(".class");
	}
	
	protected Class<?> getClass(File dir, String filename){
		String classname = filename.replaceFirst("\\.class$", ".");
		try{
			return Class.forName("plugins"+classname);
		}
		catch (ClassNotFoundException c){
			return null;
		}
	}
	
	protected boolean inheritFromPlugin(Class<?> theClass){
		return Plugin.class.isAssignableFrom(theClass);
	}
	
	protected boolean classInPluginsPackage(Class<?> theClass){
		return theClass.getPackage().getName().equals("Plugins");
	}
	
	protected boolean classHasParameterLessConstructor(Class<?> theClass){
		for(Constructor<?> constructor: theClass.getConstructors()){
			if(constructor.getParameterTypes().length == 0)
				return true;
		}
		return false;
	}
	
}

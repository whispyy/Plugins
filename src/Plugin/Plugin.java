package Plugin;

/**
 * 
 * @author Jean-Fr�d�ric Durand, Timoth�e Lefevbre
 *
 */
public interface Plugin {

	/**
	 * transform is the operation who's set in the plugins file to modifiy text.
	 * @param s the String to be transformed
	 * @return the String transformed
	 */
	public String transform(String s);
	
	/**
	 * getLabel return the Label of the plugin.
	 * @return the Label
	 */
	public String getLabel();
}

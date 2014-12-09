package Plugin;

import java.util.EventListener;

/**
 * 
 * @author Jean-Frederic Durand, Timothee Lefebvre
 *
 */
public interface PluginEventListener extends EventListener{
	/**
	 * Add a plugin
	 * @param e the plugin added event
	 */
	void  pluginAdded(PluginAddedEvent e);
}

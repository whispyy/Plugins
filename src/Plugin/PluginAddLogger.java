package Plugin;

/**
 * 
 * @author Jean-Fr�d�ric Durand, Timoth�e Lefebvre
 *
 */
public class PluginAddLogger implements PluginEventListener{

	@Override
	/*
	 * (non-Javadoc)
	 * @see Plugin.PluginEventListener#pluginAdded(Plugin.PluginAddedEvent)
	 */
	public void pluginAdded(PluginAddedEvent e) {
		System.out.println(e.getFile());
		
	}

}

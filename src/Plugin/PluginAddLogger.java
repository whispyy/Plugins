package Plugin;

/**
 * 
 * @author Jean-Fr�d�ric Durand, Timoth�e Lefebvre
 *
 */
public class PluginAddLogger implements PluginEventListener{

	@Override
	public void pluginAdded(PluginAddedEvent e) {
		System.out.println(e.getFile());
		
	}

}

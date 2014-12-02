import java.util.EventListener;


public interface PluginEventListener extends EventListener{
	void  pluginAdded(PluginAddedEvent e);
}

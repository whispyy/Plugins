package Plugin;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class testPluginAddLogger {

	
	@Test
	public void testPluginAddedLogger() {
		File f = new File("test");
		PluginAddedEvent e = new PluginAddedEvent(f);
		assertNotNull(e);
		PluginAddLogger pal = new PluginAddLogger();
		pal.pluginAdded(e);
		assertNotNull(e);
	}

}

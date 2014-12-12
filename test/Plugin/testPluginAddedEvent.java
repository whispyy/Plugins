package Plugin;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class testPluginAddedEvent {
	private File f = new File("test");
	private PluginAddedEvent pae = new PluginAddedEvent(f);
	
	@Test
	public void testConstPluginAddedEvent(){
		assertNotNull(pae);
	}
	
	
	@Test
	public void testGetFile() {

		assertEquals(this.f.getName(), pae.getFile());
		
	}

}

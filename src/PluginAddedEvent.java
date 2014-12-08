import java.io.File;


public class PluginAddedEvent implements PluginEventListener{

	private File f;
	public PluginAddedEvent(File file){
		if(file != null && file.exists())
			this.f = file;
	}
	@Override
	public void pluginAdded(PluginAddedEvent e) {
		// TODO Auto-generated method stub
		
	}
	public String getFile() {
		return this.f.getName();
	}

}

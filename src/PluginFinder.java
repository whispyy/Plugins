import java.awt.event.ActionEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PluginFinder implements ActionListener{
	private static final int refreshInterval_ms = 1000;
	protected final File directory;
	protected final List<PluginEventListener> listeners = new ArrayList <PluginEventListener>();
	protected final ConfigurableTimer timer;
	protected Set<File> knownFiles = new HashSet<File>();
	protected PluginFilter filter;
	
	public PluginFinder(File directory){
		super();
		this.directory = directory;
		this.timer = new ConfigurableTimer(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Set<File> currentFiles = listFiles();
		Set<File> newFiles = new HashSet<File>(currentFiles);
		newFiles.removeAll(knownFiles);
		for (File file : newFiles){
			notifyListener(file);
		}
		knownFiles = currentFiles;
	}
	
	public Set<File> listFiles(){
		return new HashSet<File>(Arrays.asList(directory.listFiles(filter)));
	}
	
	protected void notifyListener(File file){
		ArrayList<PluginEventListener> listenerCopy;
		listenerCopy = new ArrayList<PluginEventListener>(listeners);
		for (PluginEventListener listener : listenerCopy){
			listener.pluginAdded(new PluginAddedEvent(file));
		}
	}
	
	public void start(){
		timer.start(refreshInterval_ms);
	}
			
	public synchronized void addListener(PluginEventListener listener){
		listeners.add(listener);
	}

	
}

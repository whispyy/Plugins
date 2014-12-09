package Plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Jean-Frederic Durand, Timothee Lefebvre
 *
 */
public class PluginFinder implements ActionListener{
	private static final int refreshInterval_ms = 1000;
	protected final File directory;
	protected final List<PluginEventListener> listeners = new ArrayList <PluginEventListener>();
	protected final ConfigurableTimer timer;
	protected Set<File> knownFiles = new HashSet<File>();
	protected PluginFilter filter;
	
	/**
	 * Constructor of plugin finder
	 * @param directory a file directory.
	 */
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
	
	/**
	 * List all files
	 * @return the hashset of the files.
	 */
	public Set<File> listFiles(){
		return new HashSet<File>(Arrays.asList(directory.listFiles(filter)));
	}
	
	/**
	 * Notify the Listener
	 * @param file the file.
	 */
	protected void notifyListener(File file){
		ArrayList<PluginEventListener> listenerCopy;
		listenerCopy = new ArrayList<PluginEventListener>(listeners);
		for (PluginEventListener listener : listenerCopy){
			listener.pluginAdded(new PluginAddedEvent(file));
		}
	}
	
	/**
	 * Start the timer
	 */
	public void start(){
		timer.start(refreshInterval_ms);
	}
	
	/**
	 * Add a listener
	 * @param listener the plugin event listener.
	 */
	public synchronized void addListener(PluginEventListener listener){
		listeners.add(listener);
	}

	
}

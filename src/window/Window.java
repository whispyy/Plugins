package window;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/*import javax.swing.JTextField;
import javax.swing.JTextPane;*/

import Plugin.ConfigurableTimer;
import Plugin.PluginEventListener;
import Plugin.PluginFinder;

/**
 * The graphical user interface of the program, composed of 
 * a menu and a text area to write text.
 * @author Jean-Frédéric Durand, Timothée Lefevbre
 *
 */
public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menu;
	private JMenu file, plugins;
	private JMenuItem clear, exit;
	private JPanel text_panel;
	private JTextArea text_field;
	
	private final File myplug = new File("./myplug");
	private final PluginFinder finder = new PluginFinder(myplug);
	
	public Window() throws HeadlessException {
		super();
		initWindow();
		// TODO Auto-generated constructor stub
	}

	public Window(GraphicsConfiguration gc) {
		super(gc);
		initWindow();
		// TODO Auto-generated constructor stub
	}

	public Window(String title) throws HeadlessException {
		super(title);
		initWindow();
		// TODO Auto-generated constructor stub
	}

	public Window(String title, GraphicsConfiguration gc) {
		super(title, gc);
		initWindow();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Initializes the Window, the text area and the menu.
	 */
	private void initWindow(){
		if (!this.myplug.exists())
			this.myplug.mkdir();
		this.text_panel = new JPanel();
		this.text_field = new JTextArea(30, 100);
		JScrollPane scroll = new JScrollPane(text_field);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.text_panel.setLayout(new BorderLayout());
		this.pack();
		this.setSize(300, 300);
		this.setVisible(true);
		
		//this.text_panel.add(text_field, BorderLayout.CENTER);
		this.text_panel.add(scroll, BorderLayout.CENTER);
		//this.getContentPane().add(menu_panel, BorderLayout.NORTH);
		this.getContentPane().add(text_panel, BorderLayout.SOUTH);
		this.initMenu();
	}

	/**
	 * Initializes the Window's menu.
	 */
	private void initMenu(){
		this.file = new JMenu("File");
		this.plugins = new JMenu("Plugins");
		this.exit = new JMenuItem("Exit");
		this.clear = new JMenuItem("Clear");
		this.menu = new JMenuBar();
		
		this.menu.add(file);
		this.menu.add(plugins);
		/*this.finder.addListener((PluginEventListener) plugins);*/
		this.file.add(clear);
		this.file.add(exit);
		this.exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		this.clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text_field.setText(new String());
			}
		});
		this.setJMenuBar(this.menu);
	}
	
	public static void main(String args[]){
		new Window();
	}
}

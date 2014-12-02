package window;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menu;
	private JMenu file, plugins;
	private JMenuItem clear, exit;
	private JPanel menu_panel;
	private JPanel text_panel;
	
	private JTextArea text_field;
	
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
	
	private void initWindow(){
		this.menu_panel = new JPanel();
		this.text_panel = new JPanel();
		this.text_field = new JTextArea(30, 100);
		JScrollPane scroll = new JScrollPane(text_field);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.menu_panel.setLayout(new BorderLayout());
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

	private void initMenu(){
		this.file = new JMenu("File");
		this.plugins = new JMenu("Plugins");
		this.exit = new JMenuItem("Exit");
		this.clear = new JMenuItem("Clear");
		this.menu = new JMenuBar();
		
		this.menu.add(file);
		this.menu.add(plugins);
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
		this.menu_panel.add(menu);
		this.setJMenuBar(this.menu);
	}
	
	public static void main(String args[]){
		Window w = new Window();
	}
}

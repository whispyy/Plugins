import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class ConfigurableTimer implements ActionListener{
	protected final int maxIteration;
	protected int nbrIteration;
	protected final ActionListener listener;
	
	public ConfigurableTimer(ActionListener l, int maxIteration){
		super();
		this.listener = l;
		this.maxIteration = maxIteration;
	}
	
	public ConfigurableTimer(ActionListener l){
		this(l,0);
	}
	
	public void start(int milliseconds){
		nbrIteration = 0;
		Timer timer = new Timer(milliseconds,(java.awt.event.ActionListener) this);
		timer.start();
		while(maxIteration == 0 || nbrIteration < maxIteration){
			System.err.print("");
		}
		timer.stop();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		nbrIteration++;
		listener.actionPerformed(e);
	}
}

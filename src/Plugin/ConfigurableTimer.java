package Plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * 
 * @author Jean-Frédéric Durand, Timothée Lefebvre
 *
 */
public class ConfigurableTimer implements ActionListener{
	protected final int maxIteration;
	protected int nbrIteration;
	protected final ActionListener listener;
	/**
	 * Constructor of the class ConfigurableTimer
	 * @param l an ActionListener
	 * @param maxIteration an integer
	 */
	public ConfigurableTimer(ActionListener l, int maxIteration){
		super();
		this.listener = l;
		this.maxIteration = maxIteration;
	}
	/**
	 * Other Constructor of the class ConfigurableTimer
	 * It defined the max iteration at 0 by default.
	 * @param l an ActionListener
	 */
	public ConfigurableTimer(ActionListener l){
		this(l,0);
	}
	
	/**
	 * Start the Timer
	 * @param milliseconds an integer
	 */
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

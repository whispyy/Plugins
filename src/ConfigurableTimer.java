
public class ConfigurableTimer implements ActionListener{
	protected final int maxIteration;
	protected final int nbrIteration;
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
		Timer timer = new ConfigurableTimer(milliseconds,this);
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

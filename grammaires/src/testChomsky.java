import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class testChomsky {
	private Grammar chomgra = new ChomskyGrammar();
	private Alphabet sigma = new Alphabet();
	private Variables V = new Variables();
	@SuppressWarnings("unchecked")
	private List<Regle> P = (List<Regle>) new Regle();
	
	public void chomsky(){
		SymboleTerminal a = new SymboleTerminal('a');
		SymboleTerminal b = new SymboleTerminal('b');
		this.sigma.addSymbole(a);
		this.sigma.addSymbole(b);
		this.chomgra.setAlphabet(sigma);
		
		SymboleNonTerminal S = new SymboleNonTerminal('S');
		this.V.addSymboles(S);
		this.chomgra.setVariables(V);
		
		((Regle) this.P).setGauche(S);
		((Regle) this.P).setDroite(a);
		this.chomgra.setRegles(P);	
	}

	
	@Test
	public void testReduite() {
		chomsky();
		assertTrue(this.chomgra.isReduite());
	}

	@Test
	public void testAccept(){
		assertTrue(this.chomgra.accept("a"));
		assertTrue(this.chomgra.accept("aa"));
		assertFalse(this.chomgra.accept("ab"));
	}
}

package ant.simulatore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


import java.util.*;

import org.junit.Before;
import org.junit.Test;
import ant.formica.*;
import ant.Cibo;
import ant.Coordinate;
import ant.formica.Esploratrice;
import ant.formica.Inseguitrice;

@SuppressWarnings("unused")
public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final private Coordinate origine = new Coordinate(0, 0);
	
	private Esploratrice formica ;
	private Inseguitrice altraFormica ;
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
		this.formica = this.simulatore.creaEsploratrice();
		this.altraFormica = this.simulatore.creaInseguitrice();
	}

	
	private Cibo creaCiboRaccoltoDaEsploratore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaEsploratrice());	
		return cibo;
	}

	private Cibo creaCiboRaccoltoDaInseguitore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaInseguitrice());	
		return cibo;
	}

	@Test
	public void testRaccoltoPerFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 3 ) SUGG.: USARE I METODI FACTORY SOPRA
		Cibo raccolto1 = creaCiboRaccoltoDaEsploratore();
		Cibo raccolto2 = creaCiboRaccoltoDaInseguitore();
		Cibo raccolto3 = creaCiboRaccoltoDaEsploratore();
		Set<Cibo> raccolta = new HashSet<>();
		raccolta.add(raccolto1);
		raccolta.add(raccolto2);
		raccolta.add(raccolto3);
		Map<Formica, Integer> formica2raccolta = stats.raccoltoPerFormica(raccolta);
		assertEquals(3, formica2raccolta.keySet().size());
	}
	
	@Test
	public void testRaccoltoPerTipoDiFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 4 ) SUGG.: USARE I METODI FACTORY SOPRA
		Cibo raccolto1 = creaCiboRaccoltoDaEsploratore();
		Cibo raccolto2 = creaCiboRaccoltoDaInseguitore();
		Cibo raccolto3 = creaCiboRaccoltoDaEsploratore();
		Set<Cibo> raccolta = new HashSet<>();
		raccolta.add(raccolto1);
		raccolta.add(raccolto2);
		raccolta.add(raccolto3);
		Map<Class<?>, Set<Cibo>> formica2raccolta = stats.raccoltoPerTipoDiFormica(raccolta);
		assertEquals(2, formica2raccolta.keySet().size());
		
	}
	
	
	
}

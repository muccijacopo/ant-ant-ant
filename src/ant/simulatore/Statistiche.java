package ant.simulatore;


import java.util.*;

import ant.Ambiente;
import ant.Cibo;
import ant.Formicaio;
import ant.formica.*;

public class Statistiche {

	synchronized public void stampaStatisticheFinali(Ambiente ambiente) {
		final Formicaio formicaio = ambiente.getFormicaio();

		final Set<Cibo> raccolto = formicaio.getCiboRaccolto();
		System.out.println("Totale cibo presente nel formicaio: " + raccolto.size());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Quantita' raccolta da ciascuna formica:");
		final Map<Formica,Integer> formica2quantita = raccoltoPerFormica(raccolto);
		stampaRaccoltoPerFormica(formica2quantita);
		System.out.println();

		// (VEDI DOMANDA 4)
		System.out.println("Quantita' di cibo raccolto per ciascuna tipologia di formica:");
		final Map<Class<?>,Set<Cibo>> tipologia2cibo = raccoltoPerTipoDiFormica(raccolto);
		stampaRaccoltoPerTipoDiFormica(tipologia2cibo);
		System.out.println();

		// (VEDI DOMANDA 5)
		System.out.println("Classifica finale delle strategie di raccolta:");
		final List<Class<?>> classificaTipo = ordinaStrategieDiRaccolta(tipologia2cibo);
		stampaClassificaStrategie(classificaTipo,tipologia2cibo);
		System.out.println();
	}


	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param raccolto - insieme di unita' di cibo raccolte
	 * @return una mappa che conti per ogni formica quante unita' di cibo ha raccolto
	 */
	public Map<Formica, Integer> raccoltoPerFormica(Set<Cibo> raccolto) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		// N.B. il tipo restituito e' migliorabile dopo aver svolto la domanda 2
		Map<Formica, Integer> formica2quantita = new HashMap<>();
		int conteggio = 0;
		for(Cibo c : raccolto) {
			Formica formica = c.getRaccoglitrice();
			if(formica2quantita.containsKey(formica)) {
				conteggio = formica2quantita.get(formica);
				conteggio++;
				formica2quantita.put(formica, conteggio);
			}
			else {
				formica2quantita.put(formica, 1);
			}
		}
		
		return formica2quantita;
	}


	/**
	 *  <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param formica2quantita
	 */
	private void stampaRaccoltoPerFormica(final Map<Formica, Integer> formica2quantita) {
		// N.B. il tipo del parametro e' migliorabile dopo aver svolto la domanda 2
		for(Formica formica : formica2quantita.keySet()) {
			Integer quantita = formica2quantita.get(formica);
			if (quantita==null)
				quantita = 0;
			System.out.println("La formica "+formica+" ha raccolto "+quantita);
		}
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 4)</B>
	 * @param raccolto - l'insieme di unita' di cibo raccolte
	 * @return una mappa che riporta per ciascuna tipologia di formiche quante unita' di cibo ha raccolto
	 */
	public Map<Class<?>, Set<Cibo>> raccoltoPerTipoDiFormica(Set<Cibo> raccolto) {
		// DA COMPLETARE (VEDI DOMANDA 4)
		Map<Class<?>, Set<Cibo>> raccolta = new HashMap<>();
		Set<Cibo> cibo;
		for(Cibo c : raccolto) {
			if(raccolta.containsKey(c.getRaccoglitrice().getClass())) {
				cibo = raccolta.get(c.getRaccoglitrice().getClass());
				cibo.add(c);
				raccolta.put(c.getRaccoglitrice().getClass(), cibo);
			}
			else
				cibo = new HashSet<>();
				cibo.add(c);
				raccolta.put(c.getRaccoglitrice().getClass(), cibo);
		}
		return raccolta;
	}

	/**
	 *  <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 4</EM>
	 * @param tipo2cibo
	 */
	private void stampaRaccoltoPerTipoDiFormica(final Map<Class<?>, Set<Cibo>> tipo2cibo) {
		if (tipo2cibo==null) return;

		for(Class<?> tipo : tipo2cibo.keySet()) {
			Set<Cibo> raccolto = tipo2cibo.get(tipo);
			System.out.println("Le formiche di tipo "+tipo.getSimpleName()+" hanno raccolto "+raccolto.size());
		}
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 5)</B>
	 * @param c2c una mappa che per ogni tipologia di formica riporta quante unita' ha raccolto
	 * @return una lista ordinata degli oggetti {@link Class} associati ai diversi tipi di {@link Formica}
	 */
	public List<Class<?>> ordinaStrategieDiRaccolta(final Map<Class<?>, Set<Cibo>> c2c) {
		// DA COMPLETARE (VEDI DOMANDA 5)
		class ComparatoreStrategiaDiRaccolta implements Comparator<Class<?>> {
			@Override
			public int compare(Class<?> c1, Class<?> c2) {
				return c2c.get(c1).size() - c2c.get(c2).size();
			}
		}
		
		ComparatoreStrategiaDiRaccolta cmp = new ComparatoreStrategiaDiRaccolta();
		List<Class<?>> classifica = new ArrayList<>(c2c.keySet());
		Collections.sort(classifica, cmp);
		return classifica;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 5</EM>
	 * @param classifica
	 * @param tipo2cibo
	 */
	private void stampaClassificaStrategie(List<Class<?>> classifica, Map<Class<?>, Set<Cibo>> tipo2cibo) {
		if (classifica==null) return;
		
		for(int i=1; i<classifica.size()+1; i++) {
			final Class<?> tipo = classifica.get(i-1);
			System.out.println(i+") "+tipo.getSimpleName()+" con "+tipo2cibo.get(tipo).size()+" unita' di cibo");
		}
	}
}

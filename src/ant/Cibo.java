package ant;

import ant.formica.Formica;

public class Cibo {

	private Coordinate posizione;
	
	/* DA CAMBIARE: VEDI DOMANDA 2 */
	private Formica formicaRaccoglitrice;
	
	public Cibo(Coordinate p) {
		this.posizione = p;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}
	
	public void setRaccoglitrice(Formica formica) {
		this.formicaRaccoglitrice = formica;
	}

	public Formica getRaccoglitrice() {
		return this.formicaRaccoglitrice;
	}

}

package ant.formica;
import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_ROSSA;

import java.awt.Image;
import java.util.Set;
import ant.Ambiente;
import ant.Direzione;

public class Aggressiva extends Formica {
	static private int progId=0;
	final private int id;

	public Aggressiva(Ambiente ambiente) {
		super(ambiente);
		this.id = progId++;
	}

	public int getId() {
		return this.id;
	}
	
	public Direzione decidiDirezione(Set<Direzione> possibili) {
		Direzione risultato = this.getDirezione();

		/* controlla se non sia il momento di cambiare direzione */
		if (decideDiCambiareDirezione() || deveCambiareDirezione(possibili))
			risultato = cambioDirezione(possibili);

		return risultato;
	}

	public boolean decideDiCambiareDirezione() {
		return true;
	}

	public Direzione cambioDirezione(Set<Direzione> possibili) {
		return Direzione.scegliAcasoTra(possibili);
	}

	public Image getImmagine() {
		return IMMAGINE_FORMICA_ROSSA;
	}

	
	
}

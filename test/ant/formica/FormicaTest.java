package ant.formica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ant.Ambiente;

/** 
 * Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite<BR/>
 * <B>(Vedi DOMANDA 2)</B>
 */
public class FormicaTest {

	private Ambiente ambiente;
	
	@Before
	public void setUp() throws Exception {
		this.ambiente = new Ambiente(1);
	}

	@Test
	public void testIdProgressiviPerEsploratrici() {
		Formica esploratrice1 = new Esploratrice(this.ambiente);
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, esploratrice1.getId());
		Formica esploratrice2 = new Esploratrice(this.ambiente);
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, esploratrice2.getId());
	}

	@Test
	public void testIdProgressiviPerInseguitrici() {
		Formica inseguitrice1 = new Inseguitrice(this.ambiente);
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 0, inseguitrice1.getId());
		Formica inseguitrice2 = new Inseguitrice(this.ambiente);
		assertEquals("Gli id sono progressivi base 0 per ciascun tipo dinamico!", 1, inseguitrice2.getId());
	}

}

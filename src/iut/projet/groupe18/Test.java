package iut.projet.groupe18;
import junit.framework.*;
/**
 * c'est la classe qui nous permetra d'empecher le plus d'erreur, car c'est ici que l'on test notre code
 * @author Audrey
 *
 */
public class Test extends TestCase
{
	//voir documment en annex
	
	//test si la choit du coupable est le bon
	public void testChoisirSuspect() throws ChoixInvalide{
		BarreDeMenu alfredCoupable = new BarreDeMenu(null);
		assertEquals(alfredCoupable.choisirSuspect(BarreDeMenu.SouMenuAlfred), true);
	}
	
	public void testPorte()throws ChoixInvalide{
		
	}
	
	public void testPersonnage()throws ChoixInvalide{
		
	}
	public void testPorte()throws ChoixInvalide{
	
}
	
}

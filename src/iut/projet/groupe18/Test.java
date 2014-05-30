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
		//c'est bisard!!! il faudrait peut etre déplacer la fonction dans une autre classe !!!
		Application alfredCoupable = new Application();
		assertEquals(alfredCoupable.choisirSuspect(alfred), true);
	}
}

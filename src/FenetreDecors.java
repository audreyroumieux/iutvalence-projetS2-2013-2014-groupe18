
/**
 * fenetre ou s'affiche le decors. on peut changer de decors en cliquent sur le portes 
 * et ainsi voir les supects sur les quel on peut cliquer pour discuter avec eux
 * @author roumieau
 */
public class FenetreDecors
{

	
	public FenetreDecors() {
		// TODO Auto-generated constructor stub
		
	}
	
	/**
	 * choix du suspect comme assassin 
	 * @param personne
	 * @return texte de reussite ou de perte
	 */
	public String choisirSuspect(Personnages personne)
	{
		if (personne.coupable == true)
			return "Felicitation vous avez gagné(e)!";
		return "ce n'est pas lui, essaye encore!";
	}

}

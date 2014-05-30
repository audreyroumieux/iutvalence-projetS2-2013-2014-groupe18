package iut.projet.groupe18;
/**
 * objet unique permetent de sauvgarder les choix passer du joueur 
 * @author roumieau
 */
public class Sauvegarde
{
	/**
	 * 
	 */
	private static Sauvegarde singletonSauvegarde; //il n'y a qu'une seul sauvgarde dans ce jeu.

	private Sauvegarde()
	{

	}

	// retourne la sauvgarde existante et peut creer une sauvgarde s'il y en a pas deja une
	public static Sauvegarde GetSauvegarde()
	{
		if (singletonSauvegarde == null)
		{
			singletonSauvegarde = new Sauvegarde();
		}
		return singletonSauvegarde;
	}
/**
 * initialisation des attributs a: false, car le joueur n'a pas encore discuter avec des personnages 
 */
public boolean aAccuserCusiniaire = false;
public boolean connaitDisputeDocteur = false;
public boolean convaincreDocteurDeParler = false;
public boolean aAccuserMadame = false;
public boolean presitionJardinDocteur = false;
public boolean presitionJardinAgnes = false;
public boolean presitionNervositer = false;

}

/**
 * objet unique permetent de sauvgarder les choix passer du joueur 
 * @author roumieau
 *
 */
public class Sauvegarde
{
	/**
	 * 
	 */
	private static Sauvegarde singletonSauvegarde;

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
	public boolean aParlerAalfred = false;
	public  boolean aParlerAbernadette = false;;

}

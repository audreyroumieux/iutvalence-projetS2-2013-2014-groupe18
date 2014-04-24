/**
 * main permetant de lancer le jeu
 * @author roumieau
 */
public class Application
{
	public static void main(String[] args)
	{
		//affichage du texte d'introduction
		System.out.println("Allo ? Je suis bien chez le détective % ? Je suis l'epouse du compte de Rochester qui a été assassiné dernièrement. "
				+ "Il est mort empalé par un couteau dans sa chambre et la police locale a conclue l’affaire comme étant un accident, suite à une mauvaise manipulation de l’outil. "
				+ " Mais je ne suis guerre convaincue par cette version des faits, des choses bizarres se sont déroulés avant cet incident. Je compte sur vous !");
		
		//creation des personnages
		Personnages alfred = new Personnages( "Alfred", "majordome" ,false);
		Personnages bernadette = new Personnages( "Bernadette", "Epouse du compte" ,false);
		Personnages françois = new Personnages( "François", "Fils" ,false);
		Personnages agnes = new Personnages( "Agnes", "Belle fille" ,true);
		Personnages robert = new Personnages( "Robert", "Ami et medecin du compte" ,false);
	}
}

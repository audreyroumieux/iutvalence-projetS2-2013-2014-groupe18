import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * main permetant de lancer le jeu
 * @author roumieau
 */
public class Application
{
	public static void main(String[] args)
	{
		// demande du nom du joueur:
		String nomDeDetective = (String)JOptionPane.showInputDialog(null,
        "Quel est votre nom ?\n"                   ,
        "Entrez votre nom",
        JOptionPane.PLAIN_MESSAGE,
        null,
        null,
        "Sherlock Holmes");
	//affichage du texte d'introduction
		JOptionPane.showMessageDialog(null,"Allo ? Je suis bien chez le détective "+nomDeDetective+" ?\n Je suis l'epouse du compte de Rochester qui a été assassiné dernièrement.\n "
				+ "Il est mort tué par un couteau dans sa chambre et la police locale a conclue l’affaire comme étant un accident, suite à une mauvaise manipulation de l’outil.\n "
				+ " Mais je ne suis guerre convaincue par cette version des faits, des choses bizarres se sont déroulés avant cet incident.\n Je compte sur vous !");
		
	//creation des personnages
		Personnages alfred = new Personnages( "Alfred", "majordome" ,false);
		Personnages bernadette = new Personnages( "Bernadette", "Epouse du compte" ,false);
		Personnages françois = new Personnages( "François", "Fils" ,false);
		Personnages agnes = new Personnages( "Agnes", "Belle fille" ,true);
		Personnages robert = new Personnages( "Robert", "Ami et medecin du compte" ,false);
		
	//creation d'un decors ou il y a alfred, ne peut etre changer
		Decors salleAmanger = new Decors(Arrays.asList(alfred));
		Decors chambre = new Decors(Arrays.asList(bernadette));
		salleAmanger.AjouterPortesVers(chambre);
		
	//creation de la fenetre decors dans la salleAmanger
		FenetreDecors fenetreDecor= new FenetreDecors(salleAmanger);
		
	}
	
}

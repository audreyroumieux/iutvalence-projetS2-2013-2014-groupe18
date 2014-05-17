import java.util.List;
import javax.swing.JFrame;

/**
 * represente la fenetre ou l'on peut cliquer sur les différente questions a poser au personnage
 * et ou l'on peut lire sa réponse
 * @author roumieau
 */
public class FenetreDialogue extends JFrame
{
	private Personnages perso;
	
	/**
	 * constructeur fenetre personnage
	 */
	public FenetreDialogue(Personnages personnage) {
		this.perso=personnage;
		setSize(600, 900); //taille de la fenetre en px
		AfficherPersonnage(personnage);
		AfficherTouteLesPhrase();
		setVisible(true);
	}

	/**
	 * affiche le personnage a qui on parle
	 * @param personnage
	 */
	public void AfficherPersonnage(Personnages personnage){
		 getContentPane().add(personnage);
	}
	
	/** 
	 *on affiche que les questions que le joueur peut poser en fonction de l'historique et de la lite total de phrase
	 * @return
	 */
	public Phrase AfficherTouteLesPhrase() { 
		for(Phrase phrase : personnage.ListeDePhrasesPosable)
		{
			AfficherPhrase(phrase);
		}
	}
	
	/**
	 *on rajoute dans le tableau de l'historique ou sauvgarde
	 * le nom du personnage a qui on parle
	 * ainsi que la prase sur la quel le joueur a cliquer
	 */
	public void AjoutSauvgarde(){
		
	}
	
	/**
	 * affiche une phrase
	 * @param phrase
	 */
	public void AfficherPhrase(Phrase phrase){
		getContentPane().add(phrase);
	}
}


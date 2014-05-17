import java.util.List;
import javax.swing.JButton;

/**
 * represente un suspect
 * @author roumieau
 */
public class Personnages extends JButton{

	/**
	 * nom, identifant du personnage
	 */
	public String nom; 
	/**
	 * contient la fonction et les caracteristiques du personnage 
	 */
	public String caracteristique;
	
	/**
	 * permet de savoir si c'est le coupable
	 */
	public final boolean coupable;
	
	public List<Phrase> ListePhrasesTotal;
	public List<Phrase> ListePhrasesPosable;
	
		
	
	//constructeur
	public Personnages (String nom, String caracteristique, boolean coupable)
	{
		super(nom);
		this.nom=nom;
		this.caracteristique= caracteristique;
		this.coupable=coupable;
	}
	
	/**
	 * 
	 * on  modifie les phrase possible grace au tableau de sauvgarde ou d'enregistrement 
	 * 
	 */
	private void ModifPhrasePossible(Personnages perso, Phrase question){
		
		if(phrase )//si la phrases est dans le tab de l'historique
			listeDePhrasePossible = listeDePhrasePossible + question;
	}
}

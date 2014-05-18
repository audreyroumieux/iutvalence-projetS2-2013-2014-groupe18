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
	
	public List<Phrase> ListePhrases;
	
	//constructeur
	public Personnages (String nom, String caracteristique, boolean coupable)
	{
		super(nom);
		this.nom=nom;
		this.caracteristique= caracteristique;
		this.coupable=coupable;
	}
	
	public void AjouterPhrase(Phrase phrase){
		this.ListePhrases.add(phrase);
	}
	
}

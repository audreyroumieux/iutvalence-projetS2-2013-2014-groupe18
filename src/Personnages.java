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
	
		
	
	//constructeur
	public Personnages (String nom, String caracteristique, boolean coupable)
	{
		super(nom);
		this.nom=nom;
		this.caracteristique= caracteristique;
		this.coupable=coupable;
	}
	
}

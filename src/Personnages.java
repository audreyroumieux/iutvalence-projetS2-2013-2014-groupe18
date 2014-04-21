
public class Personnages {

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
		this.nom=nom;
		this.caracteristique= caracteristique;
		this.coupable=coupable;
	}
	
}

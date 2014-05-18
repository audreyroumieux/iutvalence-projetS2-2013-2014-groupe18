
import java.util.ArrayList;
import java.util.List;
/**
 * un decors permet d'acceder a un autre decor par des porte
 * il est carctériser par les personnages qu'il contient
 * @author Audrey
 */
public class Decors
{
	public List<Personnages> ListeDePersonnages;
	public List<Portes> ListeDePortes;
	public final String NomPiece;
	
	/**
	 * constructeur de decor
	 * un decor est composer d'une liste de personnage et d'une liste de porte
	 * @param ListeDePersonnages
	 */
	public Decors(List<Personnages> ListeDePersonnages, String nomPiece) { //?
		this.ListeDePersonnages = ListeDePersonnages;
		ListeDePortes = new ArrayList<Portes>(); // initilalisation de la liste
		this.NomPiece = nomPiece;
		
	}
	/**
	 * ajoute a litse de porte la porte ou l'on va 
	 * ajoute au decor ou l'on va une porte qui va la ou on est pour pouvoir revenir
	 * @param decorOuOnVa
	 */
	public void AjouterPortesVers(Decors decorOuOnVa){
		Portes porte= new Portes(decorOuOnVa);
		this.ListeDePortes.add(porte); //appel de la methode ajouter a la liste
		Portes porteOuOnEst= new Portes(this);
		decorOuOnVa.ListeDePortes.add(porteOuOnEst);
		
	}
	/**
	 * permet de savoir combient d'objet il faudra afficher pour représenter le decor
	 * @return sum 
	 * c'est le total des objets que l'on a dans les listes en attribut
	 */
	public int NombreDobjet(){
		int sum;
		
		sum = ListeDePersonnages.size()+ListeDePortes.size();
		return sum;
	}
	
	
}

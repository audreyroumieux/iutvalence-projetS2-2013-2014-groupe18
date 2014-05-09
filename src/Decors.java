import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Audrey
 *
 */
public class Decors
{
	public List<Personnages> ListeDePersonnages;
	public List<Portes> ListeDePortes;
	
	public Decors(List<Personnages> ListeDePersonnages) {
		
		this.ListeDePersonnages = ListeDePersonnages;
		ListeDePortes = new ArrayList<Portes>(); // initilalisation de la liste
		
	}
	/**
	 * 
	 * @param decorOuOnVa
	 */
	public void AjouterPortesVers(Decors decorOuOnVa){
		
		Portes porte= new Portes(decorOuOnVa);
		this.ListeDePortes.add(porte); //appel de la methode ajouter a la liste
		
		Portes porteOuOnEst= new Portes(this);
		decorOuOnVa.ListeDePortes.add(porteOuOnEst);
		
	}
	/**
	 * 
	 * @return somme des objets que l'on a dans les listes en attribut
	 */
	public int NombreDobjet(){
		int sum;
		
		sum = ListeDePersonnages.size()+ListeDePortes.size();
		return sum;
	}
}

package iut.projet.groupe18;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * represente un suspect
 * @author roumieau
 */
public class Personnages
{
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
	
	/**
	 * lite contenent des phrases
	 */
	public List<Phrase> ListePhrases = new ArrayList<Phrase>();
	
	public ImageIcon imageVerticale ;
	public ImageIcon imageHorizontale;
	
	
	//constructeur
	public Personnages (String nom, String caracteristique, boolean coupable)
	{
		this.nom=nom;
		this.caracteristique= caracteristique;
		this.coupable=coupable;
		imageVerticale = new ImageIcon("Image/"+this.nom+".jpg");
		imageHorizontale = new ImageIcon("Image/"+this.nom+"horizontal.jpg");
	}
	
	/**
	 * ajoute une phrases a la liste de phrases
	 * @param phrase
	 */
	public void AjouterPhrase(Phrase phrase){
		this.ListePhrases.add(phrase);
	}

	
	

}

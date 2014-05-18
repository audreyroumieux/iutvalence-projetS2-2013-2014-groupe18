
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * fenetre ou s'affiche le decors. on peut changer de decors en cliquent sur le portes 
 * et ainsi voir les supects sur les quel on peut cliquer pour discuter avec eux
 * @author roumieau
 */
public class FenetreDecors extends JFrame
{
	
	/** constructeur de fenetreDecor
	 * @param decor
	 */
	public FenetreDecors(Decors decor) {
		setSize(800, 600);//taille de la fenetre en px
		this.AfficherDecor(decor);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//ferme le jeu lors de l'appuis sur la croix rouge
		setVisible(true);
	}
	
	/**
	 * affiche le decor dans fenetre decor
	 * @param decor
	 */
	public void AfficherDecor(Decors decor){

		this.setTitle(decor.NomPiece);// rajoute le nom de la salle ou l'on est dans la barre de titre
		int sum;
		sum = decor.NombreDobjet();
		getContentPane().setLayout(new GridLayout(1,sum));//sert a ranger les elements dans la fenetre
		
		for(Portes portes : decor.ListeDePortes) //pour toute les portes dans la liste de porte
		{
			AfficherPorte(portes);
		}
		for(Personnages personnages : decor.ListeDePersonnages){
			AfficherPersonnage(personnages);
		}
		this.revalidate();
		this.repaint();
	}
	
	/**
	 * affiche la porte et l'image de la porte
	 * l'image ne marche pas
	 * @param porte
	 */
	public void AfficherPorte(Portes porte){
		getContentPane().add(porte);
	}
	
	/**
	 * affiche le personnage du decor ou il est appeler
	 * @param personnage
	 */
	public void AfficherPersonnage(Personnages personnage){
		getContentPane().add(personnage);
	}
	
	/**
	 * permet de changer le decor de la fenetre decor
	 * @param decor
	 */
	public void ChangerDecor(Decors decor){
		getContentPane().removeAll();//efface le decor existant
		AfficherDecor(decor);
		
	}
	
	/** choix du suspect comme assassin 
	 * @param personne
	 * @return texte de reussite ou de perte
	 */
	public String choisirSuspect(Personnages personne){
		if (personne.coupable == true)
			return "Felicitation vous avez gagné(e)!";
		return "ce n'est pas lui, essaye encore!";
	}
}

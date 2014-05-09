import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * fenetre ou s'affiche le decors. on peut changer de decors en cliquent sur le portes 
 * et ainsi voir les supects sur les quel on peut cliquer pour discuter avec eux
 * @author roumieau
 */
public class FenetreDecors extends JFrame
{
	private Decors decor;
	/**
	 * 
	 * @param decor
	 */
	public FenetreDecors(Decors decor) {
		
		this.decor=decor;
		setSize(800, 600);//taille de la fenetre en px
		this.AfficherDecor(decor);
		setVisible(true);
	}
	
	/**
	 * 
	 * @param decor
	 */
	public void AfficherDecor(Decors decor){
		int sum;
		sum = decor.NombreDobjet();
		getContentPane().setLayout(new GridLayout(1,sum));//sert a ranger les elements dans la fenetre
		
		for(Portes portes : decor.ListeDePortes) //pour toute les portes dans la liste de porte
		{
			AfficherPorte(portes);
		}
		for(Personnages personnages : decor.ListeDePersonnages)
		{
			AfficherPersonnage(personnages);
		}
	}
	/**
	 * 
	 * @param porte
	 */
	public void AfficherPorte(Portes porte){
		getContentPane().add(porte);
	}
	
	public void AfficherPersonnage(Personnages personnage){
		getContentPane().add(personnage);
	}
	
	/**
	 * choix du suspect comme assassin 
	 * @param personne
	 * @return texte de reussite ou de perte
	 */
	public String choisirSuspect(Personnages personne)
	{
		if (personne.coupable == true)
			return "Felicitation vous avez gagné(e)!";
		return "ce n'est pas lui, essaye encore!";
	}

}

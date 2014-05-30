package iut.projet.groupe18;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * fenetre ou s'affiche le decors. on peut changer de decors en cliquent sur le
 * portes et ainsi voir les supects sur les quel on peut cliquer pour discuter
 * avec eux
 * 
 * @author roumieau
 */
public class FenetreDecors extends JFrame
{
	/**
	 * fenetre dialogue
	 */
	public FenetreDialogue fenetreDialogue;

	/**
	 * constructeur de fenetreDecor
	 * 
	 * @param decor
	 */
	public FenetreDecors(Decors decor)
	{
		setSize(1100, 600);// taille de la fenetre en px
		setLocation(100, 100);
		this.AfficherDecor(decor);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// ferme le jeu lors de
														// l'appuis sur la croix
														// rouge
		setVisible(true);
	}

	/**
	 * affiche le decor dans fenetre decor
	 * 
	 * @param decor
	 */
	public void AfficherDecor(Decors decor)
	{
		// rajoute le nom de la salle ou l'on est dans la barre de titre
		this.setTitle(decor.NomPiece);
		// creation d'un menu ou l'on poura accuser
		this.setJMenuBar(new BarreDeMenu(this));

		int sum;
		sum = decor.NombreDobjet();
		// sert a ranger les elements dans la fenetre
		getContentPane().setLayout(new GridLayout(1, sum));

		for (Portes portes : decor.ListeDePortes) // pour toute les portes dans
													// la liste de porte
		{
			AfficherPorte(portes);
		}
		for (Personnages personnages : decor.ListeDePersonnages)
		{
			AfficherPersonnage(personnages);

		}
		this.revalidate(); // prb avec pc iut les reconnait pas, il propose
							// invalidate qui fait tout beguer
		this.repaint();
	}

	/**
	 * affiche la porte et l'image de la porte l'image ne marche pas
	 * 
	 * @param porte
	 */
	public void AfficherPorte(Portes porte)
	{
		getContentPane().add(porte);
	}

	/**
	 * affiche le personnage du decor ou il est appeler
	 * 
	 * @param personnage
	 */
	public void AfficherPersonnage(final Personnages personnage)
	{
		
		JButton bouton = new JButton(personnage.nom, personnage.imageVerticale);
		bouton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				FenetreDialogue fenetreDialogue = new FenetreDialogue(personnage);
				
			}
		});
		getContentPane().add(bouton);
	}

	/**
	 * permet de changer le decor de la fenetre decor
	 * 
	 * @param decor
	 */
	public void ChangerDecor(Decors decor)
	{
		getContentPane().removeAll();// efface le decor existant
		AfficherDecor(decor); // affiche le nouveau decor

	}
}

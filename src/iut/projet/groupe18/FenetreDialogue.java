package iut.projet.groupe18;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * represente la fenetre ou l'on peut cliquer sur les différente questions a
 * poser au personnage et ou l'on peut lire sa réponse
 * 
 * @author roumieau
 */
public class FenetreDialogue extends JFrame
{

	public JLabel reponseDuPersonnage = new JLabel();
	private Personnages perso;

	/**
	 * constructeur fenetre personnage
	 */
	public FenetreDialogue(Personnages personnage)
	{
		setSize(600, 600); // taille de la fenetre en px
		this.perso = personnage;
		AfficherPersonnage(personnage);
		setVisible(true);
	}

	/**
	 * affiche le personnage a qui on parle
	 * 
	 * @param personnage
	 */
	public void AfficherPersonnage(Personnages personnage)
	{
		this.getContentPane().removeAll();
		int nombreDePhrasesDuPerso = CompterPhrasePosible(personnage);
		int nombreDeCasesDuLayout = (2 + nombreDePhrasesDuPerso);
		getContentPane().setLayout(new GridLayout(nombreDeCasesDuLayout, 1));
		getContentPane().add(new JLabel(personnage.imageHorizontale));
		getContentPane().add(this.reponseDuPersonnage);
		AfficherTouteLesPhrase(personnage);
		this.repaint();
		this.revalidate();
	}

	/**
	 * on affiche que les questions que le joueur peut poser en fonction de
	 * l'historique et de la lite total de phrase
	 * 
	 * @return
	 */
	public void AfficherTouteLesPhrase(Personnages perso)
	{
		for (Phrase phrase : perso.ListePhrases)
		{
			if (phrase.peutEtreDite())
			{
				AfficherPhrase(phrase);
			}
		}
	}

	/**
	 * affiche une phrase
	 * 
	 * @param phrase
	 */
	public void AfficherPhrase(final Phrase phrase)
	{

		JButton bouton = new JButton(phrase.texte);
		bouton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AfficherReponse(phrase.getReponse());

			}
		});
		getContentPane().add(bouton);
	}

	public void AfficherReponse(String reponse)
	{
		reponseDuPersonnage.setText(reponse);
		AfficherPersonnage(perso);

	}

	private int CompterPhrasePosible(Personnages personage)
	{
		int compteur = 0;
		for (Phrase phrase : personage.ListePhrases)
		{
			if (phrase.peutEtreDite())
				compteur++;
		}
		return compteur;
	}
}

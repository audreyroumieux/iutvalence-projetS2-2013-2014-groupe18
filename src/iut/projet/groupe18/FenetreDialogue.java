package iut.projet.groupe18;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		setSize(650, 720); // taille de la fenetre en px
		setLocation(100, 30);
		setAlwaysOnTop(true);
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
		getContentPane().setLayout(new GridLayout(2, 1));
		getContentPane().add(new JLabel(personnage.imageHorizontale));
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
		JPanel panelDesPhrases = new JPanel();
		int nombreDePhrases = CompterPhrasePosible(perso)+1;
		panelDesPhrases.setLayout(new GridLayout(nombreDePhrases,1));
		panelDesPhrases.add(reponseDuPersonnage);
		for (Phrase phrase : perso.ListePhrases)
		{
			if (phrase.peutEtreDite())
			{
				AfficherPhrase(phrase, panelDesPhrases);
			}
		}
		getContentPane().add(panelDesPhrases);
	}

	/**
	 * affiche une phrase
	 * 
	 * @param phrase
	 */
	public void AfficherPhrase(final Phrase phrase, JPanel panel)
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
		panel.add(bouton);
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

package iut.projet.groupe18;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class BarreDeMenu extends JMenuBar implements ActionListener

{
	/**
	 * La fenêtre à laquelle le menu est associé
	 */
	private JFrame fenetre;
	/**
	 * L'item de rubrique "Choisir le Coupable"
	 */
	private JMenu MenuItemChoisirCoupable;

	/**
	 * L'item de rubrique "fermer"
	 */
	private JMenuItem MenuItemFermer;

	private JMenuItem SouMenuAlfred = new JMenuItem("Alfred");
	private JMenuItem SouMenuMadame = new JMenuItem("Madame Rochester");
	private JMenuItem SouMenuFrançois = new JMenuItem("François");
	private JMenuItem SouMenuAgnes = new JMenuItem("Agnes");
	private JMenuItem SouMenuRobert = new JMenuItem("Robert");

	/**
	 * Création de la barre de menu
	 * 
	 * @param fenetre
	 *            à laquelle le menu est associé
	 */
	public BarreDeMenu(JFrame fenetre)
	{
		this.fenetre = fenetre;
		JMenu menu = new JMenu("Menu");
		this.MenuItemChoisirCoupable = new JMenu("Choisir le Coupable");
		this.MenuItemFermer = new JMenuItem("Fermer");

		menu.add(this.MenuItemChoisirCoupable);
		menu.add(this.MenuItemFermer);
		MenuItemChoisirCoupable.add(this.SouMenuAlfred);
		MenuItemChoisirCoupable.add(this.SouMenuMadame);
		MenuItemChoisirCoupable.add(this.SouMenuFrançois);
		MenuItemChoisirCoupable.add(this.SouMenuAgnes);
		MenuItemChoisirCoupable.add(this.SouMenuRobert);

		//permet d'associer un objet au menu item
		SouMenuAlfred.putClientProperty("personnage", Application.alfred);
		SouMenuFrançois.putClientProperty("personnage", Application.francois);
		SouMenuAgnes.putClientProperty("personnage", Application.agnes);
		SouMenuRobert.putClientProperty("personnage", Application.robert);
		SouMenuMadame.putClientProperty("personnage", Application.madameRochester);

		this.SouMenuAlfred.addActionListener(this);
		this.SouMenuMadame.addActionListener(this);
		this.SouMenuFrançois.addActionListener(this);
		this.SouMenuAgnes.addActionListener(this);
		this.SouMenuRobert.addActionListener(this);
		this.MenuItemFermer.addActionListener(this);
		this.add(menu);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		JMenuItem itemSelectionne = (JMenuItem) event.getSource();

		if (itemSelectionne == this.MenuItemFermer)
		{
			if (JOptionPane.showConfirmDialog(this.fenetre, "Voulez vous vraiment fermer l'application ?",
					"Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				this.fenetre.dispose();
			return;
		}
		else
		{
			Personnages personnageSelectioner;
			personnageSelectioner = (Personnages) itemSelectionne.getClientProperty("personnage");
			if (personnageSelectioner.coupable)
			{
				JOptionPane.showMessageDialog(null,
						"Felicitation, vous avez trouvé(e)! On a pu l'arrêter à tend grâce à vous, Merci!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ce n'est pas ce personnage le meurtrier, essaye encore!");
			}
		}

	}
}

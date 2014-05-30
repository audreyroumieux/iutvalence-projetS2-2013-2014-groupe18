package iut.projet.groupe18;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * represente une porte
 * 
 * @author roumieau
 */
public class Portes extends JButton
{

	private Decors decors;

	/**
	 * constructeur de porte
	 */
	public Portes(Decors decors)
	{
		super("Vers "+ decors.NomPiece, new ImageIcon("Image/porte.png"));
		this.decors = decors;
		addActionListener(new PorteActionListener(this.decors));
	}

	/**
	 * permet de savoir quel est le decor derière la porte
	 * 
	 * @return decors
	 */
	public Decors obtenirDecors()
	{
		return this.decors;
	}
	
	
	public class PorteActionListener implements ActionListener {
	
		
		private Decors decor;
		
		public PorteActionListener(Decors decor){
			this.decor = decor;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			Application.fenetreDecor.ChangerDecor(decor);
		}
	}
}

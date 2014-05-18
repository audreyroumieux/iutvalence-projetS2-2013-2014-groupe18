import javax.swing.JButton;

public abstract class Phrase extends JButton
{
	/**
	 * attribut contenent le texte a afficher
	 */
	public final String texte;

	/**
	 * methode qui renvoit la reponse a la question pose avant
	 * 
	 * @return
	 */
	public abstract String getReponse();

	public abstract boolean peutEtreDite();

	public Phrase(String texte)
	{
		this.texte = texte;
	}

	public static final Phrase Francois_meurtrier = new Phrase("Qui est le meurtrier selon vous ?")
	{

		@Override
		public boolean peutEtreDite()
		{
			return Sauvegarde.GetSauvegarde().aParlerAalfred && Sauvegarde.GetSauvegarde().aParlerAbernadette;
		}

		@Override
		public String getReponse()
		{
			return "Aucune idée !";
		}
	};
}

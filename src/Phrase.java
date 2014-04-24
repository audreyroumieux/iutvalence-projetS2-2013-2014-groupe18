
public abstract class Phrase
{
	/**
	 * attribut contenent le texte a afficher
	 */
	public final String texte;
	
	/**
	 * methode qui renvoit la reponse a la question pose avant
	 * @return
	 */
	public abstract String getReponse();
	
	public abstract boolean peutEtreDite();
	
	public Phrase(String texte){
		this.texte = texte;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Phrase p = new Phrase("Qui est le meurtrier selon vous ?")
		{
		
			@Override
			public boolean peutEtreDite()
			{
				return Sauvegarde.GetSauvegarde().aParlerAalfred
						&& Sauvegarde.GetSauvegarde().aParlerAbernadette;
			}
			
			@Override
			public String getReponse()
			{
				return "Aucune idée !";
			}
		};
	}

}

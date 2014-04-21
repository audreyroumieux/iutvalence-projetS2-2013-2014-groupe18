
public abstract class Phrase
{
	public final String texte;
	
	public abstract String getReponse();
	public abstract boolean peutEtreDite();
	public Phrase(String texte){
		this.texte = texte;
	}
	
	
	public static void main(String[] args)
	{
		Phrase p = new Phrase("Ou est le meurtrier ?")
		{
			
			@Override
			public boolean peutEtreDite()
			{
				return Sauvegarde.GetSauvegarde().aParlerAalfred
						&& Sauvegarde.GetSauvegarde().aParlerAuPerso2;
			}
			
			@Override
			public String getReponse()
			{
				return "Aucune idée !";
			}
		};
	}

}

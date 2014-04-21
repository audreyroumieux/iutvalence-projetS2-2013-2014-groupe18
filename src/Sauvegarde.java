public class Sauvegarde
{
	private static Sauvegarde singletonSauvegarde;

	private Sauvegarde()
	{

	}

	public static Sauvegarde GetSauvegarde()
	{
		if (singletonSauvegarde == null)
		{
			singletonSauvegarde = new Sauvegarde();
		}
		return singletonSauvegarde;
	}

	public boolean aParlerAalfred = false;
	public  boolean aParlerAuPerso2 = false;;

}

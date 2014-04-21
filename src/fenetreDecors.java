
public class fenetreDecors
{

	
	public fenetreDecors() {
		// TODO Auto-generated constructor stub
	}
	public String choisirSuspect(Personnages personne)
	{
		if (personne.coupable == true)
			return "Felisitation vous avezgagner";
		return "ce n'est pas lui, essaye encore!";
	}

}

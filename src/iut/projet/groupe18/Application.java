package iut.projet.groupe18;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * main permetant de lancer le jeu
 * @author roumieau
 */
public class Application
{
	//creation des personnages
		public static Personnages alfred = new Personnages( "Alfred", "le majordome", false);
		public static Personnages madameRochester = new Personnages( "Madame Rochester", "Epouse du compte", false);
		public static Personnages francois = new Personnages( "François", "le Fils", false);
		public static Personnages agnes = new Personnages( "Agnes", "la Belle fille", true);
		public static Personnages robert = new Personnages( "Le docteur Robert", "un Ami et le medecin du compte", false);
		public static Personnages leBlanc = new Personnages( "Madame Leblanc", "la femme de chambre", false);
	
	public static FenetreDecors fenetreDecor;
	
	/** main du jeu
	 * @param args
	 */
	public static void main(String[] args){
		// demande du nom du joueur:
		String nomDeDetective = (String)JOptionPane.showInputDialog(null,
        "<html>Quel est votre nom ?<br></htlm>",
        "Entrez votre nom",
        JOptionPane.PLAIN_MESSAGE,
        null,
        null,
        "Sherlock Holmes");
		
	//affichage du texte d'introduction
		JOptionPane.showMessageDialog(null,"<html>Allo ? Je suis bien chez le détective "+nomDeDetective+" ?<br> Je suis l'epouse du compte de Rochester qui a été assassiné dernièrement.<br> "
				+ "Il est mort tué par un couteau dans son bureau et la police locale a conclue l’affaire comme étant un accident, suite à une mauvaise manipulation de l’outil.<br> "
				+ " Mais je ne suis guère convaincue par cette version des faits, des choses bizarres se sont déroulés avant cet incident.<br> Je compte sur vous !</html>");
		
		
	//creation d'un decors ou il y a alfred, ne peut etre changer
		Decors entrer = new Decors(Arrays.asList(alfred), "Hall d'entrée");
		Decors salleAmanger = new Decors(new ArrayList<Personnages>(), "La Salle a Manger");
		Decors chambrefils = new Decors(new ArrayList<Personnages>(), "La Chambre de Francois et Agnes");
		Decors salleDeBain = new Decors(Arrays.asList(francois), "La Salle De Bain");
		Decors cuisine = new Decors(new ArrayList<Personnages>(), "La Cuisine");
		Decors salon = new Decors(Arrays.asList(madameRochester, robert), "Le Salon");
		Decors bibliothec = new Decors(new ArrayList<Personnages>(), "La bibliotheque");
		//Amelioration possible, mini jeu trouver objet a rajouter
		Decors bureau = new Decors(new ArrayList<Personnages>(), "Le Bureau du Comte");
		Decors chambreCompte = new Decors(Arrays.asList(leBlanc), "La chambre de Monsieur et Madame Rochester");
		Decors jardin = new Decors(Arrays.asList(agnes), "Le Jardin");
		
		entrer.AjouterPortesVers(salleAmanger);
		salleAmanger.AjouterPortesVers(chambrefils);
		chambrefils.AjouterPortesVers(salleDeBain);
		salleAmanger.AjouterPortesVers(cuisine);
		entrer.AjouterPortesVers(salon);
		salon.AjouterPortesVers(bibliothec);
		bibliothec.AjouterPortesVers(bureau);
		bureau.AjouterPortesVers(chambreCompte);
		entrer.AjouterPortesVers(jardin);
		
	//creation de la fenetre decors dans la salleAmanger
		fenetreDecor= new FenetreDecors(entrer);
		
		//ajout des dialogues;
		creerPhrasesAgnes();
		creerPhrasesAlfred();
		creerPhrasesFrancois();
		creerPhrasesLeblanc();
		creerPhrasesmadameRochester();
		creerPhrasesRobert();
		
	}
	
	public static void creerPhrasesAlfred()
	{
		Phrase phraseMeurtrierSelonAlfred = new Phrase("Qui est le meurtrier selon vous?")
		{
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
			@Override
			public String getReponse()
			{
				return "<html>je sais pas, peut être Madame Leblanc, la cuissinière. <br>"
						+ "Monsieur l'a surprise à lui derober une bouteille de rhum, alors qu'elle est sensée avoir arreté de boire.</html>";
			}
		};
		Phrase phraseHeureDuCrimeAlfred = new Phrase("Que faisiez-vous lors du crime ? ")
		{
			@Override
			public String getReponse()
			{
				return "Je servais le thé à Madamme, dans le salon.";
			}
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
		};
		Phrase phraseChosebizardSelonAlfred = new Phrase("Avez-vous remarqué des choses bizarres ces temps-ci ?")
		{
			@Override
			public String getReponse()
			{
				return "<html>Des choses bizarres, non je ne vois pas. <br>"
						+ " Si ce n'est qu'il était très méprisant avec nous, ses employés!</html>";
			}
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
		};

		alfred.AjouterPhrase(phraseMeurtrierSelonAlfred);
		alfred.AjouterPhrase(phraseHeureDuCrimeAlfred);
		alfred.AjouterPhrase(phraseChosebizardSelonAlfred);
	}
	
	public static  void creerPhrasesmadameRochester()
	{
		Phrase phraseMeurtrierSelonMadameRochester = new Phrase("Qui est le meurtrier selon vous? Votre mari avait-il des ennemis?")
		{
			@Override
			public boolean peutEtreDite()
			{
				return !Sauvegarde.GetSauvegarde().aAccuserMadame;
			}
			@Override
			public String getReponse()
			{
				return "<html>Je ne sais pas.Tout le monde n'aimait pas forcement mon mari, mais c'était un homme bon! <br>"
						+ " Mon pauvre mari...(snif)</html>";
			}
		};
		Phrase phraseHeureDuCrimeMadameRochester = new Phrase("Que faisiez-vous lors du crime ?")
		{
			@Override
			public String getReponse()
			{
				return "<html>Je prenais le thé dans le salon. Le majord'homme pourra en attester. <br>"
						+ "C'était très agréable, on pouvait entendre la melodie du piano d'où l'on était. <br> "
						+ "Autre chose?</html>";
			}
			@Override
			public boolean peutEtreDite()
			{
				return !Sauvegarde.GetSauvegarde().aAccuserMadame;
			}
		};
		Phrase phraseChosebizardSelonMadameRochester = new Phrase("Avez-vous remarqué des choses bizarres ces temps-ci ? ")
		{
			@Override
			public String getReponse()
			{
				Sauvegarde.GetSauvegarde().connaitDisputeDocteur = true;
				return "<html>Non, mais il était plus nerveux que d’habitude et parfois très désagréable. <br> "
						+ "Quoi que maintenent que vous m'y faites penser, il s'était disputé de façon violente avec le Docteur Robert.<br>"
						+ " Je n'ai pas compris le motif de leur dispute!</html>" ;
			}
			@Override
			public boolean peutEtreDite()
			{
				return !Sauvegarde.GetSauvegarde().aAccuserMadame;
			}
		};
		Phrase phraseColaireMadameRochester = new Phrase("Votre époux décédé, j'imagine que vous héritiez de toute sa fortune?")
		{
			@Override
			public String getReponse()
			{
				Sauvegarde.GetSauvegarde().aAccuserMadame = true;
				return "<html>NON, MAIS COMMENT OSEZ-VOUS?! <br>"
						+ "PARLER D'ARGENT, ALORS QUE JE VIENS DE PERDRE MON MARI!<br>"
						+ "PARTEZ, ET NE M'ADRESSEZ PLUS LA PAROLE!</html>" ;
			}
			@Override
			public boolean peutEtreDite()
			{
				return !Sauvegarde.GetSauvegarde().aAccuserMadame;
			}
		};

		madameRochester.AjouterPhrase(phraseMeurtrierSelonMadameRochester);
		madameRochester.AjouterPhrase(phraseHeureDuCrimeMadameRochester);
		madameRochester.AjouterPhrase(phraseChosebizardSelonMadameRochester);
		madameRochester.AjouterPhrase(phraseColaireMadameRochester);
	}
	
	public static void creerPhrasesFrancois()
	{
		Phrase phraseMeurtrierSelonFrancois = new Phrase("Qui est le meurtrier selon vous?")
		{
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
			@Override
			public String getReponse()
			{
				return "<html>Sans doute Madame Leblanc, apres tout c'est elle qui s'occupe de la cuisine ici. <br>"
						+ "Qui aurai pu avoir aussi facilement acces au couteau a part elle!</html>";
			}
		};
		Phrase phraseHeureDuCrimeFrancois = new Phrase("Que faisiez-vous lors du crime ?")
		{
			@Override
			public String getReponse()
			{
				return "Je jouais seul au piano dans ma chambre.";
			}
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
		};
		Phrase phraseChosebizardSelonFrancois = new Phrase("Avez-vous remarqué des choses bizarres ces temps-ci ? ")
		{
			@Override
			public String getReponse()
			{
				return "<html>La veille de l'accident, je me suis levé en plene nuit pour aller à la salle de bain.<br> "
						+ "Et j'ai cru apercevoir une silouette feminine entrer dans la cuisine! <br>"
						+ " Mais c'est sans doute sans importance!</html>" ;
			}
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
		};
		Phrase phraseDerniereFoiSelonFrancois = new Phrase("Comment était votre pere la derniere fois ou vous l'avez vue? ")
		{
			@Override
			public String getReponse()
			{
				Sauvegarde.GetSauvegarde().presitionNervositer = true;
				return "Normal, mais mon père était plus nerveux que d’habitude la veille de son décès.";
			}
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
		};
		Phrase phraseNerveuFrancois = new Phrase("Pour quel raison votre pere était il plus nerveu selon vous?? ")
		{
			@Override
			public String getReponse()
			{
				return "<html>Je sais qu’il avait des problèmes avec le personnel, <br> car nous sommes actuelement ruinés et donc nous les payons en retard.</html>" ;
			}
			@Override
			public boolean peutEtreDite()
			{
				return Sauvegarde.GetSauvegarde().presitionNervositer;
			}
		};

		francois.AjouterPhrase(phraseMeurtrierSelonFrancois);
		francois.AjouterPhrase(phraseHeureDuCrimeFrancois);
		francois.AjouterPhrase(phraseChosebizardSelonFrancois);
		francois.AjouterPhrase(phraseDerniereFoiSelonFrancois);
		francois.AjouterPhrase(phraseNerveuFrancois);
	}
	
	public static  void creerPhrasesRobert()
	{
		Phrase phraseMeurtrierSelonRobert = new Phrase("Qui est le meurtrier selon vous?")
		{
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
			@Override
			public String getReponse()
			{
				return "Je pense que c'est notre majord'homme. Je sais qu'il a déjà fait de la prison, mais je n'en sais pas plus.";
			}
		};
		Phrase phraseHeureDuCrimeRobert = new Phrase("Que faisiez-vous lors du crime ? ")
		{
			@Override
			public String getReponse()
			{
				Sauvegarde.GetSauvegarde().presitionJardinDocteur = true;
				return "Je faisais un tour seul dans le jardin.";
			}
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
		};
		Phrase phraseChosebizardSelonRobert = new Phrase("Avez-vous remarqué des choses bizarres ces temps-ci ? ")
		{
			@Override
			public String getReponse()
			{
				Sauvegarde.GetSauvegarde().presitionJardinDocteur = true;
				return "Rien de spécial, si ce n’est la mauvaise ambiance avec le personnel" ;
			}
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
		};
		Phrase phraseDisputeRobert = new Phrase("Quel était le motif de votre dispute avec monsieur le compte la veille du meurtre? ")
		{
			@Override
			public String getReponse()
			{
				Sauvegarde.GetSauvegarde().convaincreDocteurDeParler =true;
				return "Ho non! On ne s'est pas disputé, quel drôle d'idée!" ;
			}
			@Override
			public boolean peutEtreDite()
			{
				return Sauvegarde.GetSauvegarde().connaitDisputeDocteur;
			}
		};
		Phrase phraseExplicationRobert = new Phrase("<html>Madame la comptesse, nous a dit vous avoir entendu vous disputer avec la victime la veille.<br> Est-vous sur de rien vouloir nous dire?</html>")
		{
			@Override
			public String getReponse()
			{
				return "<html>Bon d'accord, j'avoue tout!<br>"
						+ " Il se trouve que monsieur le compte avait decouvert quelque chose qui me compremetait.<br>"
						+ " Et me faisait chanter avec cela. On s'était disputé la veille. <br>"
						+ "Il m'avait a nouveau réclamé une somme folle que je ne pouvais lui verser.</html>" ;
			}
			@Override
			public boolean peutEtreDite()
			{
				return Sauvegarde.GetSauvegarde().convaincreDocteurDeParler;
			}
		};
		Phrase phraseVueRobert = new Phrase("Avez vous vu quelqu'un dans le jardin lors de votre sortie? ")
		{
			@Override
			public String getReponse()
			{
				return "Je n'ai vu personne ";
			}
			@Override
			public boolean peutEtreDite()
			{
				return Sauvegarde.GetSauvegarde().presitionJardinDocteur && Sauvegarde.GetSauvegarde().presitionJardinAgnes;
			}
		};
		
		robert.AjouterPhrase(phraseMeurtrierSelonRobert);
		robert.AjouterPhrase(phraseHeureDuCrimeRobert);
		robert.AjouterPhrase(phraseChosebizardSelonRobert);
		robert.AjouterPhrase(phraseDisputeRobert);
		robert.AjouterPhrase(phraseExplicationRobert);
		robert.AjouterPhrase(phraseVueRobert);
	}
	
	public static void creerPhrasesAgnes()
	{
		Phrase phraseMeurtrierSelonAgnes = new Phrase("Qui est le meurtrier selon vous?")
		{
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
			@Override
			public String getReponse()
			{
				return "Je pense vraiment que c’est un complot de la cuisiniere et du majord'homme";
			}
		};
		Phrase phraseHeureDuCrimeAgnes = new Phrase("Que faisiez-vous lors du crime ? ")
		{
			@Override
			public String getReponse()
			{
				Sauvegarde.GetSauvegarde().presitionJardinAgnes =true;
				return "Je fumais seule dans le jardin";
			}
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
		};
		Phrase phraseVueAgnes = new Phrase("Avez-vous vu ou croisé quelqu'un dans le jardin lors de votre sortie? ")
		{
			@Override
			public String getReponse()
			{
				return "Je n'ai vu personne.";
			}
			@Override
			public boolean peutEtreDite()
			{
				return Sauvegarde.GetSauvegarde().presitionJardinAgnes && Sauvegarde.GetSauvegarde().presitionJardinDocteur;
			}
		};
		Phrase phraseChoseBizardSelonAgnes = new Phrase("Avez-vous remarqué des choses bizarres ces temps-ci ? ")
		{
			@Override
			public String getReponse()
			{
				return "Oui ! J’ai entendu des disputes assez violentes entre lui et son personnel." ;
			}
			@Override
			public boolean peutEtreDite()
			{
				return true;
			}
		};
		
		
		agnes.AjouterPhrase(phraseMeurtrierSelonAgnes);
		agnes.AjouterPhrase(phraseHeureDuCrimeAgnes);
		agnes.AjouterPhrase(phraseChoseBizardSelonAgnes);
		agnes.AjouterPhrase(phraseVueAgnes);
	}

	public static void creerPhrasesLeblanc()
	{
		Phrase phraseMeurtrierSelonMadameLeblanc = new Phrase("Qui est le meurtrier selon vous?")
		{
			@Override
			public boolean peutEtreDite()
			{
				return !Sauvegarde.GetSauvegarde().aAccuserCusiniaire;
			}
			@Override
			public String getReponse()
			{
				return "<html>Ne le répeter pas, mais je pense qu'il sagit de Madame.<br> "
						+ "Elle se plaint souvent de s'être mariée trop jeune et de n'avoir rien réalisé de sa vie. <br>"
						+ "Elle voulait devenir cantatrice.</html>";
			}
		};
		Phrase phraseHeureDuCrimeMadameLeblanc = new Phrase("Que faisiez-vous lors du crime ? ")
		{
			@Override
			public String getReponse()
			{
				return "<html>Je préparais le dîner dans la cuisine, c'était un plat très compliquée et un sorbet aux framboises.<br>"
						+ "Je n'ai pas quitté la cuisine de tout l'apres midi, car il faut remuer sans cesse. </html>";
			}
			@Override
			public boolean peutEtreDite()
			{
				return !Sauvegarde.GetSauvegarde().aAccuserCusiniaire;
			}
		};
		Phrase phraseChosebizardSelonMadameLeblanc = new Phrase("Avez-vous remarqué des choses bizarres ces temps-ci ? ")
		{
			@Override
			public String getReponse()
			{
				return "<html>Mon couteau de cuisine a disparu pendant la nuit précédent le meurtre de monsieur. <br> "
						+ "Je suis sure de l'avoir utilisé la veille.<br>"
						+ " Si j'avais su ce qui se passerait, je m'en serais davantage inquitée.</html>" ;
			}
			@Override
			public boolean peutEtreDite()
			{
					return !Sauvegarde.GetSauvegarde().aAccuserCusiniaire;
			}
		};
		
		Phrase phraseMeurtreLeblanc = new Phrase("Pourquoi avoir poignarder Monsieur Rochester? ")
		{
			@Override
			public String getReponse()
			{
				Sauvegarde.GetSauvegarde().aAccuserCusiniaire = true;
				return "<html>Je ... QUOI? Vous avez une drole de façon d'interoger les temoins! <br>"
						+ "Je vous pris de me laisser maintenant!</html>" ;
			}
			@Override
			public boolean peutEtreDite()
			{
				return !Sauvegarde.GetSauvegarde().aAccuserCusiniaire;
			}
		};

		leBlanc.AjouterPhrase(phraseMeurtrierSelonMadameLeblanc);
		leBlanc.AjouterPhrase(phraseHeureDuCrimeMadameLeblanc);
		leBlanc.AjouterPhrase(phraseChosebizardSelonMadameLeblanc);
		leBlanc.AjouterPhrase(phraseMeurtreLeblanc);
	}
}

package iut.projet.groupe18;
import javax.swing.JButton;

public abstract class Phrase {
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

	public Phrase(String texte)
	{
		this.texte = texte;
	}
	
	
}

import javax.swing.JButton;
/**
 * represente une porte
 * @author roumieau
 */
public class Portes extends JButton {
	
	private Decors decors;
	
	/**
	 * constructeur de porte
	 */
	public Portes (Decors decors){
		super("porte");
		this.decors = decors;
	}

	/**
	 * permet de savoir quel est le decor derière la porte
	 * @return decors
	 */
	public Decors obtenirDecors(){
		return this.decors;
	}
}

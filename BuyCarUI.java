import javax.swing.JOptionPane;

/*
 * @author Shweta
 * Launches message dialog box with provided message
 */
public class BuyCarUI {
	private final static String message = "Congratulations. You just bought a car!!";

	public static void launchUI() {
		JOptionPane.showMessageDialog(null, message);
		
	}
	
}

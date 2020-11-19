import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SouthEastPanel extends JPanel {
	private JPanel southEastPanel;
	private JButton spinButton, newGameButton;
	private FruitMachineController controllerObject;

	// southEastPanel constructor

	public SouthEastPanel(FruitMachineController controller) {

		controllerObject = controller; // pass the controller to the constructor

		// create a JPanel with Border Layout

		southEastPanel = new JPanel();
		southEastPanel.setLayout(new BorderLayout());
		Border buttons = BorderFactory.createEmptyBorder(60, 40, 60, 60); // create margins
		southEastPanel.setBorder(buttons); // set the margins to the panel

		/* create an inner JPanel with Grid Layout of 2 rows and 0 columns in order to
		 * display the 2 buttons*/

		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(2, 0, 10, 10));

		// create the JButtons

		spinButton = new JButton("Spin");
		spinButton.addActionListener(controllerObject); // track the clicks

		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(controllerObject); // track the clicks
		newGameButton.setEnabled(false); // create disabled new game button

		// add the JButtons to the inner panel

		innerPanel.add(spinButton);
		innerPanel.add(newGameButton);

		// add inner panel to southEastPanel

		southEastPanel.add(innerPanel);

	}

	// getter for JPanel

	public JPanel getPanel() {
		return southEastPanel;
	}

	// getter for spinButton

	public JButton getSpinButton() {
		return spinButton;
	}

	// getter for newGameButton

	public JButton getNewGameButton() {
		return newGameButton;
	}

}

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NorthWestPanel extends JPanel {
	private JPanel northWestPanel;
	private JLabel wallet, info, winnerLoser;
	private FruitMachineModel modelObject;

	// northWestPanel constructor

	public NorthWestPanel(FruitMachineModel model) {

		modelObject = model; // pass the model to the constructor

		// create a JPanel with Border Layout

		northWestPanel = new JPanel();
		northWestPanel.setLayout(new BorderLayout());
		Border text = BorderFactory.createEmptyBorder(1 / 40, 20, 20, 1 / 40); // create margins
		northWestPanel.setBorder(text); // set the margins to the panel

		/* create inner panel with grid Layout of 3 rows and 0 columns to display 3
		 * labels, one under the other*/

		JPanel innerNorthWestPanel = new JPanel();
		innerNorthWestPanel.setLayout(new GridLayout(3, 0, 0, 10));

		// create the JLabels

		wallet = new JLabel("Balance is " + modelObject.getBalance());
		info = new JLabel(modelObject.getInfo());
		winnerLoser = new JLabel(); // empty label, no winner or loser yet

		// if there is a winner or loser update the label winnerLoser

		if (modelObject.Winner() || modelObject.Loser()) {
			winnerLoser.setText(modelObject.getInfo());
			northWestPanel.add(winnerLoser, BorderLayout.SOUTH);
		}

		// add the labels to the innerPanel

		innerNorthWestPanel.add(wallet);
		innerNorthWestPanel.add(info);
		innerNorthWestPanel.add(winnerLoser);

		// add innerPanel to the northWestPanel

		northWestPanel.add(innerNorthWestPanel);

	}

	// getter for northWestPanel

	public JPanel getPanel() {
		return northWestPanel;
	}

	// update wallet and info

	public void updateInfo(String point, String newText) {
		wallet.setText(point);
		info.setText(newText);
	}

	// update winnerLoser

	public void update(String end) {
		winnerLoser.setText(end);
	}

}

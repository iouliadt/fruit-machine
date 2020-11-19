import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SouthWestPanel extends JPanel {
	private JPanel southWestPanel;
	private JLabel card1, card2, card3;
	private FruitMachineModel modelObject;

	// southWestPanel constructor

	public SouthWestPanel(FruitMachineModel model) {

		modelObject = model; // pass the model to the constructor

		/*
		 * create a JPanel with Grid Layout of 0 rows and 3 columns in order to display
		 * the 3 cards
		 */

		southWestPanel = new JPanel();
		southWestPanel.setLayout(new GridLayout(0, 3, 10, 30));
		Border oneCard = BorderFactory.createEmptyBorder(50, 20, 50, 20); // create margins
		southWestPanel.setBorder(oneCard);

		Border blackline = BorderFactory.createLineBorder(Color.black); // create a black line border

		// create first card JPanel and a JLabel to show which card

		JPanel firstCard = new JPanel();
		firstCard.setLayout(new BorderLayout()); // set layout of the first card panel
		card1 = new JLabel(modelObject.getCard(0)); // get first card
		firstCard.add(card1); // add the label to the first card panel
		card1.setHorizontalAlignment(JLabel.CENTER); // align the JLabel
		firstCard.setBackground(Color.yellow); // set background color to the first card panel
		firstCard.setBorder(blackline); // set the black line border to the card panel

		// create second card JPanel and a JLabel to show which card

		JPanel secondCard = new JPanel();
		secondCard.setLayout(new BorderLayout()); // set layout of the second card panel
		card2 = new JLabel(modelObject.getCard(1)); // get second card
		secondCard.add(card2); // add the label to the second card panel
		card2.setHorizontalAlignment(JLabel.CENTER); // align the JLabel
		secondCard.setBackground(Color.yellow); // set background color to the first card panel
		secondCard.setBorder(blackline); // set the black line border to the card panel

		// create third card JPanel and a JLabel to show which card

		JPanel thirdCard = new JPanel();
		thirdCard.setLayout(new BorderLayout()); // set layout of the second card panel
		card3 = new JLabel(modelObject.getCard(2)); // get second card
		thirdCard.add(card3); // add the label to the second card panel
		card3.setHorizontalAlignment(JLabel.CENTER); // align the JLabel
		thirdCard.setBackground(Color.yellow); // set background color to the first card panel
		thirdCard.setBorder(blackline); // set the black line border to the card panel

		// add the three card panels to the southWestPanel

		southWestPanel.add(firstCard);
		southWestPanel.add(secondCard);
		southWestPanel.add(thirdCard);

	}

	// getter for southWestPanel

	public JPanel getPanel() {
		return southWestPanel;
	}

	// update the cards

	public void updateLabel(String s1, String s2, String s3) {
		card1.setText(s1);
		card2.setText(s2);
		card3.setText(s3);
	}
}

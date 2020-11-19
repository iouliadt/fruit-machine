import java.awt.event.*;

public class FruitMachineController implements ActionListener {
	private FruitMachineView viewObject;
	private FruitMachineModel modelObject;

	// controller constructor

	public FruitMachineController(FruitMachineModel model) {
		modelObject = model;
	}

	// set view to controller

	public void setView(FruitMachineView view) {
		viewObject = view;
	}

	
	 //track events within a GUI update the model update the view
	 
	public void actionPerformed(ActionEvent e) {

		// if spinButton is clicked

		if (e.getSource() == viewObject.getSouthEastPanel().getSpinButton()) {
			modelObject.spinCards(); // spin the cards
			modelObject.updateBalance(); // update the balance

			viewObject.getSouthWestPanel().updateLabel(modelObject.getCard(0), modelObject.getCard(1),
					modelObject.getCard(2)); // update the labels of the cards

			// update the wallet and the info
			
			viewObject.getNorthWestPanel().updateInfo("Balance is " + modelObject.getBalance(), modelObject.getInfo()); 
																														

			// player wins or loses

			if (modelObject.Winner() || modelObject.Loser()) {
				viewObject.getSouthEastPanel().getSpinButton().setEnabled(false); // disable spinButton
				viewObject.getSouthEastPanel().getNewGameButton().setEnabled(true); // enable newGameButton
				viewObject.getNorthWestPanel().update(modelObject.getWinnerLoser()); // update winnerLoser label
			}
		}

		

		if (e.getSource() == viewObject.getSouthEastPanel().getNewGameButton()) { // if newGameButton is clicked

			modelObject.resetCard(); // reset the card sequence

			viewObject.getSouthWestPanel().updateLabel(modelObject.getCard(0), modelObject.getCard(1),
					modelObject.getCard(2)); // update the labels of the cards

			modelObject.resetBalance(); // reset the wallet
			modelObject.resetInfo(); // reset the info

			//update the wallet and the info
			
			viewObject.getNorthWestPanel().updateInfo("Balance is " + modelObject.getBalance(), modelObject.getInfo()); 

			viewObject.getSouthEastPanel().getSpinButton().setEnabled(true); // enable spinButton
			viewObject.getSouthEastPanel().getNewGameButton().setEnabled(false); // disable newGameButton

			viewObject.getNorthWestPanel().update(""); // update winnerLoser label
		}
	}
}
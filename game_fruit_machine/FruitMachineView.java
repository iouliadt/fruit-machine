import javax.swing.*;
import java.awt.*;

public class FruitMachineView extends JFrame {
	private NorthWestPanel northWestPanel;
	private NorthEastPanel northEastPanel;
	private SouthWestPanel southWestPanel;
	private SouthEastPanel southEastPanel;

	public FruitMachineView(FruitMachineModel model, FruitMachineController controller) {

		// create the basic window

		InitialElements();

		// create 4 panels and add them to the window

		northWestPanel = new NorthWestPanel(model);
		northEastPanel = new NorthEastPanel();
		southWestPanel = new SouthWestPanel(model);
		southEastPanel = new SouthEastPanel(controller);

		this.add(northWestPanel.getPanel());
		this.add(northEastPanel.getPanel());
		this.add(southWestPanel.getPanel());
		this.add(southEastPanel.getPanel());

	}

	private void InitialElements() {

		// properties of the main window

		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setLayout(new GridLayout(2, 2)); // split the main window into 4 sub-windows (with gridLayout 2 rows and columns)
											
		setTitle("FruitMachine GUI");

	}

	// getter for northWestPanel

	public NorthWestPanel getNorthWestPanel() {
		return northWestPanel;
	}

	// getter for southWestPanel

	public SouthWestPanel getSouthWestPanel() {
		return southWestPanel;
	}

	// getter for southEastPanel

	public SouthEastPanel getSouthEastPanel() {
		return southEastPanel;
	}

}

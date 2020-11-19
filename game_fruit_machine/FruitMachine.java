public class FruitMachine {

	public static void main(String[] args) {
		
		/* create model , controller, view
		 * and pass the view to the controller*/ 
		
		FruitMachineModel model = new FruitMachineModel();
		FruitMachineController controller = new FruitMachineController(model);
		FruitMachineView view = new FruitMachineView(model, controller);

		controller.setView(view);
		view.setVisible(true);

	}
}

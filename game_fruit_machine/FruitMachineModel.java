import java.util.Random;

public class FruitMachineModel {
	private int wallet;
	private Random rand = new Random();
	private String[] myCardPool = { "Ace", "King", "Queen", "Jack", "Joker" };
	private String[] myCardSequence;
	private String info;
	private String winnerLoser;

	// create a wallet object with balance 100

	public FruitMachineModel() {

		this.wallet = 100;        //initially the wallet has 100 points
		this.info = "Welcome!";   //welcome message
		this.myCardSequence = new String[] { "King", "Queen", "Jack" };//initialise cards

	}

	// spin a new sequence of cards

	public void spinCards() {
		this.myCardSequence = new String[] { myCardPool[rand.nextInt(5)], myCardPool[rand.nextInt(5)],
				myCardPool[rand.nextInt(5)] };
	}

	// getter for the card

	public String getCard(int n) {
		return myCardSequence[n];
	}

	// reset the card sequence for new game

	public void resetCard() {
		this.myCardSequence = new String[] { "King", "Queen", "Jack" };
	}

	// check the card sequence and credit the points to the wallet

	public int updateBalance() {

		if (myCardSequence[0] == "Joker" || myCardSequence[1] == "Joker" || myCardSequence[2] == "Joker") { // if there is a Joker
			if (myCardSequence[0] == myCardSequence[1] && myCardSequence[1] == myCardSequence[2]) {   // if all the cards are the same it means there are 3 jokers
				this.wallet = wallet - 75;                                                            //then 75 points are subtracted from wallet(balance)                                  
				this.info = "3 Jokers: you lose 75 points"; 
			} else if (myCardSequence[0] == "Joker" && myCardSequence[1] == "Joker") {  // if the jokers are not three but first and second cards are jokers
				this.wallet = wallet - 50;                                              // 50 points are subtracted from wallet
				;
				this.info = "2 Jokers: you lose 50 points"; 
			} else if (myCardSequence[0] == "Joker" && myCardSequence[2] == "Joker") { // if the jokers aren't three but first and third cards are jokers
				this.wallet = wallet - 50;                                             // -50 points
				;
				this.info = "2 Jokers: you lose 50 points";                 
			} else if (myCardSequence[1] == "Joker" && myCardSequence[2] == "Joker") { // if the jokers aren't three but second and third cards are jokers
				this.wallet = wallet - 50;                                             //-50 points
				;
				this.info = "2 Jokers: you lose 50 points";
			} else {
				this.wallet = wallet - 25; // if there is only one joker, -25 points
				this.info = "1 Joker: you lose 25 points";
			}
		} else {
			if (myCardSequence[0] == myCardSequence[1] && myCardSequence[1] == myCardSequence[2]) { //if three of a kind
				this.wallet = wallet + 50;                                                          //+50 points
				this.info = "Three of a kind - you win 50 points";
			} else if (myCardSequence[0] == myCardSequence[1] || myCardSequence[1] == myCardSequence[2]
					|| myCardSequence[0] == myCardSequence[2]) {// if there are no three of a kind but two cards are the same
				this.wallet = wallet + 20;                      // +20 points
				this.info = "Two of a kind - you win 20 points";
			} else {                                            // if all the cards are different, balance does not change
				this.info = "Balance unchanged"; 
			}
		}
		return wallet;
	}

	// getter for balance

	public int getBalance() {
		return this.wallet;
	}

	// reset the balance for new game

	public void resetBalance() {
		this.wallet = 100;
	}

	// getter for message

	public String getInfo() {
		return this.info;
	}

	// reset message

	public void resetInfo() {
		this.info = "Welcome!";
	}

	// check if the player has won

	public boolean Winner() {
		if (wallet >= 150) { // if balance is greater or equal to 150, the player wins
			this.winnerLoser = "You win!";
			return true;
		} else {
			return false;
		}
	}

	// check if the player has lost

	public boolean Loser() {
		if (wallet < 0) {   // if balance is less than zero, a player loses
			this.winnerLoser = "You Lose!";
			return true;
		} else {
			return false;
		}
	}

	// getter for result

	public String getWinnerLoser() {
		return this.winnerLoser;
	}
}

//com truise - Iteration
//Of your fake dimention:1
//Ephemeron : 2
//
import java.util.Scanner;

public class tictactest {

	public static void main(String args[] ) {
		TicTacToeGame test = new TicTacToeGame();
		Scanner in =  new Scanner(System.in);
		System.out.println("welcome to tictactoe!");
		System.out.println("would you like pvp to be enabled? 1/0");
		int a = in.nextInt();
		if(a==1){
			test.multiplayer(true);
		}else if(a==0){
			test.multiplayer(false);
		}else{
			System.out.println("Alright thanks for picking a number");
			System.out.println("Ill just set you up against a human, you have friends right?");
			test.multiplayer(true);
		}
		int move = 0;
		System.out.println("Setting up board");
		test.set();
		System.out.println("looking good :)");
		while(true){
			test.display();
			if (test.isWon()||test.isDone()){
				break;
			}
			test.isTurn();
			if(test.whatTurn()){
				System.out.println("Alrght, please input your next move");
				move = in.nextInt();
				if(test.isValid(move)){
					test.place(move);
					test.turnSwitch();
				}else{
					System.out.println("Sorry that turn is invalid");
				}
			}else{
				if(test.isPvp()){
					System.out.println("Alrght, please input your next move");
					move = in.nextInt();
					if(test.isValid(move)){
						test.place(move);
						test.turnSwitch();
					}else{
						System.out.println("Sorry that turn is invalid");
					}

				}else{
					System.out.println("a l r i g h t, i m m a  g o  h e r e");
					test.cpuPlace();
					test.turnSwitch();
				}

			}
		}
		if(test.isWon()) {
			if(!test.whatTurn()){
				System.out.println("Player 1 won");
			}else{
				if(test.isPvp()){
					System.out.println("Player 2 won");
				}else{
					System.out.println("bot won, humans S U C K");
				}
			}
			System.out.println("someone won");
		}else {
			System.out.println("no one won");
		}
	}
}

import java.util.Scanner;

public class tictactest {

	public static void main(String args[] ) {
		TicTacToeGame test = new TicTacToeGame();
		Scanner in = new Scanner(System.in);
		int pos = 0;
		System.out.println("hello, welcome to my game of tic tac toe");
		System.out.println("Would you like to play with a computer? (1/0)");
		if(in.nextInt()==0) {
			test.pvp(true);
		}
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.println("Alright, setting up board");
		test.set();
		test.display();
		System.out.println("Alright just type a number in to place there");
		for(int z = 0; z<9; z++) {
			System.out.println("Pop a new number in babeee");
			test.whatTurn();
			pos = in.nextInt();
			if(test.isValid(pos)) {
				test.place(pos);
				test.turnSwitch();
				test.xoSwitch();
			}
			if(test.isWon()) {
				break;
			}
			for (int i = 0; i < 50; ++i) System.out.println();
			if(!test.isValid(pos)){
				System.out.println("Invalid move");
			}
			test.display();
		}
		System.out.println("ALRIGHT THE GAMES DONE");
		if(test.isWon()) {
			System.out.println("YOU WIN");
		}else
			System.out.println("TIE TIE TIE");
	}
}

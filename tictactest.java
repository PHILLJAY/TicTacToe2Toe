
public class tictactest {

	public static void main(String args[] ) {
		TicTacToeGame test = new TicTacToeGame();
		test.display();
		test.multiplayer(true);
		test.multiplayer(false);
		test.update();
		test.display();
		test.set();
		test.place(3);
		test.update();
		test.display();
		if(test.isValid(3)) {
			System.out.println("Valid move bro");
		}else {
			System.out.println("inValid move bro");
		}
		System.out.println();

		
/*		String temp = "x";
		int[][] tic = new int [3][3];
		String[][] tac = new String [3][3];
		for(int x = 0; x<3; x++) {
			for(int y = 0; y<3; y++ ) {
				tac[x][y] = Integer.toString(y*3 + x +1);
			}
		}
				for(int x = 0; x<3; x++) {
			for(int y = 0; y<3; y++ ) {
				if(tic[x][y] == 0) {
					tac[x][y] = "x";
				}
				if(tic[x][y] == 1) {
					tac[x][y] = "O";
				}
				if(tic[x][y] == 2) {
				}
			}
		}
	*/	 
		//		System.out.println("  " + tac[0][0] +" | " + tac[1][0] + " | " + tac[2][0] + "  ");
		//		System.out.println(" ---|---|--- ");
		//		System.out.println("  " + tac[0][1] +" | " + tac[1][1] + " | " + tac[2][1] + "  ");
		//		System.out.println(" ---|---|--- ");
		//		System.out.println("  " + tac[0][2] +" | " + tac[1][2] + " | " + tac[2][2] + "  ");
	}
}

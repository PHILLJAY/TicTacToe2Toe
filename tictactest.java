
public class tictactest {

	public static void main(String args[] ) {
		String temp = "x";
		int[][] tic = new int [3][3];
		tic[0][0] = 0;
		tic[1][0] = 1;
		tic[2][0] = 2;
		tic[0][1] = 0;
		tic[1][1] = 1;
		tic[2][1] = 2;
		tic[0][2] = 0;
		tic[1][2] = 1;
		tic[2][2] = 2;

		String[][] tac = new String [3][3];
		tac[0][0] = "1";
		tac[1][0] = "2";
		tac[2][0] = "3";
		tac[0][1] = "4";
		tac[1][1] = "5";
		tac[2][1] = "6";
		tac[0][2] = "7";
		tac[1][2] = "8";
		tac[2][2] = "9";
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
		System.out.println("  " + tac[0][0] +" | " + tac[1][0] + " | " + tac[2][0] + "  ");
		System.out.println(" ---|---|--- ");
		System.out.println("  " + tac[0][1] +" | " + tac[1][1] + " | " + tac[2][1] + "  ");
		System.out.println(" ---|---|--- ");
		System.out.println("  " + tac[0][2] +" | " + tac[1][2] + " | " + tac[2][2] + "  ");
	}
}


public class TicTacToeGame {
	private boolean turn;//If this = true then x plays, if false 0 plays
	private boolean pvp;// If this = true then its p1 vs p2, if false it is human vs bot
	private boolean start;// if true, when using bot, this will determine if the human or bot starts
	private int[][] tic = new int [3][3];
	private String[][] tac = new String [3][3];

	TicTacToeGame(){
		turn = true;
	}//TODO Add a .isvalid test
	public boolean isValid(int z) {
		double d = z;
		if(z<1||z>9) {
			return false;
		}
		if(tic[(z-1)%3][(z-1)/3]==0) {;
		return true;
		}
		return false;
	}
	public void place(int z) {//returns false if move can not be completed. In the future create a method that checks if valid before placing anything
		int toe = 1;
		if(this.isValid(z)) {
			tic[(z-1)%3][(z-1)/3]=toe;
		}

	}
	

	public void display() {
		System.out.println("  " + tac[0][0] +" | " + tac[1][0] + " | " + tac[2][0] + "  ");
		System.out.println(" ---|---|--- ");
		System.out.println("  " + tac[0][1] +" | " + tac[1][1] + " | " + tac[2][1] + "  ");
		System.out.println(" ---|---|--- ");
		System.out.println("  " + tac[0][2] +" | " + tac[1][2] + " | " + tac[2][2] + "  ");
	}
	public void set() {
		for(int x = 0; x<3; x++) {
			for(int y = 0; y<3; y++ ) {
				tac[x][y] = Integer.toString(y*3 + x +1);
			}
		}
	}
	public void multiplayer (boolean blegh) {
		pvp = false;
		if(blegh) {
			pvp = true;
		}
		System.err.println(blegh);
	}
	public void update() {
		for(int x = 0; x<3; x++) {
			for(int y = 0; y<3; y++ ) {
				if(tic[x][y] == 0) {
				}
				if(tic[x][y] == 1) {
					tac[x][y] = "O";
				}
				if(tic[x][y] == 2) {
					tac[x][y] = "x";
				}
			}
		}
	}

}

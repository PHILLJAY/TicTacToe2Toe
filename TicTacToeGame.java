
public class TicTacToeGame {
	private boolean turn;//If this = true then p1 plays, if false p2 plays
	private boolean xo; // if true, x goes, if false, o goes
	private boolean pvp;// If this = true then its p1 vs p2, if false it is human vs bot
	private boolean start;// if true, when using bot, this will determine if the human or bot starts
	private int[][] tic = new int [3][3];
	private String[][] tac = new String [3][3];


	TicTacToeGame(){
		turn = true;
		pvp = true;
		xo = true;

	}//TODO Add a .isvalid test
	public boolean isPvp(){
		return pvp;
	}
	public boolean isXO(){
		return xo;
	}
	public void cpuPlace(){

	}

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
	public void turnSwitchOnly(){
		turn =! turn;
	}
	public void turnSwitch(){
		turn =! turn;
		xo =! xo;
	}
	public void isTurn(){
		if (turn){
			System.out.println("It is player 1s turn");
		}else{
			if(pvp){
				System.out.println("It is player 2s turn");
			}else{
				System.out.println("it is robots turn");
			}
		}		
	}
	public boolean whatTurn(){
		if (turn){
			return true;
		}else{
			if(pvp){
				return false;
			}else{
				return false;
			}
		}
	}
	public boolean isWon() {
		for(int y = 0; y<3; y++) {//check rows
			if(Math.abs(tic[0][y]+tic[1][y]+tic[2][y])==3) {
				return true;
			}
		}
		for(int x = 0; x<3; x++) {//check columns
			if(Math.abs(tic[x][0]+tic[x][1]+tic[x][2])==3) {
				return true;
			}
		}
		if(Math.abs(tic[0][0]+tic[1][1]+tic[2][2])==3) {
			return true;
		}
		if(Math.abs(tic[0][2]+tic[1][1]+tic[2][0])==3){
			return true;
		}

		return false;
	}


	public void place(int z) {//returns false if move can not be completed. In the future create a method that checks if valid before placing anything
		int toe = -1;
		if(xo){
			toe = 1;
		}
		if(this.isValid(z)) {
			tic[(z-1)%3][(z-1)/3]=toe;
		}

	}
	public void display() {
		for(int x = 0; x<3; x++) {
			for(int y = 0; y<3; y++ ) {
				if(tic[x][y] == 0) {
				}
				if(tic[x][y] == -1) {
					tac[x][y] = "O";
				}
				if(tic[x][y] == 1) {
					tac[x][y] = "x";
				}
			}
		}
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
				if(tic[x][y] == -1) {
					tac[x][y] = "O";
				}
				if(tic[x][y] == 1) {
					tac[x][y] = "x";
				}
			}
		}
	}

}

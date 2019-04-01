import java.util.Scanner;

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

	}
	public void play() {
		Scanner in =  new Scanner(System.in);
		System.out.println("welcome to tictactoe!");
		System.out.println("would you like pvp to be enabled? [Y] [N]");
		String a = in.nextLine();
		if(a.equalsIgnoreCase("y")){
			this.multiplayer(true);
		}else if(a.equalsIgnoreCase("n")){
			this.multiplayer(false);
		}else{
			System.out.println("Alright thanks for picking a number");
			System.out.println("Ill just set you up against a human, you have friends right?");
			this.multiplayer(true);
		}
		if(!this.pvp) {
			System.out.println("Would you like to start? [Y] [N]");
			String start = in.nextLine();
			if(start.equalsIgnoreCase("n")) {
				this.turnSwitchOnly();
			}
		}
		int move = 0;
		System.out.println("Setting up board");
		this.set();
		System.out.println("looking good :)");
		while(true){
			this.display();
			if (this.isWon()||this.isDone()){
				break;
			}
			this.isTurn();
			if(this.whatTurn()){
				System.out.println("Alrght, please input your next move");
				move = in.nextInt();
				if(this.isValid(move)){
					this.place(move);
					this.turnSwitch();
				}else{
					System.out.println("Sorry that turn is invalid");
				}
			}else{
				if(this.isPvp()){
					System.out.println("Alrght, please input your next move");
					move = in.nextInt();
					if(this.isValid(move)){
						this.place(move);
						this.turnSwitch();
					}else{
						System.out.println("Sorry that turn is invalid");
					}

				}else{
					System.out.println("a l r i g h t, i m m a  g o  h e r e");
					this.cpuPlace();
					this.turnSwitch();
				}

			}
		}
		if(this.isWon()) {
			if(!this.whatTurn()){
				System.out.println("Player 1 won");
			}else{
				if(this.isPvp()){
					System.out.println("Player 2 won");
				}else{
					System.out.println("bot won, humans S U C K");
				}
			}
		}else {
			System.out.println("no one won");
		}


	}
	public boolean isPvp(){
		return pvp;
	}
	public boolean isXO(){
		return xo;
	}
	public void cpuPlace(){
		int z = -4;
		int p = 1;
		if(xo) {
			p = -1;
		}
		if(!this.cpuWhere(-2*p)) {
			// this part checks for winning moves 
			if(!this.cpuWhere(2*p)) {
				if(!this.cpuWhere(-1*p)) {
					if(this.isValid(5)) {
						this.place(5);
					}else if(this.isValid(1)){
						this.place(1);
						} else if(this.isValid(3)) {
							this.place(3);
						} else if (this.isValid(7)) {
							this.place(7);
						}else if(this.isValid(9)) {
							this.place(9);
						}else {
					while(!this.isValid(z)) {
						z =  (int) Math.round((Math.random()*(9-1)+1));
					}
					this.place(z);
					}
				}
			}
		}		//this part checks where there are empty rows with one existing mark for the cpu to place in
	}
	public boolean cpuWhere(int z)//this method simplifies some steps from above
	{
		for(int y = 0; y<3; y++) {//check rows
			if((tic[0][y]+tic[1][y]+tic[2][y])==z) {
				int p;
				for(int i = 0; i<3; i++){
					p = i+1+(y*3);
					if(this.isValid(p)){
						this.place(p);
					return true;	
					}
				}
			}
		}
		for(int x = 0; x<3; x++) {//check columns
			if((tic[x][0]+tic[x][1]+tic[x][2])==z){
				int p;
				for(int i = 0; i<3; i++){
					p = x+1+(i*3);
					if(this.isValid(p)){
						this.place(p);
						return true;
					}
				}
			}
		}
		if((tic[0][0]+tic[1][1]+tic[2][2])==z) {
			int p;
			for(int i = 0; i<3; i++){
				p = i+1+(i*3);
				if(this.isValid(p)){
					this.place(p);
				return true;	
				}else{
					//System.err.println(p + " didnt work");
				}
			}
		}
		if((tic[0][2]+tic[1][1]+tic[2][0])==z){

			int p;
			for(int i = 0; i<3; i++){
				p = i+1+((2-i)*3);
				if(this.isValid(p)){
					this.place(p);
					return true;
				}else{
					//System.err.println(p + " didnt work");
				}
			}

		}
		return false;
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

	public boolean isDone(){
		for(int x = 0; x<3; x++) {
			for(int y = 0; y<3; y++ ) {
				if(tic[x][y] == 0){
					return false;
				}
			}
		}
		return true;
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

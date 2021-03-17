package labs.lab5;

public class TicTacToeGame implements Game{
	private char[][] board;
	private char mark ;
	private static char player1;
	private char winner;
	public TicTacToeGame(){
		board = new char[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j] = ' ';
			}
		}
		mark = ' ';
		winner = ' ';
	}
	
	public char getWinner() {
		return winner;
	}
	public char getPlayer() {
		return player1;
	}
	
	public boolean isValidMove(String move) {
		// check for the input 
		if(move.length()!=3) return false;
		if(move.charAt(0)<'0' || move.charAt(0)>'2') return false;
		if(move.charAt(1)<'0' || move.charAt(1)>'2') return false;
		if(move.charAt(2)!='x' && move.charAt(2)!='o') return false;
		if(mark == ' ') {
			mark = move.charAt(2);
			player1 = mark;
		}
		if(mark != move.charAt(2)) return false;
		
		if(board[move.charAt(0)-'0'][move.charAt(1)-'0'] != ' ') return false;
		
		return true;
	}

	public void executeMove(String move) {
		if(isValidMove(move)) {
			mark = move.charAt(2);
			
			board[move.charAt(0)-'0'][move.charAt(1)-'0'] = mark;
			
			if(mark == 'x') {
				mark = 'o';
			}else {
				mark = 'x';
			}
		}

	}

	public boolean gameOver() {
		// this is horizontally
		for(int i=0; i<3; i++) {
			if(board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][0]==board[i][2]) {
				return true;
			}
		}

//		}
		// vertically
		for(int i=0; i<3; i++) {
			if(board[0][i] != ' ' && board[0][i]==board[1][i] && board[0][i]==board[2][i]) {
				return true;
			}
		}

//		}
		// diagonally
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			return true;
		}
		if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
			return true;
		}
		
		//for loop check if there are no more moves
		int count = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
					if(board[i][j] == ' ') {
						count ++;
					}
			}
		}
		if(count == 0) return true;
		if(count == 9) return false;
		
		return false;
	}

	public String displayBoard() {
		String str = "";
		str += " " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + ' ' + '\n';
		str += "-----------\n";
		str += " " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + ' ' + '\n';
		str += "-----------\n";
		str += " " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " " + '\n' ;
		return str;
	}

	public int determineWinner() {
		
		for(int i=0; i<3; i++) {
			if(board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][0]==board[i][2]) {
				winner = board[i][0];
			}
		}
		for(int i=0; i<3; i++) {
			if(board[0][i] != ' ' && board[0][i]==board[1][i] && board[0][i]==board[2][i]) {
				winner = board[0][i];
			}
		}
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			winner = board[0][0];
		}
		if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
			winner = board[0][2];
		}
		if(winner == ' ') {
			return 0;
		}else if(player1 == winner){
			return 1;
		}else {
			return 2;
		}
	}
}
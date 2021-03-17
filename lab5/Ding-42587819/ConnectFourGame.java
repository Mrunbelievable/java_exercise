package labs.lab5;

public class ConnectFourGame implements Game{
	
	private char[][] board;
	private char mark ;
	private static char player1;
	private char winner;
	
	public ConnectFourGame(){
		board = new char[6][7];
		for(int i=0; i<6; i++) {
			for(int j=0; j<7; j++) {
				board[i][j] = ' ';
			}
		}
		mark = ' ';
		winner = ' ';
	}
	
	
	public boolean isValidMove(String move) {
		// check for input 
		if(move.length()!=2) return false;
		if(move.charAt(0)<'0' || move.charAt(0)>'6') return false;
		if(move.charAt(1)!='r' && move.charAt(1)!='y') return false;
		// set first player 
		if(mark == ' ') {
			mark = move.charAt(1);
			player1 = mark;
		}
		// check if next player is right or wrong 
		if(mark != move.charAt(1)) return false;
		// check if column is full 
		if(board[0][move.charAt(0)-'0'] != ' ') return false;
		
		return true;
	}

    public void executeMove(String move) {
    	
    	if(isValidMove(move)) {
    		mark = move.charAt(1);
        	
        	for(int i=5; i>=0; i--) {
        		if(board[i][move.charAt(0)-'0'] == ' '){
        			board[i][move.charAt(0)-'0'] = mark;
        			break;
        		}
        	}
        	if(mark == 'r') {
        		mark = 'y';
        	}else {
        		mark = 'r';
        	}
    	}
    	
    }

	public boolean gameOver() {
		//check the horizontal 
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				if(board[i][j] != ' ' && board[i][j]==board[i][j+1] && board[i][j] == board[i][j+2]
						&& board[i][j] == board[i][j+3]) {
					winner = board[i][j];
					return true;
				}
			}
		}
		// check the vertical
		for(int i=0; i<3; i++) {
			for(int j=0; j<7; j++) {
				if(board[i][j] != ' ' && board[i][j]==board[i+1][j] && board[i][j] == board[i+2][j]
						&& board[i][j] == board[i+3][j]) {
					winner = board[i][j];
					return true;
				}
			}
		}
		// check the positive diagonally 
		for(int i=3; i<6; i++) {
			for(int j=0; j<4; j++) {
				if(board[i][j] != ' ' && board[i][j]==board[i-1][j+1] && board[i][j] == board[i-2][j+2]
						&& board[i][j] == board[i-3][j+3]) {
					winner = board[i][j];
					return true;
				}
			}
		}
		// check the negative diagonally 
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				if(board[i][j] != ' ' && board[i][j]==board[i+1][j+1] && board[i][j] == board[i+2][j+2]
						&& board[i][j] == board[i+3][j+3]) {
					winner = board[i][j];
					return true;
				}
			}
		}
		//for loop check if there are no more moves
		int count = 0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<7; j++) {
					if(board[i][j] == ' ') {
						count ++;
					}
			}
		}
		// if no moves
		if(count == 0) return true;
		// if moves no full 
		if(count == 54) return false;
		
		return false;
	}

	public String displayBoard() {
		String str = "";
		str += " " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " +
				board[0][3] + " | " +  board[0][4] + " | " + board[0][5] + " | " + board[0][6] + ' ' +'\n';
		str += "---------------------------\n";
		str += " " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " +
				board[1][3] + " | " +  board[1][4] + " | " + board[1][5] + " | " + board[1][6] + ' ' +'\n';
		str += "---------------------------\n";
		str += " " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " +
				board[2][3] + " | " +  board[2][4] + " | " + board[2][5] + " | " + board[2][6] + ' ' +'\n';
		str += "---------------------------\n";
		str += " " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " +
				board[3][3] + " | " +  board[3][4] + " | " + board[3][5] + " | " + board[3][6] + ' ' +'\n';
		str += "---------------------------\n";
		str += " " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " +
				board[4][3] + " | " +  board[4][4] + " | " + board[4][5] + " | " + board[4][6] + ' ' +'\n';
		str += "---------------------------\n";
		str += " " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " +
				board[5][3] + " | " +  board[5][4] + " | " + board[5][5] + " | " + board[5][6] + ' ' +'\n';
		return str;
	}

	public int determineWinner() {
		//check the horizontal 
				for(int i=0; i<6; i++) {
					for(int j=0; j<4; j++) {
						if(board[i][j] != ' ' && board[i][j]==board[i][j+1] && board[i][j] == board[i][j+2]
								&& board[i][j] == board[i][j+3]) {
							winner = board[i][j];
						}
					}
				}
				// check the vertical
				for(int i=0; i<3; i++) {
					for(int j=0; j<7; j++) {
						if(board[i][j] != ' ' && board[i][j]==board[i+1][j] && board[i][j] == board[i+2][j]
								&& board[i][j] == board[i+3][j]) {
							winner = board[i][j];
						}
					}
				}
				// check the positive diagonally 
				for(int i=3; i<6; i++) {
					for(int j=0; j<4; j++) {
						if(board[i][j] != ' ' && board[i][j]==board[i-1][j+1] && board[i][j] == board[i-2][j+2]
								&& board[i][j] == board[i-3][j+3]) {
							winner = board[i][j];
						}
					}
				}
				// check the negative diagonally 
				for(int i=0; i<3; i++) {
					for(int j=0; j<4; j++) {
						if(board[i][j] != ' ' && board[i][j]==board[i+1][j+1] && board[i][j] == board[i+2][j+2]
								&& board[i][j] == board[i+3][j+3]) {
							winner = board[i][j];
						}
					}
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
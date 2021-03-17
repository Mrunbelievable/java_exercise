package labs.lab3;

class SeatingChart{
	int[][] seat_chart;
	public SeatingChart() {
		seat_chart = new int[][] {{40,50,50,50,40}, 
							{30,40,40,40,30},
							{20,30,30,30,20},
							{10,20,20,20,10},
							{10,10,10,10,10}};
	}
	public String getSeatingChart() {
		String str = "";
		for(int i=0; i<seat_chart.length; i++) {
			for(int j=0; j<seat_chart[0].length; j++) {
				if(j<seat_chart[0].length-1) {
					str +=  String.format("%2d", seat_chart[i][j]);
					str += ' ';
				}
				else {
					str +=  String.format("%2d", seat_chart[i][j]);
				}
			}
			str += '\n';
		}
		return str;
	}
	
	public void sellSeatByPrice(int price) {
		for(int i=0; i<seat_chart.length; i++) {
			for(int j=0; j<seat_chart[0].length; j++) {
				if(seat_chart[i][j]==price) {
					seat_chart[i][j] = 0;
					return;
				}
			}
		}
	}
	
	public void sellSeatByNumber(char row, int seat) {
		int real_row = row - 'A';
		int real_col = seat - 1;
		
		if(real_row<0 || real_row>4 || seat<1 || seat>5) {
			return;
		}
		
		if(seat_chart[real_row][real_col] != 0) {
			seat_chart[real_row][real_col] = 0;
		}
	}
	
}
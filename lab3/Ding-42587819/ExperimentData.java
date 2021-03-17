package labs.lab3;

class ExperimentData{
	
	private double [] data;
	
	public ExperimentData(double[] value){
		data = value;
	}
	
	public double[] getValues() {
		return data;
	}
	
	public void smooth() {
		double temp = 0;
		double temp2 = 0;
		
		if(data.length == 2) {
			data[0] = (data[0] + data[1])/2;
			data[1] = data[0];
			return;
		}
		
		for(int i=0; i<data.length; i++) {
			if(i==0) {
				temp = data[i];
				data[i] = (temp + data[i+1])/2;
			}
			if(i==1) {
				temp2 = data[i];
				data[i] = (data[i-1]*2 + data[i+1])/3;
			}
			if(i>1 && i<data.length-1) {
				double temp3 = data[i];
				data[i] = (data[i-1]*3 - temp + data[i+1])/3;
				temp = temp2;
				temp2 = temp3;
			}
			if(i==data.length-1) {
				data[i] = (data[i-1]*3 - temp)/2;
			}
		}
	}
	
}
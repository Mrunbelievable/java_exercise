package labs.lab3;

class PrimeGenerator{
	private int value;
	public PrimeGenerator() {
		value = 2;
	}
	
	public int nextPrime() {
		int max = Integer.MAX_VALUE;
		while( value < max) {
			if(is_prime(value)) {
				int target = value;
				value++;
				return target;
			}
			value++;
		}
		return -1;
	}
	public boolean is_prime(int num) {
		if(num==1){
			return false;
		}
		if(num==2){
			return true;
		}
		if(num%2==0) return false;
		
		for(int i=3;i<=Math.sqrt(num);i+=2){
			if(num%i==0){
				return false;
			}	
		}
		return true;
	}
}
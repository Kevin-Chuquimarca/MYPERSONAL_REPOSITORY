public class HelloWorld {
	public static void main(String[] args) {
		int number1;
		int addition;
		//code to read from keyboard
		number1 = 1;
		addition = addTwoNUmbers(number1);
		System.out.printf("Taller 3 de: Kevin Chuquimarca ");
	}
	static int addTwoNUmbers(int addend1){
		System.out.printf("The serie is: \n");
		for(int j=1; j<=10; j++){
			addend1 = j * 2;
			System.out.println(addend1);
		}
		return 0;
	}	
}	
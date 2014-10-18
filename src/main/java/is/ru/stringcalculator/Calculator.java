package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;  //If the string is empty then return 0
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);  //change the string into integer
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\\n");  //take the string and split it into string array
	}
      
        private static int sum(String[] numbers){
 	int total = 0;
        for(String number : numbers){
		total += toInt(number);
	}
	return total;
    	}



}

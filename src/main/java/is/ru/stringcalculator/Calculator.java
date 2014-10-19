package is.ru.stringcalculator;

public class Calculator {
	
	public static boolean testing(){
		return false;
	}

	public static String min(String text){
                String str = "Negatives not allowed: ";
                boolean first = true;
                for(int i = 0; i < text.length(); i++){
                       	if(text.charAt(i) == '-'){
                               	int j = i;
                               	if(first){
                                       	first = false;
                               	}
                               	else{
                                       	str += ", ";
                               	}
                       	    	while(text.charAt(j) != ',' || text.charAt(j) != '\n'){
                                       	str += text.charAt(j);
                                       	j++;
                               	}
                       	}
                }
                str += "\n";
                return str;
        }


	public static int add(String text){
		if(testing())System.out.println("\n\nStart Unchanged: " + text + " ---------------\n");
		if(text.equals("")){
			if(testing())System.out.println("The empty String: \"" + text + "\"\n");
			return 0;  //If the string is empty then return 0
		}
		else if(text.contains("-")){
//			throw new ErrorException(min(text));
			//minus.MinusExeption(text);
			System.out.println(min(text));
			return -1337;
		}
		else{
			return check(text);
		}
	}

	public static int check(String text){
		if(testing())print_test(text);
		if(text.contains("/" + "/")){
			if(testing())System.out.println("\nDelimiter removal: " + text + "\n");
			return selectDelimiter(text);
		}
		else if(text.contains("\n")){
			if(testing())System.out.println("Newline changing: " + text + "\n");
                        return removeNewline(text);
                }
		else if(text.contains(",")){
                        if(testing())System.out.println("Done splitting: " + text + "\n");
                        return sum(splitNumbers(text));
                }
		else{
			if(testing())System.out.println("no split: " + text + "\n");
			return 1;
		}
        }

	public static void print_test(String text){
                System.out.println("\nText going through check: " + text + "\n");
	}

	public static int removeNewline(String text){
		String rem = "\n";
		if(testing()) System.out.println("removing newline char from: " + text + "\n");
		if(text.charAt(0) == '\n'){
			text = text.replace(rem, "");
		}
		else{
			text = text.replace(rem, ",");
		}
		if(testing())System.out.println("After removing newline char from: " + text + "\n");
		return check(text);
        }

	private static int selectDelimiter(String number){
		String delim = "" + number.charAt(2); //exepted delimiters
		String delnum = "" + number.charAt(0) + number.charAt(1) + number.charAt(2); //what I want to remove
		String onlynum = (number.replace(delnum, ""));  //the new string with removed user delimiter
		String num = onlynum.replace(delim, ",");  //exchange the text using the delimiters

		if(testing()){
			//this is for output testing
			System.out.println("\nThis is an outprint!\ndelim:");
			System.out.println(delim);
			System.out.println("\nnumber:");
			System.out.println(number);
			System.out.println("\nnumber after the removal of delim:");
	              	System.out.println(onlynum);
			System.out.println("\nOutprint complete!\n");
			//output testing done
		}

                return check(num);  //now check again. 
        }


	private static int toInt(String number){
		return Integer.parseInt(number);  //change the string into integer
	}

	private static String[] splitNumbers(String numbers){
	    	return numbers.split(",|\n");  //take the string and split it into string array
	}
      
        private static int sum(String[] numbers){
 		int total = 0;
        	for(String number : numbers){
			if(testing())System.out.println("Line splitting: " + number + "\n");
			total += toInt(number);
		}
		if(testing())System.out.println("this is the outcome: " + total + "\n");
		return total;
    	}



}

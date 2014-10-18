package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		System.out.println("\n\nStart Unchanged: " + text + " ---------------\n");
		if(text.equals("")){
//			System.out.println("The empty String: \"" + text + "\"\n");
			return 0;  //If the string is empty then return 0
		}
		else{
			return check(text);
		}
	}

	public static int check(String text){
//		print_test(text);
		if(text.contains("/" + "/")){
//			System.out.println("\nDelimiter removal: " + text + "\n");
			return selectDelimiter(text);
		}
		else if(text.contains("\n")){
//			System.out.println("Newline changing: " + text + "\n");
                        return removeNewline(text);
                }
		else if(text.contains(",")){
//                        System.out.println("Done splitting: " + text + "\n");
                        return sum(splitNumbers(text));
                }
		else{
//			System.out.println("no split: " + text + "\n");
			return 1;
		}
        }

	public static void print_test(String text){
                System.out.println("\nText going through check: " + text + "\n");
	}

	public static int removeNewline(String text){
			String rem = "\n";
			System.out.println("removing newline char from: " + text + "\n");
			if(text.charAt(0) == '\n'){
				text = text.replace(rem, "");
			}
			else{
				text = text.replace(rem, ",");
			}
			System.out.println("After removing newline char from: " + text + "\n");
			return check(text);
                }

	private static int selectDelimiter(String number){
		String delim = "" + number.charAt(2); //exepted delimiters
		String delnum = "" + number.charAt(0) + number.charAt(1) + number.charAt(2); //what I want to remove
		String onlynum = (number.replace(delnum, ""));  //the new string with removed user delimiter
		String num = onlynum.replace(delim, ",");  //exchange the text using the delimiters

		//this is for output testing
//		System.out.println("\nThis is an outprint!\ndelim:");
//		System.out.println(delim);
//		System.out.println("\nnumber:");
//		System.out.println(number);
//		System.out.println("\nnumber after the removal of delim:");
//              System.out.println(onlynum);
//		System.out.println("\nOutprint complete!\n");
		//output testing done

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
//			System.out.println("Line splitting: " + number + "\n");
			total += toInt(number);
		}
//		System.out.println("this is the outcome: " + total + "\n");
		return total;
    	}



}

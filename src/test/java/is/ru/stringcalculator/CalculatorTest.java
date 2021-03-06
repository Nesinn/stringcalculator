package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]){
        org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    	}

	@Test
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
        public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
        }

	@Test
    	public void testHandlingOfNewline(){
        assertEquals(13, Calculator.add("7,3\n3"));
	}

	@Test
        public void testSelectDelimiter(){
        assertEquals(6, Calculator.add("/" + "/;\n4;2"));
        }

	@Test(expected=IllegalArgumentException.class)
        public void testIllegalArgumentException(){
	Calculator.add("2,-4,3,-5");
        //assertEquals("Negatives not allowed: -4, -5", Calculator.add(Calculator.add("2,-4,3,-5")));
        }

	@Test
        public void testTooHighNumbers(){
        assertEquals(2, Calculator.add("1001,2"));
        }

	@Test
        public void testMultibleDelimiter(){
        assertEquals(6, Calculator.add("[***]\n1***2***3"));
        }

	@Test
        public void testMoreThenOneDelimiter(){
        assertEquals(6, Calculator.add("/" + "/[*][%]\n1*2%3"));
        }

	@Test
        public void testDelimiterOfAnyLength(){
        assertEquals(20, Calculator.add("/" + "/[***][%][*]\n1***2%3*4,8\n2"));
        }
}

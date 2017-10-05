import static org.junit.Assert.*;

import org.junit.Test;


public class Tests {

//CSVFileReader data = new CSVFileReader();
	
	@Test
	public void testcsvstring() {
		/*
		 *Random spreadsheet names were picked. The string 'test#' was found to the corresponding string in the spreadsheet.
		 */
		Main.readcsv();
		
		String test = "Bouillon"; 
		assertTrue("compareTo not 0, expected string - Bouillon", Main.getArray(20, 0).trim().compareTo(test.trim()) == 0);
		
		String test2 = "Apple juice"; 
		assertTrue("compareTo not 0, expected string - Apple juice", Main.getArray(1, 0).trim().compareTo(test2.trim()) == 0);
		
		String test3 = "Honeydew"; 
		assertTrue("compareTo not 0, expected string - Honeydew", Main.getArray(83, 0).trim().compareTo(test3.trim()) == 0);
		
		String test4 = "Marshmallows"; 
		assertTrue("compareTo not 0, expected string - Marshmallows", Main.getArray(98, 0).trim().compareTo(test4.trim()) == 0);
		
		String test5 = "Dates whole without pits"; 
		assertTrue("compareTo not 0, expected string - Dates whole without pits", Main.getArray(62, 0).trim().compareTo(test5.trim()) == 0);
		
		String test6 = "Potato chips"; 
		assertTrue("compareTo not 0, expected string - Potato chips", Main.getArray(132, 0).trim().compareTo(test6.trim()) == 0);
		
		String test7 = "White rice raw dry"; 
		assertTrue("compareTo not 0, expected string - White rice raw dry", Main.getArray(177, 0).trim().compareTo(test7.trim()) == 0);
		
		String test8 = "FRUITS"; //These three foods have the food type "FRUITS" 
		assertTrue("compareTo not 0, expected string - FRUITS", Main.getArray(1, 16).trim().compareTo(test8.trim()) == 0);
		assertTrue("compareTo not 0, expected string - FRUITS", Main.getArray(3, 16).trim().compareTo(test8.trim()) == 0);
		assertTrue("compareTo not 0, expected string - FRUITS", Main.getArray(4, 16).trim().compareTo(test8.trim()) == 0);
	
		String test9 = "DAIRY"; //These three foods have the food type "DAIRY"
		assertTrue("compareTo not 0, expected string - DAIRY", Main.getArray(84, 16).trim().compareTo(test9.trim()) == 0);
		assertTrue("compareTo not 0, expected string - DAIRY", Main.getArray(85, 16).trim().compareTo(test9.trim()) == 0);
		assertTrue("compareTo not 0, expected string - DAIRY", Main.getArray(86, 16).trim().compareTo(test9.trim()) == 0);
	}
	
	@Test
	public void testfoodint()
	{	
		/*
		 *Random spreadsheet values were picked. The int 'test#' was found to the corresponding number in the spreadsheet.
		 *
		 *These tests also test the method 'parseDouble' to an exact amount, indicated by the third parameter in assertEquals.
		 */
		double test = 60;
		double tested = Main.parseDouble(Main.getArray(77, 2).trim());
		assertEquals(tested, test, 0);
		
		double test2 = 22.3;
		double tested2 = Main.parseDouble(Main.getArray(28, 4).trim());
		assertEquals(tested2, test2, 0);
		
		double test3 = 0.69;
		double tested3 = Main.parseDouble(Main.getArray(51, 11).trim());
		assertEquals(tested3, test3, 0);
		
		double test4 = 3167;
		double tested4 = Main.parseDouble(Main.getArray(32, 13).trim());
		assertEquals(tested4, test4, 0);
		
		double test5 = 17;
		double tested5 = Main.parseDouble(Main.getArray(119, 1).trim());
		assertEquals(tested5, test5, 0);
		
		double test6 = 2.4;
		double tested6 = Main.parseDouble(Main.getArray(177, 10).trim());
		assertEquals(tested6, test6, 0);
	}
	
	@Test
	public void foodtest()
	{
		
		/*
		 *Random spreadsheet values were picked. 
		 *
		 * This test confirms that the food object created has the correct values and are accessed correctly.
		 * These values are still strings, but will be converted to doubles for calculations.
		 */
		
		Food.inputfood("Trix Cereal");
		Food.inputfood("Mushrooms raw sliced");
		
		//Trix Cereal
		assertEquals(Food.foodlist.get(0).name, Main.getArray(167, 0).trim());
		assertEquals(Food.foodlist.get(0).calcium, Main.getArray(167, 1).trim());
		assertEquals(Food.foodlist.get(0).energy, Main.getArray(167, 2).trim());
		assertEquals(Food.foodlist.get(0).protein, Main.getArray(167, 3).trim());
		
		//Mushrooms
		assertEquals(Food.foodlist.get(1).name, Main.getArray(104,0).trim());
		assertEquals(Food.foodlist.get(1).calcium, Main.getArray(104,1).trim());
		assertEquals(Food.foodlist.get(1).energy, Main.getArray(104,2).trim());
		assertEquals(Food.foodlist.get(1).protein, Main.getArray(104,3).trim());
	}
	
	@Test
	public void difference()
	{
		/*
		 * Tests to see if the differences are calculated correctly
		 */
		
		//These values match the daily, and should return 0
		double calciumdif = 1100 - Main.parseDouble(DailyValues.calcium);
		double energydif = 2076 - Main.parseDouble(DailyValues.energy);
		double 	proteindif = 50 - Main.parseDouble(DailyValues.protein);
		double 	carbohydratedif = 300 - Main.parseDouble(DailyValues.carbohydrate);
		double 	fiberdif = 25 - Main.parseDouble(DailyValues.fiber);
		
		assertEquals(calciumdif, 0, 0);
		assertEquals(energydif, 0, 0);
		assertEquals(proteindif, 0, 0);
		assertEquals(carbohydratedif, 0, 0);
		assertEquals(fiberdif, 0, 0);
		
		//These values are double the daily, and should return the daily value
		double 	fatdif = 130 - Main.parseDouble(DailyValues.fat);
		double 	irondif = 28 - Main.parseDouble(DailyValues.iron);
		double 	sodiumdif = 4800 - Main.parseDouble(DailyValues.sodium);
		double 	phosphorousdif = 1400 - Main.parseDouble(DailyValues.phosphorous);
		double 	zincdif = 20 - Main.parseDouble(DailyValues.zinc);
		
		assertEquals(fatdif, 65, 0);
		assertEquals(irondif, 14, 0);
		assertEquals(sodiumdif, 2400, 0);
		assertEquals(phosphorousdif, 700, 0);
		assertEquals(zincdif, 10, 0);
		
		//These values are half the daily, and should return the negative 
		double 	niacindif = 7.5 - Main.parseDouble(DailyValues.niacin);
		double 	thiamindif = 0.6 - Main.parseDouble(DailyValues.thiamin);
		double 	vitaminAdif = 500 - Main.parseDouble(DailyValues.vitaminA);
		double 	vitaminB6dif = 0.75 - Main.parseDouble(DailyValues.vitaminB6);
		double 	vitaminCdif = 30 - Main.parseDouble(DailyValues.vitaminC);
		
		assertEquals(niacindif, -7.5, 0);
		assertEquals(thiamindif, -0.6, 0);
		assertEquals(vitaminAdif, -500, 0);
		assertEquals(vitaminB6dif, -0.75, 0);
		assertEquals(vitaminCdif, -30, 0);
	}
	
	
	
	

}

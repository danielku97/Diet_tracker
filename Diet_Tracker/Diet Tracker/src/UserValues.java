import java.text.DecimalFormat;


public class UserValues
{
	static double calcium;
	static double energy;
	static double protein;
	static double carbohydrate;
	static double fiber;
	static double fat;
	static double iron;
	static double sodium;
	static double phosphorous; 
	static double zinc;
	static double niacin;
	static double thiamin;
	static double vitaminA;
	static double vitaminB6;
	static double vitaminC;
	
	static double calciumdif;
	static double energydif; 
	static double proteindif;
	static double carbohydratedif;
	static double fiberdif; 
	static double fatdif; 
	static double irondif;
	static double sodiumdif;
	static double phosphorousdif;
	static double zincdif;
	static double niacindif; 
	static double thiamindif;
	static double vitaminAdif; 
	static double vitaminB6dif;
	static double vitaminCdif;

	static String difference;
	static String userValues = "";
	static String warning;
	
	static DecimalFormat df = new DecimalFormat("#.##");


	public void update(Food fooditem) //Adds the most recent food values to the total
	{
		calcium += Main.parseDouble(fooditem.calcium);
		energy += Main.parseDouble(fooditem.energy);
		protein += Main.parseDouble(fooditem.protein);
		carbohydrate += Main.parseDouble(fooditem.carbohydrate);
		fiber +=Main.parseDouble( fooditem.fiber);
		fat += Main.parseDouble(fooditem.fat);
		iron += Main.parseDouble(fooditem.iron);
		sodium += Main.parseDouble(fooditem.sodium);
	    phosphorous += Main.parseDouble(fooditem.phosphorous);
		zinc += Main.parseDouble(fooditem.zinc);
		niacin += Main.parseDouble( fooditem.niacin);
		thiamin += Main.parseDouble(fooditem.thiamin);
		vitaminA += Main.parseDouble(fooditem.vitaminA);
		vitaminB6 += Main.parseDouble(fooditem.vitaminB6);
		vitaminC += Main.parseDouble( fooditem.vitaminC);
	}
	

	
	public static String compareToDaily() //Calculate the difference between user values and daily values
	{
		difference = "";
		
		calciumdif = calcium - Main.parseDouble(DailyValues.calcium);
		energydif = energy - Main.parseDouble(DailyValues.energy);
		proteindif = protein - Main.parseDouble(DailyValues.protein);
		carbohydratedif = carbohydrate - Main.parseDouble(DailyValues.carbohydrate);
		fiberdif = fiber - Main.parseDouble(DailyValues.fiber);
		fatdif = fat - Main.parseDouble(DailyValues.fat);
		irondif = iron - Main.parseDouble(DailyValues.iron);
		sodiumdif = sodium - Main.parseDouble(DailyValues.sodium);
		phosphorousdif = phosphorous - Main.parseDouble(DailyValues.phosphorous);
		zincdif = zinc - Main.parseDouble(DailyValues.zinc);
		niacindif = niacin - Main.parseDouble(DailyValues.niacin);
		thiamindif = thiamin - Main.parseDouble(DailyValues.thiamin);
		vitaminAdif = vitaminA - Main.parseDouble(DailyValues.vitaminA);
		vitaminB6dif = vitaminB6 - Main.parseDouble(DailyValues.vitaminB6);
		vitaminCdif =vitaminC - Main.parseDouble(DailyValues.vitaminC);

		difference += ("Difference Between User and Recommended" + "\n");
		difference += ("Calcium Difference: " + df.format(calciumdif) + "\n");
		difference += ("Energy Difference: " + df.format(energydif) + "\n");
		difference += ("Protein Difference: " + df.format(proteindif) + "\n");
		difference += ("Carbohydrate Difference: " + df.format(carbohydratedif) + "\n");
		difference += ("Fiber Difference: " + df.format(fiberdif) + "\n");
		difference += ("Fat Difference: " + df.format(fatdif) + "\n");
		difference += ("Iron Difference: " + df.format(irondif) + "\n");
		difference += ("Sodium Difference: " + df.format(sodiumdif) + "\n");
		difference += ("Phosphorous Difference: " + df.format(phosphorousdif) + "\n");
		difference += ("Zinc Difference: " + df.format(zincdif) + "\n");
		difference += ("Niacin Difference: " + df.format(niacindif) + "\n");
		difference += ("Thiamin Difference: " + df.format(thiamindif) + "\n");
		difference += ("VitaminA Difference: " + df.format(vitaminAdif) + "\n");
		difference += ("VitaminB6 Difference: " + df.format(vitaminB6dif) + "\n");
		difference += ("VitaminC Difference: " + df.format(vitaminCdif));
		return difference;
	}
	
	public static String dietWarnings() //Checks if values are too high or too low. Values exceeding 1.5x or 0.5x daily values are considered an issue
{
	warning = "Attention! These values are outstanding and should be considered! \n";
	
	if (calciumdif > 550)
	{
		warning += "Calcium is too high" + "\n";
	}
	
	if (calciumdif < -550)
	{
		warning += "Calcium is too low" + "\n";
	}
	
	if (energydif > 1000)
	{
		warning += "Energy is too high" + "\n";
	}
	
	if (energydif < -1000)
	{
		warning += "Energy is too low" + "\n";
	}
	
	if (proteindif > 25)
	{
		warning += "Protein is too high" + "\n";
	}
	
	if (proteindif < -25)
	{
		warning += "Protein is too low" + "\n";
	}
	
	if (carbohydratedif > 150)
	{
		warning += "Carbohydrate is too high" + "\n";
	}
	
	if (carbohydratedif < -150)
	{
		warning += "Carbohydrate is too low" + "\n";
	}
	
	if (fiberdif > 12)
	{
		warning += "Fiber is too high" + "\n";
	}
	
	if (fiberdif < -12)
	{
		warning += "Fiber is too low" + "\n";
	}
	
	if (irondif > 7)
	{
		warning += "Iron is too high" + "\n";
	}
	
	if (irondif < -7)
	{
		warning += "Iron is too low" + "\n";
	}
	
	if (sodiumdif > 1200)
	{
		warning += "Sodium is too high" + "\n";
	}
	
	if (sodiumdif < -1200)
	{
		warning += "Sodium is too low" + "\n";
	}
	
	if (phosphorousdif > 350)
	{
		warning += "Phosphorus is too high" + "\n";
	}
	
	if (phosphorousdif < -350)
	{
		warning += "Phosphorus is too low" + "\n";
	}
	
	if (zincdif > 5)
	{
		warning += "Zinc is too high" + "\n";
	}
	
	if (zincdif < -5)
	{
		warning += "Zinc is too low" + "\n";
	}
	
	if (niacindif > 10)
	{
		warning += "Niacin is too high" + "\n";
	}
	
	if (niacindif < -10)
	{
		warning += "Niacin is too low" + "\n";
	}
	
	if (thiamindif > 0.6)
	{
		warning += "Thiamin is too high" + "\n";
	}
	
	if (thiamindif < -0.6)
	{
		warning += "Thiamin is too low" + "\n";
	}
	
	if (vitaminAdif > 500)
	{
		warning += "Vitamin A is too high" + "\n";
	}
	
	if (vitaminAdif < -500)
	{
		warning += "Vitamin A is too low" + "\n";
	}
	
	if (vitaminB6dif > 0.7)
	{
		warning += "Vitamin B6 is too high" + "\n";
	}
	
	if (vitaminB6dif < -0.7)
	{
		warning += "Vitamin B6 is too low" + "\n";
	}
	
	if (vitaminCdif > 30)
	{
		warning += "Vitamin C is too high" + "\n";
	}
	
	if (vitaminCdif < -30)
	{
		warning += "Vitamin C is too low" + "\n";
	}
	return warning;
		
	}


	public static String getUserValues() //Returns user values
	{
		userValues = "";
		userValues += "My Nutrition Values" + "\n";
		userValues += ("Calcium[mg]: " + df.format(calcium) + "\n");
		userValues += ("Energy[kcal]: " + df.format(energy) + "\n");
		userValues += ("Protein[g]: " + df.format(protein) + "\n");
		userValues += ("Carbohydrate[g]: " + df.format(carbohydrate) + "\n");
		userValues += ("Fiber[g]: " + df.format(fiber) + "\n");
		userValues += ("Fat[g]: " + df.format(fat) + "\n");
		userValues += ("Iron[mg]: " + df.format(iron) + "\n");
		userValues += ("Sodium[mg]: " + df.format(sodium) + "\n");
		userValues += ("Phosphorous[mg]: " + df.format(phosphorous) + "\n");
		userValues += ("Zinc[mg]: " + df.format(zinc) + "\n");
		userValues += ("Niacin[mg]: " + df.format(niacin) + "\n");
		userValues += ("Thiamin[mg]: " + df.format(thiamin) + "\n");
		userValues += ("VitaminA[RE]: " + df.format(vitaminA) + "\n");
		userValues += ("VitaminB6[RE: " + df.format(vitaminB6) + "\n");
		userValues += ("VitaminC[mg]: " + df.format(vitaminC));
		return userValues;
		
	}
}



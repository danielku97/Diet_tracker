
public class DailyValues extends Nutritiondata
{

	/*
	 * Daily values according to http://www.mydailyintake.net/nutrients/ and 
	 * the government of Canada website or other sources.
	 * 
	 * These values pertain to the average 25-30 year old male.
	 */
	static String calcium = "1100";
	static String energy = "2076";
	static String protein = "50";
	static String carbohydrate = "300";
	static String fiber = "25";
	static String fat = "65";
	static String iron = "14";
	static String sodium = "2400";
	static String phosphorous = "700"; 
	static String zinc = "10";
	static String niacin = "15";
	static String thiamin = "1.2";
	static String vitaminA = "1000";
	static String vitaminB6 ="1.5";
	static String vitaminC = "60";
	static String daily = "";


public static String getDaily() //Returns daily Values
{
	daily = ("Daily Recommended Values" + "\n");
	daily += (calcium + "\n");
	daily += (energy + "\n");
	daily += (protein + "\n");
	daily += (carbohydrate + "\n");
	daily += (fiber + "\n");
	daily += (fat + "\n");
	daily += (iron + "\n");
	daily += (sodium + "\n");
	daily += (phosphorous + "\n");
	daily += (zinc + "\n");
	daily += (niacin + "\n");
	daily += (thiamin + "\n");
	daily += (vitaminA + "\n");
	daily += (vitaminB6 + "\n");
	daily += (vitaminC);
	return daily;

}
}
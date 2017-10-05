import java.util.ArrayList;


public class Food extends Nutritiondata
{
String name;
int quantity;
static ArrayList<Food> foodlist = new ArrayList<Food>();
static UserValues user = new UserValues();
static String tempDisplay = "";
static boolean confirmation;

public Food(String name, String calcium, String energy, //Constructor for a food item
		String protein, String carbohydrate, String fiber,
		String fat, String iron, String sodium, String phosphorous,
		String zinc, String niacin, String thiamin, String vitamina, 
		String vitaminb6, String vitaminc, String foodType) 
{
	this.name = name;
	this.calcium = calcium;
	this.energy = energy;
	this.protein = protein;
	this.carbohydrate = carbohydrate;
	this.fiber = fiber;
	this.fat = fat;
	this.iron = iron;
	this.sodium = sodium;
	this.phosphorous = phosphorous;
	this.zinc = zinc;
	this.niacin = niacin;
	this.thiamin = thiamin;
	this.vitaminA = vitamina;
	this.vitaminB6 = vitaminb6;
	this.vitaminC = vitaminc;
	this.foodType = foodType;
}

public static void inputfood(String food) //Inputs food into the foodlist. Confirmation is a boolean which determines if the food exists or not.
{
	confirmation = true;
	for (int i = 0; i <181; i++) 
	{
			if (food.equalsIgnoreCase(Main.datatable[i][0].trim()))
			{
				Food tempFood = new Food(Main.datatable[i][0].trim(), Main.datatable[i][1].trim(), Main.datatable[i][2].trim(), Main.datatable[i][3].trim(), Main.datatable[i][4].trim(), Main.datatable[i][5].trim(), Main.datatable[i][6].trim(), Main.datatable[i][7].trim(), Main.datatable[i][8].trim(), Main.datatable[i][9].trim(), Main.datatable[i][10].trim(), Main.datatable[i][11].trim(), Main.datatable[i][12].trim(), Main.datatable[i][13].trim(), Main.datatable[i][14].trim(), Main.datatable[i][15].trim(), Main.datatable[i][16].trim());
				confirmation = false;
				foodlist.add(tempFood);
				user.update(tempFood);
				break;
			}
	}
}


public static void displayFood(String catagory) //Displays all the foods with the same food type
{
	tempDisplay = "";
	for (int i = 0; i <181; i++) 
	{
			if (catagory.equalsIgnoreCase(Main.datatable[i][16].trim()))
			{
				tempDisplay += Main.datatable[i][0].trim() + "\n";
			}
	}		
}
}

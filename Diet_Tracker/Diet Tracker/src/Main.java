
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 

public class Main extends Application{
 
	static int count = 0;
	static int count2 = 0;
	static String[][] datatable = new String[182][17]; //Array of foods
	static UserValues user = new UserValues(); //Nutrition info of the user
	
	
  public static void main(String[] args) {
	  String fileName = ("Foodchart.csv");
	  File file = new File(fileName);
	  System.out.println(file.exists());
	 
	  
	  try {
		Scanner sc = new Scanner(file);
		sc.useDelimiter(",");
		while (sc.hasNext())
		{
			datatable[count][count2] = sc.next();
			count2++;
			if (count2 == 17)
			{
				count++;
				count2 = 0;
			}
		}
		sc.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	  
		Application.launch(args);
		
}
	
	public static String getArray(int a, int b) //Get method
	{
		return datatable[a][b];
	}
	
	public static void readcsv() //Same code as the main, but in a method so it can run before testing

	{
		String fileName = ("Foodchart.csv");
		  File file = new File(fileName);
		  System.out.println(file.exists());
		 
		  
		  try {
			Scanner sc = new Scanner(file);
			sc.useDelimiter(",");
			while (sc.hasNext())
			{
				datatable[count][count2] = sc.next();
				count2++;
				if (count2 == 17)
				{
					count++;
					count2 = 0;
				}
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static double parseDouble(String input) //Reads a string and outputs a double
	{
		double number = Double.parseDouble(input);
		return number;
	}
	
	public static void instructions() //Opens up Instructions.txt
	{
		Runtime rt = Runtime.getRuntime();
		  String fileName2 = ("Instructions.txt");
		  File file2 = new File(fileName2);
		  try {
			Process p=rt.exec("notepad " + file2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void todo() //Opens up Instructions.txt
	{
		Runtime rt = Runtime.getRuntime();
		  String fileName3 = ("todo_list.txt");
		  File file3 = new File(fileName3);
		  try {
			Process p=rt.exec("notepad " + file3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Diet Tracker");
		
		final Group mainGroup = new Group(); 
		final Scene mainScene = new Scene(mainGroup, 450, 350);
		
		final Group foodGroup = new Group();
		final Scene foodScene = new Scene(foodGroup, 600, 450);
		
		final Group displayGroup = new Group();
		final Scene displayScene = new Scene(displayGroup, 600, 450);
		
		final Group resultsGroup = new Group();
		final Scene resultsScene = new Scene(resultsGroup, 1000, 650);
		
		final TextArea display = new TextArea(); //Displays categories of food
		display.setLayoutX(5);
		display.setLayoutY(5);
		display.setText(Food.tempDisplay);
		
		final TextArea warnings = new TextArea(); //Displays extremes in nutritional data
		warnings.setLayoutX(5);
		warnings.setLayoutY(450);
		warnings.setText("");
		
		Text foodinput = new Text(); // Text label
		foodinput.setFont(new Font(20));
		foodinput.setLayoutX(47);
		foodinput.setLayoutY(315);
		foodinput.setText("Input food eaten:");
		
		final Text error = new Text(); //Error label
		error.setFont(new Font(20));
		error.setLayoutX(47);
		error.setLayoutY(350);
		error.setText("");
		
		Text title = new Text(); //Title label
		title.setFont(new Font(20));
		title.setLayoutX(5);
		title.setLayoutY(30);
		title.setText("Diet Tracker Application\nBy Daniel Ku\nPrototype WIP");
		
		final Text userValues = new Text(); //Displays user values
		userValues.setFont(new Font(20));
		userValues.setLayoutX(5);
		userValues.setLayoutY(20);
		userValues.setText(UserValues.getUserValues());
		
		final Text dailyValues = new Text(); //Displays daily values
		dailyValues.setFont(new Font(20));
		dailyValues.setLayoutX(300);
		dailyValues.setLayoutY(20);
		dailyValues.setText(DailyValues.getDaily());
		
		final Text difference = new Text(); //Displays the difference
		difference.setFont(new Font(20));
		difference.setLayoutX(600);
		difference.setLayoutY(20);
		difference.setText(UserValues.compareToDaily());
		
		Button results = new Button(); //Recalculates values and moves scene to results
		results.setLayoutX(150);
		results.setLayoutY(150);
		results.setText("Compare Diet");
		results.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				userValues.setText(UserValues.getUserValues());
				dailyValues.setText(DailyValues.getDaily());
				difference.setText(UserValues.compareToDaily());
				warnings.setText(UserValues.dietWarnings());
				primaryStage.setScene(resultsScene);
			}			
		});
		
		final TextField input = new TextField(); //Input text field
		input.setLayoutX(200);
		input.setLayoutY(300);
		input.getText();
		
		Button submit = new Button(); //Submits the input text
		submit.setLayoutX(350);
		submit.setLayoutY(300);
		submit.setText("Submit");
		submit.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				error.setText("");
				Food.inputfood(input.getText());
				input.setText("");
				if (Food.confirmation)
				{
				error.setText("That food does not exist. Perhaps it was input wrong.");
				}
			}			
		});
		
		Button instructions = new Button(); //Opens Instructions.txt
		instructions.setLayoutX(350);
		instructions.setLayoutY(30);
		instructions.setText("Instructions");
		instructions.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				instructions();
			}			
		});
		
		Button todo = new Button(); //Opens Todo.txt
		todo.setLayoutX(350);
		todo.setLayoutY(60);
		todo.setText("To do list");
		todo.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				todo();
			}			
		});
		
		Button viewFood = new Button(); //Views the food menu
		viewFood.setLayoutX(250);
		viewFood.setLayoutY(150);
		viewFood.setText("View Food");
		viewFood.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				primaryStage.setScene(foodScene);
			}			
		});
		
		Button viewMeat = new Button(); //Views the meat section
		viewMeat.setLayoutX(10);
		viewMeat.setLayoutY(5);
		viewMeat.setText("View Meat");
		viewMeat.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Meat");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewSoups = new Button(); //Views the soup section
		viewSoups.setLayoutX(10);
		viewSoups.setLayoutY(50);
		viewSoups.setText("View Soups, sauces, gravies");
		viewSoups.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Soups Sauces and Gravies");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewFruits = new Button(); //Views the fruit section
		viewFruits.setLayoutX(10);
		viewFruits.setLayoutY(100);
		viewFruits.setText("View Fruits");
		viewFruits.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Fruits");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewBaked = new Button(); //Views the baked section
		viewBaked.setLayoutX(10);
		viewBaked.setLayoutY(150);
		viewBaked.setText("View Baked Goods");
		viewBaked.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Baked Goods");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewVegetables = new Button(); //Views the vegetable section
		viewVegetables.setLayoutX(10);
		viewVegetables.setLayoutY(200);
		viewVegetables.setText("View Vegetables and Legumes");
		viewVegetables.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Vegetables and Legumes");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewBeverages = new Button(); //View the beverage section
		viewBeverages.setLayoutX(10);
		viewBeverages.setLayoutY(250);
		viewBeverages.setText("View Beverages");
		viewBeverages.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Beverages");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewFats = new Button(); //View the fat section
		viewFats.setLayoutX(10);
		viewFats.setLayoutY(300);
		viewFats.setText("View Fats and Oils");
		viewFats.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Fats and oils");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewDairy = new Button(); //View the dairy section
		viewDairy.setLayoutX(10);
		viewDairy.setLayoutY(350);
		viewDairy.setText("View Dairy");
		viewDairy.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Dairy");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewSeafood = new Button(); //View the seafood section
		viewSeafood.setLayoutX(10);
		viewSeafood.setLayoutY(400);
		viewSeafood.setText("View Seafood");
		viewSeafood.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Fish and shellfish");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewPoultry = new Button(); //View the poultry
		viewPoultry.setLayoutX(300);
		viewPoultry.setLayoutY(5);
		viewPoultry.setText("View Poultry");
		viewPoultry.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Poultry");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewMixed = new Button(); //View the mixed dishes section
		viewMixed.setLayoutX(300);
		viewMixed.setLayoutY(50);
		viewMixed.setText("View Mixed Dishes and Fast Foods");
		viewMixed.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Mixed dishes and fast foods");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewGrains = new Button(); // View the grain section
		viewGrains.setLayoutX(300);
		viewGrains.setLayoutY(100);
		viewGrains.setText("View Grains");
		viewGrains.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Grain products");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewNuts = new Button(); //View the nuts section
		viewNuts.setLayoutX(300);
		viewNuts.setLayoutY(150);
		viewNuts.setText("View Nuts and Seeds");
		viewNuts.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Nuts seeds and products");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewSweets = new Button(); //View the desert section
		viewSweets.setLayoutX(300);
		viewSweets.setLayoutY(200);
		viewSweets.setText("View Sweeteners and Sweets");
		viewSweets.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Sweeteners and sweets");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewLunchmeat = new Button(); //View the lunchmeat section
		viewLunchmeat.setLayoutX(300);
		viewLunchmeat.setLayoutY(250);
		viewLunchmeat.setText("View Sausages and Lunchmeats");
		viewLunchmeat.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Sausages and lunchmeats");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewEggs = new Button(); //View the eggs section
		viewEggs.setLayoutX(300);
		viewEggs.setLayoutY(300);
		viewEggs.setText("View Eggs");
		viewEggs.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Eggs");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button viewMisc = new Button(); //View the miscellaneous foods
		viewMisc.setLayoutX(300);
		viewMisc.setLayoutY(350);
		viewMisc.setText("View Miscellaneous");
		viewMisc.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Food.displayFood("Miscellaneous");
				display.setText(Food.tempDisplay);
				primaryStage.setScene(displayScene);
			}			
		});
		
		Button returnMain = new Button(); //Returns to main menu
		returnMain.setLayoutX(460);
		returnMain.setLayoutY(410);
		returnMain.setText("Return to Main Menu");
		returnMain.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				primaryStage.setScene(mainScene);
			}			
		});
		
		Button returnMain2 = new Button(); //Returns to main menu
		returnMain2.setLayoutX(460);
		returnMain2.setLayoutY(410);
		returnMain2.setText("Return to Main Menu");
		returnMain2.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				primaryStage.setScene(mainScene);
			}			
		});
		
		Button returnMain3 = new Button(); //Returns to main menu
		returnMain3.setLayoutX(850);
		returnMain3.setLayoutY(550);
		returnMain3.setText("Return to Main Menu");
		returnMain3.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				primaryStage.setScene(mainScene);
			}			
		});
		
		Button returnFood = new Button(); //Returns to food menu
		returnFood.setLayoutX(250);
		returnFood.setLayoutY(410);
		returnFood.setText("Return to Food Menu");
		returnFood.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				primaryStage.setScene(foodScene);
			}			
		});
		
		//Adds all functions to each respective scene
		mainGroup.getChildren().add(results); 
		mainGroup.getChildren().add(submit);
		mainGroup.getChildren().add(instructions);
		mainGroup.getChildren().add(todo);
		mainGroup.getChildren().add(title);
		mainGroup.getChildren().add(foodinput);
		mainGroup.getChildren().add(input);
		mainGroup.getChildren().add(viewFood);
		mainGroup.getChildren().add(error);
		
		foodGroup.getChildren().add(viewMeat);
		foodGroup.getChildren().add(viewSoups);
		foodGroup.getChildren().add(viewFruits);
		foodGroup.getChildren().add(viewBaked);
		foodGroup.getChildren().add(viewVegetables);
		foodGroup.getChildren().add(viewBeverages);
		foodGroup.getChildren().add(viewFats);
		foodGroup.getChildren().add(viewDairy);
		foodGroup.getChildren().add(viewSeafood);
		foodGroup.getChildren().add(viewPoultry);
		foodGroup.getChildren().add(viewMixed);
		foodGroup.getChildren().add(viewGrains);
		foodGroup.getChildren().add(viewNuts);
		foodGroup.getChildren().add(viewSweets);
		foodGroup.getChildren().add(viewLunchmeat);
		foodGroup.getChildren().add(viewEggs);
		foodGroup.getChildren().add(returnMain);
		
		displayGroup.getChildren().add(display);
		displayGroup.getChildren().add(returnMain2);
		displayGroup.getChildren().add(returnFood);
		
		resultsGroup.getChildren().add(userValues);
		resultsGroup.getChildren().add(dailyValues);
		resultsGroup.getChildren().add(difference);
		resultsGroup.getChildren().add(returnMain3);
		resultsGroup.getChildren().add(warnings);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	

}
package builderpattern;

public class BuilderPatterDemo {
	public static void main(String[] args) {
		
		MealBuilder mealBulider=new  MealBuilder();
		
		Meal  vegMeal=mealBulider.prePareVegMeal();
	    System.out.println("Veg Meal");
	    vegMeal.showItems();
	    System.out.println("Total  Cost:"+vegMeal.getCost());
	   
	    Meal nonVegMeal=mealBulider.perpareNonVegMeal();
	    System.out.println("\n\nNon-Veg  Meal");
	    nonVegMeal.showItems();
	    System.out.println("Total  Cost:"+nonVegMeal.getCost());
	}
    
}

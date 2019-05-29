package builderpattern;


public class MealBuilder {
	public Meal prePareVegMeal(){
		Meal meal =new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}
    public  Meal perpareNonVegMeal(){
    	Meal meal=new Meal();
    	meal.addItem(new ChickenBurger());
    	meal.addItem(new Pepsi());
    	return meal;
    }
}

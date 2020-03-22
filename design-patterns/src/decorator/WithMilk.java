package decorator;

import decorator.service.BaseCoffeeDecorator;
import decorator.service.Coffee;

/**
 * @author: huu
 * @date: 2020/3/20 11:01
 * @description:
 */
public class WithMilk extends BaseCoffeeDecorator {

    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        double additionalCost = 0.5;
        return super.getCost() + additionalCost;
    }

    @Override
    public String getIngredients() {
        String additionalIngredients = "milk";
        return super.getIngredients() + "," +additionalIngredients;
    }
}

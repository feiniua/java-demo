package decorator.service;

/**
 * @author: huu
 * @date: 2020/3/20 10:58
 * @description:
 */
public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Coffee";
    }

}

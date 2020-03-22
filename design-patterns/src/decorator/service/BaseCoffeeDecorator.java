package decorator.service;

/**
 * @author: huu
 * @date: 2020/3/20 10:59
 * @description:
 */
public class BaseCoffeeDecorator implements Coffee {
    private final Coffee coffee;

    public BaseCoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients();
    }

}

package code;

import org.junit.Test;

public class ShoppingCartTest {
    @Test
    public void testShopingCart(){

        Cart cart = new Cart();

        Item item = new Item("Watch", 1.0);
        Item watch1 = item.clone();

        Item bag = new Item("Bag", 2.0);
        Item bag2 = bag.clone();

        cart.addItem(item);
        cart.addItem(watch1);
        cart.addItem(bag);
        cart.addItem(bag2);

        System.out.println(cart.getItemizedList());
        System.out.println(cart.getItemizedQuantity());
        System.out.println(cart.getItemizedListString());
        System.out.println(cart.getItemSummary());
        System.out.println(cart.getItemizedSummaryString());
    }


}

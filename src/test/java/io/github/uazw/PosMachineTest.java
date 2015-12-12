package io.github.uazw;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PosMachineTest {

    private PosMachine machine;

    @Before
    public void setUp() throws Exception {
        machine = new PosMachine(Arrays.asList(
                new Item("ITEM000001", 40), new Item("ITEM000002", 50), new Item("ITEM000003", 60)));
    }

    @Test
    public void should_return_price_of_item_when_given_single_item() {

        double total = machine.cost(Arrays.asList(new Cart("ITEM000001", 3)));

        assertEquals(total, 40 * 3, 1e-6);
    }

    @Test
    public void should_return_summarize_of_items() {
        double total = machine.cost(Arrays.asList(new Cart("ITEM000001", 3), new Cart("ITEM000002", 2)));

        assertEquals(total, 40 * 3 + 50 * 2, 1e-6);
    }

    @Test
    public void should_return_zero_when_given_no_item() {
        double total = machine.cost(Arrays.asList());

        assertEquals(total, 0, 1e-6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_item_not_contain_cart() {

        machine.cost(Arrays.asList(new Cart("ITEM000004", 2)));
    }

    @Test
    public void should_return_cost_with_discount_promotion() {
        Promotion promotion = new DiscountPromotion("ITEM000001", 50);
        machine.addPromotion(promotion);

        double total = machine.cost(Arrays.asList(new Cart("ITEM000001", 3)));

        assertEquals(total, 40 * 3 * 0.5, 1e-6);
    }

    @Test
    public void should_return_cost_with_second_half_promotion() {
        Promotion promotion = new SecondHalfPromotion("ITEM000001");
        machine.addPromotion(promotion);

        double total = machine.cost(Arrays.asList(new Cart("ITEM000001", 3)));

        assertEquals(total, 40 * 2 + 20, 1e-6);
    }

    @Test
    public void should_return_cost_with_discount_and_second_half_promotion() {

        Promotion discount = new DiscountPromotion("ITEM000002", 50);
        Promotion secondHalf = new SecondHalfPromotion("ITEM000002");
        Promotion comp = new CompPromotion("ITEM000002", discount, secondHalf);
        machine.addPromotion(comp);

        double total = machine.cost(Arrays.asList(new Cart("ITEM000002", 3)));

        assertEquals(total, 62.5, 1e-6);
    }

    @Test
    public void should_return_cost_with_second_half_and_discount_promotion() {
        Promotion discount = new DiscountPromotion("ITEM000002", 50);
        Promotion secondHalf = new SecondHalfPromotion("ITEM000002");
        Promotion comp = new CompPromotion("ITEM000002", secondHalf, discount);
        machine.addPromotion(comp);

        double total = machine.cost(Arrays.asList(new Cart("ITEM000002", 3)));
        assertEquals(total, 62.5, 1e-6);
    }
}

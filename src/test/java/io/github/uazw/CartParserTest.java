package io.github.uazw;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CartParserTest {

    private CartParser cartParser;

    @Before
    public void setUp() throws Exception {
        cartParser = new CartParser();
    }

    @Test
    public void should_return_Cart_info_when_given_current_form() {

        Cart cart = cartParser.parser("ITEM000001-3");

        assertEquals(cart.getBncode(), "ITEM000001");
        assertEquals(cart.getCount(), 3);
    }

    @Test
    public void should_return_Cart_info_when_cart_form_without_number() {

        Cart cart = cartParser.parser("ITEM000001");

        assertEquals(cart.getBncode(), "ITEM000001");
        assertEquals(cart.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_cart_form_() {

        Cart cart = cartParser.parser("2323-xdf");
    }

    @Test
    public void should_return_current_size_of_cartList() {


        List<Cart> carts = cartParser.parser(Arrays.asList("ITEM000001-3", "ITEM000002-2", "ITEM000003"));

        assertEquals(carts.size(), 3);
    }
}

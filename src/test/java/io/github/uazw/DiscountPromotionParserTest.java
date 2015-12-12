package io.github.uazw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountPromotionParserTest {

    private DiscountPromotionParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new DiscountPromotionParser();
    }

    @Test
    public void should_return_current_info_when_given_current() {

        DiscountPromotion promotion = parser.parser("ITEM000001:75");

        assertEquals(promotion.getBnCode(), "ITEM000001");
        assertEquals(promotion.discount(), 75);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_given_without_discount() {

        parser.parser("ITEM000001");
    }
}

package io.github.uazw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecondHalfPromotionParserTest {

    private SecondHalfPromotionParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new SecondHalfPromotionParser();
    }

    @Test
    public void should_return_current_promotion_when_given_current() {

        SecondHalfPromotion promotion = parser.parser("ITEM000001");
        assertEquals(promotion.getBnCode(), "ITEM000001");
    }
}

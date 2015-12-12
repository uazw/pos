package io.github.uazw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemParserTest {

    private ItemParser itemParser;


    @Before
    public void setUp() throws Exception {
        itemParser = new ItemParser();

    }

    @Test
    public void should_return_item_info_when_given_current_form_of_item() {
        Item item = itemParser.parser("ITEM000005:60");

        assertEquals(item.getBnCode(), "ITEM000005");
        assertEquals(item.getPrice(), 60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_given_form_without_number() {

        itemParser.parser("ITEM000005:");
    }
}

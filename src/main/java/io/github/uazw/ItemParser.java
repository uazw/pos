package io.github.uazw;

import java.util.regex.Matcher;

public class ItemParser extends Parser<Item> {

    @Override
    protected String getPattern() {
        return "(?<bncode>\\w+):(?<price>\\d+)";
    }

    @Override
    protected Item generateFrom(Matcher matcher) {
        return new Item(matcher.group("bncode"), Integer.parseInt(matcher.group("price")));
    }
}

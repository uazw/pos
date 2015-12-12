package io.github.uazw;

import java.util.regex.Matcher;

public class CartParser extends Parser<Cart> {

    private final String PATTERN = "(?<bncode>\\w+)(-(?<count>\\d+))?";

    @Override
    protected String getPattern() {
        return PATTERN;
    }

    @Override
    protected Cart generateFrom(Matcher matcher) {
        if (matcher.group("count") == null) {
            return new Cart(matcher.group("bncode"), 1);
        } else {
            return new Cart(matcher.group("bncode"), Integer.parseInt(matcher.group("count")));
        }
    }

}

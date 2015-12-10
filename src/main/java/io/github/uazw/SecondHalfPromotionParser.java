package io.github.uazw;

import java.util.regex.Matcher;

public class SecondHalfPromotionParser extends Parser<SecondHalfPromotion> {
    @Override
    protected String getPattern() {
        return "(?<bncode>\\w+)";
    }

    @Override
    protected SecondHalfPromotion generateFrom(Matcher matcher) {
        return new SecondHalfPromotion(matcher.group("bncode"));
    }
}

package io.github.uazw;

import java.util.regex.Matcher;

public class DiscountPromotionParser extends Parser<DiscountPromotion> {

    @Override
    protected String getPattern() {
        return "(?<bncode>\\w+):(?<discount>\\d+)";
    }

    @Override
    protected DiscountPromotion generateFrom(Matcher matcher) {
        return new DiscountPromotion(matcher.group("bncode"), Integer.parseInt(matcher.group("discount")));
    }

}

package io.github.uazw;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class Parser<T> {

    public T parser(String cartStr) {
        Pattern pattern = Pattern.compile(getPattern());
        Matcher matcher = pattern.matcher(cartStr);
        if (matcher.matches()) {
            return generateFrom(matcher);
        }
        throw new IllegalArgumentException("cart form error");
    }

    protected abstract String getPattern();

    protected abstract T generateFrom(Matcher matcher);

    public List<T> parser(List<String> cartStrs) {
        return cartStrs.stream().map(this::parser).collect(Collectors.toList());
    }
}

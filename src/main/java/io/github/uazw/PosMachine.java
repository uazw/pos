package io.github.uazw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosMachine {

    private List<Item> items;
    private Map<String, Promotion> promotions = new HashMap<>();
    private final Promotion defaultPromotion = new DefaultPromotion();

    public PosMachine(List<Item> items) {
        this.items = items;
    }

    public double cost(List<Cart> carts) {
        return carts.stream().map(this::cost).reduce(0.0, Double::sum);
    }

    public double cost(Cart cart) {
        Item result =
                items.stream()
                .filter(item -> item.getBnCode().equals(cart.getBncode()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(cart.getBncode() + " not existed"));

        return promotions.getOrDefault(cart.getBncode(), defaultPromotion).apply(cart, result.getPrice());
    }

    public void addPromotion(Promotion promotion) {
        promotions.put(promotion.getBnCode(), promotion);
    }


    private final static class DefaultPromotion implements Promotion {

        @Override
        public double apply(Cart cart, double price) {
            return cart.getCount() * price;
        }

        @Override
        public String getBnCode() {
            return "";
        }
    }
}

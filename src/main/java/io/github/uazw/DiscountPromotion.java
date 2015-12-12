package io.github.uazw;

public class DiscountPromotion implements Promotion {

    private String bnCode;
    private int discount;

    public String getBnCode() {
        return bnCode;
    }

    public int discount() {
        return discount;
    }

    public DiscountPromotion(String bnCode, int discount) {
        this.bnCode = bnCode;
        this.discount = discount;
    }

    @Override
    public double apply(Cart cart, double price) {
        return cart.getCount() * price * discount / 100;
    }
}

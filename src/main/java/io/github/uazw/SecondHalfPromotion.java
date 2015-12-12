package io.github.uazw;

public class SecondHalfPromotion implements Promotion {
    private String bnCode;

    public SecondHalfPromotion(String bnCode) {
        this.bnCode = bnCode;
    }

    @Override
    public double apply(Cart cart, double price) {
        return (cart.getCount() * price) - ((price / 2) * (cart.getCount() / 2));
    }

    @Override
    public String getBnCode() {
        return bnCode;
    }
}

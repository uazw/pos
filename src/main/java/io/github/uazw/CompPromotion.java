package io.github.uazw;

public class CompPromotion implements Promotion {

    private String bnCode;
    private Promotion car;
    private Promotion cdr;

    public CompPromotion(String bnCode, Promotion car, Promotion cdr) {
        this.bnCode = bnCode;
        this.car = car;
        this.cdr = cdr;
    }

    @Override
    public double apply(Cart cart, double price) {
        return cdr.apply(cart, car.apply(cart, price) / cart.getCount());
    }

    @Override
    public String getBnCode() {
        return bnCode;
    }
}

package io.github.uazw;


public interface Promotion {
    double apply(Cart cart, double price);
    String getBnCode();
}

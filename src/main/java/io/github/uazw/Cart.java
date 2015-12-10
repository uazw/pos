package io.github.uazw;

public class Cart {
    private String bncode;
    private int count;

    public Cart(String bncode, int count) {

        this.bncode = bncode;
        this.count = count;
    }

    public String getBncode() {
        return bncode;
    }

    public int getCount() {
        return count;
    }
}

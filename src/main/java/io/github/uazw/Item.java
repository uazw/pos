package io.github.uazw;

public class Item {
    private String bnCode;
    private int price;

    public Item(String bnCode, int price) {
        this.bnCode = bnCode;

        this.price = price;
    }

    public String getBnCode() {
        return bnCode;
    }

    public int getPrice() {
        return price;
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;
    private static Cart instance;

    public Cart() {
        items = new ArrayList<>();
    }
    /**
     * Sequence diagram: AddCart - CNPM
     * 2.1.4: add(Product) (is sent by AddToCartServlet)
     */
    public void add(Product p) {
        for (Product item : items) {
            if (p.getId() == item.getId()) {
                item.setNumber(item.getNumber() + p.getNumber());
                return;
            }
        }
        items.add(p);
    }
    /**
     * Sequence diagram: UpdateQuantity - CNPM
     * 3.2.1: add(Product, pQuantity) (is sent by AddToCartServlet)
     */
    public void add(Product p, int quantity) {
        for (Product item : items) {
            if (p.getId() == item.getId()) {
                item.setNumber(quantity);
                return;
            }
        }
        items.add(p);
    }
    /**
     * Sequence diagram: UpdateQuantity - CNPM
     * 3.2.2: remove(Product) (is sent by AddToCartServlet)
     */
    /**
     * Sequence diagram: RemoveItem - CNPM
     * 3.2.7: remove(Product) (is sent by AddToCartServlet)
     */
    public void remove(Product p) {
        for (Product item : items) {
            if (p.getId() == item.getId()) {
                items.remove(item);
                return;
            }
        }
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        double amount = 0;
        for (Product item : items) {
            System.out.print(item.getPrice());
            amount += item.getNumber() * item.getPrice();
        }
        return Math.round(amount);
    }
    public int getTotal() {
        return items.size();
    }
    public double getVNTotalAmount() {
        return Math.ceil(this.getTotalAmount() * 25452.48);
    }

    /**
     * Sequence diagram: AddCart - CNPM
     * 2.1.3: getInstance() (is sent by AddToCartServlet)
     */
    public static Cart getInstance() {
        if(instance==null) instance = new Cart();
        return instance;
    }

    public void clear() {
        items.clear();
    }
}
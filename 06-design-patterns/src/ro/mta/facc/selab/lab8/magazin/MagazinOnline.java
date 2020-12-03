package ro.mta.facc.selab.lab8.magazin;

import java.util.HashMap;



public class MagazinOnline {
    private HashMap<String, Integer> products = new HashMap<>();

    public void sell(String product, int quantity)
            throws NotEnoughProductsException {
        if (products.get(product) < quantity)
            throw new NotEnoughProductsException();
        products.put(product, products.get(product));
        Logger.getInstance().log("Sold " + quantity + " " + product + "'s");
    }

    public void restock(HashMap<String, Integer> newProducts)
    {
        for (String key : newProducts.keySet()) {
            if (products.get(key) == null)
                products.put(key, newProducts.get(key));
            else
                products.put(key, products.get(key) + newProducts.get(key));
        }
        Logger.getInstance().log("Restocked " + getStockString());
    }

    public String getStockString()
    {
        StringBuilder sb = new StringBuilder();
        for (String key : products.keySet()) {
            sb.append(key + " : " + products.get(key) + "\n");
        }
        return sb.toString();
    }
}

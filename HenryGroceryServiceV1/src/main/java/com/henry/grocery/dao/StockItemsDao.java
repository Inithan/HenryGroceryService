package com.henry.grocery.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.henry.grocery.model.StockItems;

@Repository
public class StockItemsDao {

	
	private static final Map<String, StockItems> grocery = new HashMap<String, StockItems>();
	 
    static {
        initGrocery();
    }
 
    private static void initGrocery() {
        StockItems item1 = new StockItems("soup", "tin", 0.65);
        StockItems item2 = new StockItems("bread", "loaf", 0.80);
        StockItems item3 = new StockItems("milk", "bottle", 1.30);
        StockItems item4 = new StockItems("apples", "single", 0.10);
 
        grocery.put(item1.getProduct(), item1);
        grocery.put(item2.getProduct(), item2);
        grocery.put(item3.getProduct(), item3);
        grocery.put(item4.getProduct(), item4);
    }
 
    public StockItems getStockItems(String product) {
        return grocery.get(product);
    }
 
 
 
    public List<StockItems> getAllStockItemss() {
        Collection<StockItems> c = grocery.values();
        List<StockItems> list = new ArrayList<StockItems>();
        list.addAll(c);
        return list;
    }

	public Double getProductPrice(String product) {
		StockItems res=grocery.get(product);
		return res.getCost();
	}
}

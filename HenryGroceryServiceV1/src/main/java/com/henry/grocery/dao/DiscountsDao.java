package com.henry.grocery.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.henry.grocery.model.Discounts;

@Repository
public class DiscountsDao {
	
	private static final Map<String, Discounts> discount = new HashMap<String, Discounts>();
	 
    static {
        initdiscount();
    }
 
    private static void initdiscount() {
        Discounts item1 = new Discounts("Buy 2 tins of soup and get a loaf of bread half price", -1L,7L,"soup","bread", 50.0);
        Discounts item2 = new Discounts("Apples have a 10% discount", +3L, -30L, "apples","apples", 10.0);
 
        discount.put(item1.getProduct(), item1);
        discount.put(item2.getProduct(), item2);
    }
 
    public Discounts getDiscounts(String product) {
        return discount.get(product);
    }
 
 
 
    public List<Discounts> getAllDiscountss() {
        Collection<Discounts> c = discount.values();
        List<Discounts> list = new ArrayList<Discounts>();
        list.addAll(c);
        return list;
    }

}

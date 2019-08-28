package com.henry.grocery.service;

import java.util.List;

import com.henry.grocery.model.Discounts;
import com.henry.grocery.model.Input;
import com.henry.grocery.model.Output;
import com.henry.grocery.model.StockItems;

public interface HenryService {

	List<StockItems> getStockItems();

	List<Discounts> getDiscounts();

	Output getPriceBasket(Input request);

}

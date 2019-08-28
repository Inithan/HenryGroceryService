package com.henry.grocery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.grocery.dao.DiscountsDao;
import com.henry.grocery.dao.StockItemsDao;
import com.henry.grocery.model.Discounts;
import com.henry.grocery.model.Input;
import com.henry.grocery.model.Output;
import com.henry.grocery.model.ProductDetails;
import com.henry.grocery.model.StockItems;

@Service
public class HenryServiceImpl implements HenryService{
	
	private static final Logger logger = LoggerFactory.getLogger(HenryServiceImpl.class);
	
	@Autowired
	private StockItemsDao stockItemsDao;
	@Autowired
	private DiscountsDao discountsDao;

	@Override
	public List<StockItems> getStockItems() {
	return stockItemsDao.getAllStockItemss();
	}

	@Override
	public List<Discounts> getDiscounts() {
	return discountsDao.getAllDiscountss();
	}

	@Override
	public Output getPriceBasket(Input request) {
		
		logger.info(request.toString());
		
		Output response=new Output();
		Double discount_price=0.0;
		Double total_price=0.0;
		Double final_price=0.0;
		try {
			
			total_price=getTotal_price(request);
			discount_price=getDiscount_price(request);
			final_price=total_price-discount_price;
			
			response.setProductDetails(request.getProductDetails());
			response.setDays(request.getDays());
			response.setTotal_price(total_price);
			response.setDiscount_price(discount_price);
			response.setFinal_price(final_price);
			
		}catch(Exception ex) {ex.printStackTrace();}
		
		logger.info(response.toString());
		return response;
	}

	private Double getDiscount_price(Input request) {
		Double discount_price=0.0;
		List<Discounts> availableDiscounts = discountsDao.getAllDiscountss();
		List<ProductDetails> availableItems = request.getProductDetails();
		
		for(ProductDetails data: availableItems) {			
			Discounts res=availableDiscounts.stream().filter(x -> data.getProduct().equals(x.getDiscount_product())).findAny().orElse(null);
			
			if(null!=res) {
				if("apples".equals(data.getProduct()) && request.getDays()>3) {
					discount_price=discount_price+(stockItemsDao.getProductPrice(data.getProduct())*(res.getDiscount_percentage()/100)*data.getCount());
				}else if("bread".equals(data.getProduct()) && request.getDays()<=7) {
					ProductDetails product=availableItems.stream().filter(x -> "soup".equals(x.getProduct())).findAny().orElse(null);
						
					if(product.getCount()>1) {
						Double discountPerBread = stockItemsDao.getProductPrice(data.getProduct())*(res.getDiscount_percentage()/100);
						long possibleDiscountCount = product.getCount()/2;
						long totalBreadCount = data.getCount();
						long discountApplicableBreadCount =  possibleDiscountCount==totalBreadCount?totalBreadCount:possibleDiscountCount>totalBreadCount?totalBreadCount:possibleDiscountCount<totalBreadCount?possibleDiscountCount:0L;
						discount_price=discount_price+discountApplicableBreadCount*discountPerBread;
					}
				}
			}
			
		}
		
		return discount_price;
	}

	private Double getTotal_price(Input request) {
		Double total_price=0.0;
		List<StockItems> availableStocks = stockItemsDao.getAllStockItemss();
		List<ProductDetails> availableItems = request.getProductDetails();
		
		for(ProductDetails data: availableItems) {			
			StockItems res=availableStocks.stream().filter(x -> data.getProduct().equals(x.getProduct())).findAny().get();
			total_price=total_price+(res.getCost()*data.getCount());
		}
		
		return total_price;
	}

}

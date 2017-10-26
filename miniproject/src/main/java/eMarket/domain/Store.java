package eMarket.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
	List<Product> productList = new ArrayList<>();
	List<Deal> dealList = new ArrayList<>();
	
	public void init() {
		productList = new ArrayList<>();
		dealList = new ArrayList<>();
		Product.lastId=0;
		Deal.lastId=0;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}
	
	
}

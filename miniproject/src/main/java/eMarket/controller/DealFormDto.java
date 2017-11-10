package eMarket.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import eMarket.EMarketApp;
import eMarket.domain.Deal;
import eMarket.domain.Product;

// imports and annotations may be required
public class DealFormDto {
	
	public static int lastId = 0;
    private int id = -1;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    
    private double discount;
	private Product product = null;
	
	private int productId;
	
	public DealFormDto() {}
	
	public DealFormDto(int id, LocalDate s, double dis, Product p) {
		productId = id;
		startDate = s;
		discount = dis;
		product = p;	
	}
	
	public DealFormDto(int id, LocalDate s, double dis, Product p, LocalDate end) {
		productId = id;
		startDate = s;
		discount = dis;
		product = p;
		endDate = end;
	}
	
	public List<Product> getProductList(){
		
		return EMarketApp.getStore().getProductList();

	}
	
	public int getProductId() {
		return productId;
	}

	public void setId() {
		this.id = lastId;
		lastId++;
	}
	
	public void close() {
		this.endDate = new Date().toInstant().atZone(ZoneId.of("GMT")).toLocalDate();
	}

	
	
	public boolean isActive() {
		boolean active = false;
		LocalDate today = eMarket.EMarketApp.getSystemDate();
		
		if(endDate == null) {
			if(startDate.isBefore(today) || startDate == today) {
				active = true;
			}
		}
		
		if(endDate != null) {
			
			if(startDate.isBefore(today) || startDate == today) {
				if(endDate.isAfter(today) || endDate == today) {
					active = true;
				}
			}
		}
		
		return active;
	}
	
	public String getStartDateAsString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.startDate.format(formatter);
	}

	public String getEndDateAsString() {
		if (endDate != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return this.endDate.format(formatter);
		}
		return "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}

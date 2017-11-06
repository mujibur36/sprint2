package eMarket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import eMarket.domain.Deal;
import eMarket.domain.Product;
import eMarket.domain.Store;

@SpringBootApplication
public class EMarketApp extends WebMvcConfigurerAdapter implements CommandLineRunner {

	private static Store store = new Store();
	
	public static Store getStore() {
		return store;
	}

	private static LocalDate systemDate;
	
    public static LocalDate getSystemDate() {
		return systemDate;
	}

	public static void setSystemDate(LocalDate systemDate) {
		EMarketApp.systemDate = systemDate;
	}

	public static void main(String[] args) {
        SpringApplication.run(EMarketApp.class, args);
    }

    public void run(String... args) {
    		// initialize calendar
    	 	Calendar calendar = Calendar.getInstance();
    	 	calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
    	 	systemDate = calendar.getTime().toInstant().atZone(ZoneId.of("GMT")).toLocalDate();
    	
    		// PRODUCTS
    		Product banana = new Product(0,"Banana","yellow",0.16);
    		EMarketApp.getStore().getProductList().add(banana);
    		Product orange = new Product(1,"Orange","Valencian",0.20);
    		EMarketApp.getStore().getProductList().add(orange);
    		EMarketApp.getStore().getProductList().add(new Product(2,"Apple","Royal Gala",0.25));
    		Product.lastId = 3;
    		
    		// DEALS
    		// bananas
    		SimpleDateFormat isoFormat = new SimpleDateFormat("dd/MM/yyyy");
    		isoFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    		String startDate = "02/08/2017";
    		try {
            LocalDate newDate = isoFormat.parse(startDate).toInstant().atZone(ZoneId.of("GMT")).toLocalDate();

            Deal deal = new Deal(0,newDate,0.10,banana);
            deal.close();
            EMarketApp.getStore().getDealList().add(deal);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    		// oranges
		LocalDate today = getSystemDate();
        Deal deal = new Deal(1,today,0.20,orange);
        deal.close();
        EMarketApp.getStore().getDealList().add(deal);

    		Deal.lastId = 2;
    		
    }
}

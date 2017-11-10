package eMarket.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eMarket.EMarketApp;
import eMarket.domain.Deal;

@Controller
@RequestMapping("/deal")
public class DealController {
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    		binder.addValidators(new DealValidator());
    }
    
    //implement handler methods
    @RequestMapping(value = "/")
    public String index(@ModelAttribute("dealFormDto") DealFormDto dealFormDto, Model model) {
    	
    	model.addAttribute("dealList", EMarketApp.getStore().getDealList()); 
    	return "form/productDeal";
    	
    	
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("dealFormDto") DealFormDto dealDto, Model model, BindingResult result) {
    	
    	if (!result.hasErrors() ) {
    		Deal d = new Deal(dealDto.getId(), dealDto.getStartDate(), dealDto.getDiscount(), dealDto.getProduct());
    		d.setId();
    		if(dealDto.getEndDate() != null) {
				d.setEndDate(dealDto.getEndDate());
			}
    		
    		EMarketApp.getStore().getDealList().add(d);
    	}
    
    	
    	model.addAttribute("dealList", EMarketApp.getStore().getDealList());
    	return "form/productDeal";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=false, defaultValue="-1") int id, Model model) {
    	
    	Deal d2 = null;
		for (Deal d : EMarketApp.getStore().getDealList()) {
			if (d.getId()==id) {
				d2 = d;
				break;
			}
		}
		
		d2.close();
    	
    	model.addAttribute("dealList", EMarketApp.getStore().getDealList());
    	return "form/productDeal";
    }
    
    
    
}

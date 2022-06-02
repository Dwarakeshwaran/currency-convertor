package managecurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import managecurrency.model.Currency;
import managecurrency.service.ManageCurrencyService;

@Controller
public class ManageCurrencyController {

	@Autowired
	private ManageCurrencyService service;

	@RequestMapping(method = RequestMethod.POST, path = "/saveDetails")
	@ResponseBody
	public String saveDetails() {

		Currency currency = new Currency();
		currency.setCountryCode("JPY");
		currency.setConversionFactor(15L);

		service.saveDetails(currency);

		return "Added";

	}

}

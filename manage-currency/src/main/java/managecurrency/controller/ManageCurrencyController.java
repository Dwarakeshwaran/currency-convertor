package managecurrency.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import managecurrency.dto.CurrencyDTO;
import managecurrency.entity.Currency;
import managecurrency.service.ManageCurrencyService;

@Controller
public class ManageCurrencyController {

	@Autowired
	private ManageCurrencyService service;

	@Autowired
	private ModelMapper mapper;

	@RequestMapping(method = RequestMethod.POST, value = "/saveDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveCurrencyDetails(@RequestBody CurrencyDTO currencyDto) {

		Currency currency = mapper.map(currencyDto, Currency.class);
		
		if(service.checkCurrencyCodeAvailability(currency.getCountryCode()))
			service.saveCurrencyDetails(currency);
		else
			service.updateCurrencyDetails(currency);

		return new ResponseEntity<String>(currencyDto + " Loaded to DB", HttpStatus.OK);

	}

}

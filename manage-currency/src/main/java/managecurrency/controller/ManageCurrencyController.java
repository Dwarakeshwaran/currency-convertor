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
@RequestMapping("api")

public class ManageCurrencyController {

	@Autowired
	private ManageCurrencyService service;

	@Autowired
	private ModelMapper mapper;

	@RequestMapping(method = RequestMethod.POST, value = "saveCurrency", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveCurrencyDetails(@RequestBody CurrencyDTO currencyDto) {

		if (currencyDto.getCountryCode().isEmpty() || currencyDto.getConversionFactor() == 0
				|| currencyDto.getConversionFactor() == null || currencyDto.getCountryCode() == null)
			return new ResponseEntity<String>("Should Not Contain Null Values", HttpStatus.BAD_REQUEST);
		else {
			Currency currency = mapper.map(currencyDto, Currency.class);

			if (service.checkCurrencyCodeAvailability(currency.getCountryCode()))
				return new ResponseEntity<String>(currencyDto.getCountryCode() + " Already Exists",
						HttpStatus.BAD_REQUEST);
			else {
				service.saveCurrencyDetails(currency);
				return new ResponseEntity<String>(currencyDto + " Loaded to DB", HttpStatus.OK);
			}
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "checkAvailability", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkCurrencyDetails(@RequestBody CurrencyDTO currencyDto) {

		Currency currency = mapper.map(currencyDto, Currency.class);

		if (service.checkCurrencyCodeAvailability(currency.getCountryCode()))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(method = RequestMethod.POST, value = "updateCurrency", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCurrencyDetails(@RequestBody CurrencyDTO currencyDto) {

		if (currencyDto.getCountryCode().isEmpty() || currencyDto.getConversionFactor() == 0
				|| currencyDto.getConversionFactor() == null || currencyDto.getCountryCode() == null)
			return new ResponseEntity<String>("Should Not Contain Null Values", HttpStatus.BAD_REQUEST);
		else {
			Currency currency = mapper.map(currencyDto, Currency.class);

			if (service.checkCurrencyCodeAvailability(currency.getCountryCode())) {
				service.updateCurrencyDetails(currency);
				return new ResponseEntity<String>(currencyDto + " Updated", HttpStatus.OK);
			} else
				return new ResponseEntity<String>(currencyDto.getCountryCode() + " Does not Exists",
						HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "getConversionFactor", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getConversionFactor(@RequestBody CurrencyDTO currencyDto) {

		if (currencyDto.getCountryCode().isEmpty() || currencyDto.getCountryCode() == null)
			return new ResponseEntity<String>("Should Not Contain Null Values", HttpStatus.BAD_REQUEST);
		else {
			Currency currency = mapper.map(currencyDto, Currency.class);

			Double conversionFactor = service.getConversionFactor(currency);

			if (conversionFactor == null)
				return new ResponseEntity<String>(currencyDto.getCountryCode() + " Does not Exists",
						HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<String>(conversionFactor.toString(), HttpStatus.OK);
		}

	}

}

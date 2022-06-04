package dwaki.convertcurrency.service;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwaki.convertcurrency.dto.CurrencyDTO;
import dwaki.convertcurrency.entity.Currency;

@Service
@Transactional
public class ConvertCurrencyService {

	@Autowired
	private SessionFactory factory;

	@Autowired
	private ModelMapper mapper;
	
	public boolean checkCurrencyCodeAvailability(String currencyCode) {

		Session session = factory.getCurrentSession();

		Currency currency = session.get(Currency.class, currencyCode);

		System.out.println("Currency: " + currency);

		if (currency != null)
			return true;
		else
			return false;
	}

	public Double convertAmount(String countryCode, Double amount) {

		Double convertedAmount = null;
		Double conversionFactory = null;

		Session session = factory.getCurrentSession();

		try {

			Currency currency = session.get(Currency.class, countryCode);
			CurrencyDTO currencyDto = mapper.map(currency, CurrencyDTO.class);

			conversionFactory = currencyDto.getConversionFactor();
			convertedAmount = 1 / conversionFactory;

		} catch (Exception exception) {
			System.out.println("Exception occurred while converting the amount " + exception);
		}

		return convertedAmount;
	}

}

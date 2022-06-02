package managecurrency.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import managecurrency.entity.Currency;

@Service
@Transactional
public class ManageCurrencyService {

	@Autowired
	private SessionFactory factory;

	public void saveCurrencyDetails(Currency currency) {

		Session session = factory.getCurrentSession();

		session.save(currency);

	}

	public boolean checkCurrencyCodeAvailability(String currencyCode) {

		Session session = factory.getCurrentSession();

		Currency currency = session.get(Currency.class, currencyCode);

		System.out.println("Currency: " + currency);

		if (currency != null)
			return true;
		else
			return false;
	}

	public void updateCurrencyDetails(Currency currency) {

		Session session = factory.getCurrentSession();

		session.update(currency);

	}

	public Double getConversionFactor(Currency currency) {

		Double conversionFactor = null;
		Session session = factory.getCurrentSession();

		if (checkCurrencyCodeAvailability(currency.getCountryCode()))
			conversionFactor = session.get(Currency.class, currency.getCountryCode()).getConversionFactor();

		return conversionFactor;

	}

}

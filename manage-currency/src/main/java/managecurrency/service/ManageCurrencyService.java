package managecurrency.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import managecurrency.model.Currency;

@Service
@Transactional
public class ManageCurrencyService {

	@Autowired
	private SessionFactory factory;

	public void saveDetails(Currency currency) {

		Session session = factory.getCurrentSession();

		session.save(currency);

	}

}

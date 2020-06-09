package by.softclub.stm_scheduler.service;

import by.softclub.stm_scheduler.domain.Currency;
import by.softclub.stm_scheduler.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Currency> list() {
        return currencyRepository.findAll();
    }

    @Override
    public int save(Currency currency) {
        return currencyRepository.save(currency).getId();
    }
}

package by.softclub.stm_scheduler.service;

import by.softclub.stm_scheduler.domain.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> list();
    int save(Currency currency);
}

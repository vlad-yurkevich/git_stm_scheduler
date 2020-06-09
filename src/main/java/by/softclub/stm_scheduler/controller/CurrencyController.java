package by.softclub.stm_scheduler.controller;

import by.softclub.stm_scheduler.domain.Currency;
import by.softclub.stm_scheduler.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping(value = "/list")
    public List<Currency> list() {
        return currencyService.list();
    }

    @PostMapping
    public int save(@RequestBody Currency currency) {
        return currencyService.save(currency);
    }
}

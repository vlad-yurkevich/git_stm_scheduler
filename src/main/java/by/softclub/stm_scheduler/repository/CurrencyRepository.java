package by.softclub.stm_scheduler.repository;

import by.softclub.stm_scheduler.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Optional<Currency> findByCode(String code);
}

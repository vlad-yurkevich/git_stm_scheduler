package by.softclub.stm_scheduler.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class OrderDto {

    private int id;

    private String sourceCurrency;

    private String targetCurrency;

    private BigDecimal amount;

    private BigDecimal fee;

    private String userEmail;
}

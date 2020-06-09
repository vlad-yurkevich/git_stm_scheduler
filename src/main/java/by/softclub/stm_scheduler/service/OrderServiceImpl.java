package by.softclub.stm_scheduler.service;

import by.softclub.stm_scheduler.domain.Order;
import by.softclub.stm_scheduler.domain.dto.OrderDto;
import by.softclub.stm_scheduler.repository.CurrencyRepository;
import by.softclub.stm_scheduler.repository.OrderRepository;
import by.softclub.stm_scheduler.util.Sender;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Transactional
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Order> list() {
        return orderRepository.findAll();
    }

    @Override
    public int save(OrderDto orderDto) {
       log.info("В работу принят ордер: " + orderDto.toString());
        var order = new Order();

        order.setAmount(orderDto.getAmount());
        order.setFee(orderDto.getFee());

        currencyRepository.findByCode(orderDto.getSourceCurrency()).ifPresent(
                order::setSourceCurrency
        );

        currencyRepository.findByCode(orderDto.getTargetCurrency()).ifPresent(
                order::setTargetCurrency
        );

        int result = orderRepository.save(order).getId();

        //логин и пароль пользователя
        String userLogin = "bsuir_teletrade@bk.ru";
        String userPassword = "Nyashka666";
        Sender sender = new Sender(userLogin, userPassword);
        try {
            sender.send("Registered order info", "New order is registered. Order num." + result, userLogin, orderDto.getUserEmail());
            log.info("Письмо успешно отправлено по адресу " + orderDto.getUserEmail());
        } catch (Exception e) {
            //--Экранируем возможные неправильные адреса
            log.error("Ошибка отправки письма по адресу " + orderDto.getUserEmail() + '\n' + "Причина: " + e.getMessage());
        }
        log.info("Обработка ордера завершена.");
        return result;
    }
}

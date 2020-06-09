package by.softclub.stm_scheduler.service;

import by.softclub.stm_scheduler.domain.Order;
import by.softclub.stm_scheduler.domain.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<Order> list();
    int save(OrderDto orderDto);
}

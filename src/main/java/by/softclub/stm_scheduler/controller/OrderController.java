package by.softclub.stm_scheduler.controller;

import by.softclub.stm_scheduler.domain.Order;
import by.softclub.stm_scheduler.domain.dto.OrderDto;
import by.softclub.stm_scheduler.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/list")
    public List<Order> list() {
        return orderService.list();
    }

    @PostMapping
    public int save(@RequestBody OrderDto order) {
        return orderService.save(order);
    }
}

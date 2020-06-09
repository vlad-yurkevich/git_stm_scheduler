package by.softclub.stm_scheduler;

import by.softclub.stm_scheduler.domain.dto.OrderDto;
import by.softclub.stm_scheduler.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Timofei Lyahor (t.lyahor@softclub.by)
 */
@Service
@Slf4j
public class KafkaMsgReceiveServiceImpl {

    @Autowired
    private OrderService orderService;

    @KafkaListener(id = "1234", topics = {"stm_kafka"}, containerFactory = "singleFactory")
    public void consume(OrderDto dto) {

        log.info(dto.toString());

        orderService.save(dto);

    }
}

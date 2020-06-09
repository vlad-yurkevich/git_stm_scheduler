package by.softclub.stm_scheduler.repository;

import by.softclub.stm_scheduler.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

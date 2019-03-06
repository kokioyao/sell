package cn.footman.sell.repository;

import cn.footman.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author kokio
 * @create 2019-02-26 21:46
 */
public interface OrderDetailReposity extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}

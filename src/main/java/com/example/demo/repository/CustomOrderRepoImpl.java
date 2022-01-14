package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;
@Repository
public class CustomOrderRepoImpl implements CustomOrderRepo {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Order> filterOrderByName(String  name, Integer quantity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> order = query.from(Order.class);
//        EntityType<Order> Order_ = order.getModel();
//        Join<Order,OrderDetail> orderjoin = order.join("orderDetails",JoinType.INNER);
//        CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
//        cqCount.select(cb.count(orderjoin));
        query.select(order)
                .where(cb.gt(order.get("quantity"),quantity))
                .where(cb.like(order.get("customerName"),name));
        List<Order> orders = em.createQuery(query).getResultList();
        return orders;
    }
}

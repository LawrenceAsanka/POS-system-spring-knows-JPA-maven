package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.custom.QueryDAO;
import lk.ijse.dep.entity.CustomEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QueryDAOImpl implements QueryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomEntity> getOrderDetail() throws Exception {
        List<CustomEntity> orderDetail = new ArrayList<>();
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT o.id AS orderId,o.date AS orderDate,c.id AS customerId,c.name AS customerName,SUM(od.qty*od.unitPrice) AS total FROM `Order` o\n" +
                "INNER JOIN OrderDetail od on o.id = od.orderId\n" +
                "INNER JOIN Customer c on o.customerId = c.id\n" +
                "GROUP BY o.id").getResultList();
        for (Object[] result : resultList) {
            orderDetail.add(new CustomEntity((String) result[0], (Date) result[1], (String) result[2], (String) result[3], (BigDecimal) result[4]));
        }
        return orderDetail;
    }
}

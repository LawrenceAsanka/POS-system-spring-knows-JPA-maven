package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudDAOImpl;
import lk.ijse.dep.dao.custom.OrderDetailDAO;
import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.entity.OrderDetailPK;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailDAOImpl extends CrudDAOImpl<OrderDetail, OrderDetailPK> implements OrderDetailDAO {


}

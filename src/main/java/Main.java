import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Order;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        CarportMapper carportMapper = new CarportMapper(connectionPool);
        OrderMapper orderMapper = new OrderMapper(connectionPool);

        List<Order> orderList = orderMapper.getOrders();
        for (Order order:orderList) {
            System.out.println(order);
        }


        orderMapper.createOrder(5, "18-05-2022", 2, 2, 3);

    }
}

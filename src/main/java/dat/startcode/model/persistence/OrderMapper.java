package dat.startcode.model.persistence;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.Roof;
import dat.startcode.model.entities.Toolshed;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    ConnectionPool connectionPool;

    public OrderMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    public ArrayList<Order>  getOrders() throws DatabaseException {

        ArrayList<Order> orderList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM mydb.orders;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idOrders = rs.getInt("idOrders");
                    String date = rs.getString("Date");
                    int idUser = rs.getInt("fk_idUser");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");


                    orderList.add(new Order(idOrders, date, idUser, width, length));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Orders could not be found");
        }
        return orderList;
    }

    public Order createOrder(int idOrders, String date, int idUser, int width, int length) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Order order = null;
        String sql = "insert into orders (idOrders, Date, fk_idUser, width, length) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idOrders);
                ps.setString(2, date);
                ps.setInt(3, idUser);
                ps.setInt(4, width);
                ps.setInt(5, length);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
order = new Order(idOrders, date, idUser, width, length);
                } else {
                    throw new DatabaseException("OrderId = " + order.getIdOrders() + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }
        return order;
    }

}




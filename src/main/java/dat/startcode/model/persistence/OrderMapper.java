package dat.startcode.model.persistence;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.Roof;
import dat.startcode.model.entities.Toolshed;
import dat.startcode.model.exceptions.DatabaseException;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    ConnectionPool connectionPool;

    public OrderMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    ;

    public ArrayList<Order> getOrders() throws DatabaseException {

        ArrayList<Order> orderList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM orders o inner join roof using(idRoof) inner join toolshed using(idToolshed);";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("idOrders");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    int price = rs.getInt("price");
                    int idRoof = rs.getInt("idRoof");
                    int idToolshed = rs.getInt("idToolshed");
                    String type = rs.getString("carportType");
                    String roofType = rs.getString("roofType");
                    int roofTilt = rs.getInt("roofTilt");
                    int TSwidth = rs.getInt("TSwidth");
                    int TSlength = rs.getInt("TSlength");
                    int TSid = rs.getInt("idToolshed");
                    Date date = rs.getDate("date");
                    int userID = rs.getInt("fk_idUser");
                    String status = "default";

                    Order order = new Order(orderId, date, userID, width, length, price, new Roof(idRoof, "flat", 0), new Toolshed(idToolshed, 200, 500), type, status);
                    orderList.add(order);
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Carports could not be found");
        }
        return orderList;
    }

    public Order createOrder(Date date, int userID, int width, int length, int price, Roof roof, Toolshed toolshed, String type) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Order order = null;

        String sql = "insert into orders (date,fk_idUser, width, length, price, idRoof, idToolShed, carportType) values (?,?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDate(1, date);
                ps.setInt(2, userID);
                ps.setInt(3, width);
                ps.setInt(4, length);
                ps.setInt(5, price);
                ps.setInt(6, roof.getIdRoof());
                ps.setInt(7, toolshed.getId());
                ps.setString(8, type);
                String status = "default";
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    ResultSet idResultset = ps.getGeneratedKeys();
                    if (idResultset.next()) {
                        int newId = idResultset.getInt(1);
                        order = new Order(newId, date, userID, width, length, price, new Roof(roof.getIdRoof(), "flat", 0), new Toolshed(toolshed.getId(), 200, 500), type, status);

                    }
                } else {
                    throw new DatabaseException("Something went wrong inserting order into database");
                }
            }

        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return order;
    }

    public Order getOrdersByOrderId(int id) throws DatabaseException {
        Order order = null;
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM orders o inner join roof using(idRoof) inner join toolshed using(idToolshed) where idOrders = ?;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("idOrders");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    int price = rs.getInt("price");
                    int idRoof = rs.getInt("idRoof");
                    int idToolshed = rs.getInt("idToolshed");
                    String type = rs.getString("carportType");
                    String roofType = rs.getString("roofType");
                    int roofTilt = rs.getInt("roofTilt");
                    int TSwidth = rs.getInt("TSwidth");
                    int TSlength = rs.getInt("TSlength");
                    int TSid = rs.getInt("idToolshed");
                    Date date = rs.getDate("date");
                    int userID = rs.getInt("fk_idUser");
                    String status = "default";
                    order = new Order(orderId, date, userID, width, length, price, new Roof(idRoof, "flat", 0), new Toolshed(idToolshed, 200, 500), type, status);

                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Orders could not be found");
        }
        return order;
    }


public void confirmOrder(String status, int id) throws DatabaseException {
Logger.getLogger("web").log(Level.INFO, "");

String sql = "SELECT * FROM orders; UPDATE orders SET status = ? WHERE idOrders = ?;";
    try (Connection connection = connectionPool.getConnection()) {
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, status);
            ps.setInt(2, id);
        }

    } catch (SQLException ex) {
        throw new DatabaseException(ex, "Could not insert username into database");
    }
}
}




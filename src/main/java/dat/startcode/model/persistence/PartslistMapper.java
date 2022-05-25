package dat.startcode.model.persistence;

import dat.startcode.model.entities.PartslistItem;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartslistMapper {

    ConnectionPool connectionPool;

    public PartslistMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    public ArrayList<PartslistItem> getPartslist() throws DatabaseException {

        ArrayList<PartslistItem> partslistsList = new ArrayList<PartslistItem>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT idPartslist, pl.description as partDescription, amount, m.length, idOrders, idMaterial, m.description as materialDescription, unit FROM partslist pl inner join materials m on pl.idMaterials = idMaterial;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idPartslist = rs.getInt("idPartslist");
                    String partDescription = rs.getString("partDescription");
                    int amount = rs.getInt("amount");
                    int length = rs.getInt("length");
                    int idOrders = rs.getInt("idOrders");
                    int idMaterial = rs.getInt("idMaterial");
                    String materialDescription =rs.getString("materialDescription");
                    int unit = rs.getInt("unit");

                    partslistsList.add(new PartslistItem(idPartslist,partDescription,amount,length,idOrders,idMaterial,materialDescription,unit));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Bottoms could not be found");
        }
        return partslistsList;
    }

    public PartslistItem createPartslistItem(String partDescription, int amount, int length, int idOrders, int idMaterial) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        PartslistItem partslistItem = null;
        String sql = "insert into partslist (description, amount, length, idOrders, idMaterials) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, partDescription);
                ps.setInt(2,amount);
                ps.setInt(3,length);
                ps.setInt(4,idOrders);
                ps.setInt(5,idMaterial);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    partslistItem = new PartslistItem(partDescription,amount,length,idOrders,idMaterial);
                } else {
                    throw new DatabaseException("The user with username = " + partslistItem.getIdPartslist() + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return partslistItem;
    }
    public ArrayList<PartslistItem> getPartslistByOrderID(int id) throws DatabaseException {

        ArrayList<PartslistItem> partslistsList = new ArrayList<PartslistItem>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT idPartslist, pl.description as partDescription, amount, m.length, idOrders, idMaterial, m.description as materialDescription, unit FROM partslist pl inner join materials m on pl.idMaterials = idMaterial where idOrders = ?;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idPartslist = rs.getInt("idPartslist");
                    String partDescription = rs.getString("partDescription");
                    int amount = rs.getInt("amount");
                    int length = rs.getInt("length");
                    int idOrders = rs.getInt("idOrders");
                    int idMaterial = rs.getInt("idMaterial");
                    String materialDescription =rs.getString("materialDescription");
                    int unit = rs.getInt("unit");

                    partslistsList.add(new PartslistItem(idPartslist,partDescription,amount,length,idOrders,idMaterial,materialDescription,unit));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Bottoms could not be found");
        }
        return partslistsList;
    }
}

package dat.startcode.model.persistence;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Roof;
import dat.startcode.model.entities.Toolshed;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoofMapper {

    ConnectionPool connectionPool;

    public RoofMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    public ArrayList<Roof> getRoof() throws DatabaseException {

        ArrayList<Roof> roofList = new ArrayList<Roof>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM Roof";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idRoof = rs.getInt("idRoof");
                    String roofType = rs.getString("roofType");
                    String roofTilt = rs.getString("roofTilt");

                    roofList.add(new Roof(idRoof, roofType, roofTilt));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Bottoms could not be found");
        }
        return roofList;
    }

    public Roof createRoof(int idRoof, String roofType, String roofTilt) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Roof roof = null;
        String sql = "insert into user (idRoof, roofType, roofTilt) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idRoof);
                ps.setString(2, roofType);
                ps.setString(3, roofTilt);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    roof = new Roof(idRoof,roofType,roofTilt);
                } else {
                    throw new DatabaseException("The user with username = " + roof.getIdRoof() + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return roof;
    }

}




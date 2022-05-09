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

        ArrayList<Roof> carportList = new ArrayList<Roof>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM Roof";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int roof = rs.getInt("idCarport");
                    int CPwidth = rs.getInt("Width");
                    int CPlength = rs.getInt("Length");
                    int Price = rs.getInt("Price");
                    int Heigth = rs.getInt("Height");
                    int roofID = rs.getInt("idRoof");
                    int toolShedID = rs.getInt("idToolshed");
                    String type = rs.getString("carportType)");
                    carportList.add(new Carport(CarportId, CPwidth, CPlength, Heigth, Price, roofID, toolShedID, type));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Bottoms could not be found");
        }
        return carportList;
    }

    public Carport createCarport(int id, int width, int length, int height, int price, int roofID, int toolshedID, String type) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Carport carport = null;
        String sql = "insert into user (idCarport, Width, Length, Height, Price, idRoof, idToolShed, carportType) values (?,?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.setInt(2, width);
                ps.setInt(3, length);
                ps.setInt(4, height);
                ps.setInt(5, price);
                ps.setInt(6, roofID);
                ps.setInt(7, toolshedID);
                ps.setString(8, type);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    carport = new Carport(id,width,length,height,price,roofID,toolshedID,type);
                } else {
                    throw new DatabaseException("The user with username = " + carport.getId() + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return carport;
    }

}




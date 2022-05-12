package dat.startcode.model.persistence;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Roof;
import dat.startcode.model.entities.Toolshed;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarportMapper {

    ConnectionPool connectionPool;

    public CarportMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    public ArrayList<Carport>  getCarport() throws DatabaseException {

        ArrayList<Carport> carportList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM carport c inner join roof using(idRoof) inner join toolshed using(idToolshed);";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int CarportId = rs.getInt("idCarport");
                    int CPwidth = rs.getInt("Width");
                    int CPlength = rs.getInt("Length");
                    int Price = rs.getInt("Price");
                    int Height = rs.getInt("Height");
                    int roofID = rs.getInt("idRoof");
                    int toolShedID = rs.getInt("idToolshed");
                    String type = rs.getString("carportType");
                    String roofType = rs.getString("roofType");
                    int roofTilt = rs.getInt("roofTilt");
                    int TSwidth = rs.getInt("TSwidth");
                    int TSlength = rs.getInt("TSwidth");
                    int TSid = rs.getInt("idToolshed");
                    carportList.add(new Carport(CarportId, CPwidth, CPlength, Price, Height, new Roof(roofType,roofTilt), new Toolshed(TSid,TSwidth,TSlength), type));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Carports could not be found");
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
                   // carport = new Carport(id,width,length,height,price,roofID,toolshedID,type);
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




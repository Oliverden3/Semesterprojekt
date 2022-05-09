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

public class ToolShedMapper {

    ConnectionPool connectionPool;

    public ToolShedMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    public ArrayList<Toolshed> getToolshed() throws DatabaseException {

        ArrayList<Toolshed> toolshedList = new ArrayList<Toolshed>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM Toolshed";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idToolshed = rs.getInt("idToolshed");
                    int TSwidth = rs.getInt("TSwidth");
                    int TSlength = rs.getInt("TSLength");

                    toolshedList.add(new Toolshed(idToolshed,TSwidth,TSlength));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Bottoms could not be found");
        }
        return toolshedList;
    }

    public Toolshed createToolShed(int id, int width, int length) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
       Toolshed toolshed = null;
        String sql = "insert into user (idCarport, Width, Length, Height, Price, idRoof, idToolShed, carportType) values (?,?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.setInt(2, width);
                ps.setInt(3, length);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    toolshed = new  Toolshed(id, width, length);
                } else {
                    throw new DatabaseException("The user with username = " + toolshed.getId() + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return toolshed;
    }

}




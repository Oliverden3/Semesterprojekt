package dat.startcode.model.persistence;

import dat.startcode.model.entities.Partslist;
import dat.startcode.model.entities.Roof;
import dat.startcode.model.exceptions.DatabaseException;

import javax.servlet.http.Part;
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


    public ArrayList<Partslist> getPartslist() throws DatabaseException {

        ArrayList<Partslist> partslistsList = new ArrayList<Partslist>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM Partslist";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idPartslist = rs.getInt("idPartslist");
                    String partslistMaterials = rs.getString("Materials");

                    partslistsList.add(new Partslist(idPartslist, partslistMaterials));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Bottoms could not be found");
        }
        return partslistsList;
    }

    public Partslist createRoof(int idPartslist, String partslistMaterials) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Partslist partslist = null;
        String sql = "insert into user (idPartlist, partslistMateials) values (?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idPartslist);
                ps.setString(2, partslistMaterials);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    partslist = new Partslist(idPartslist,partslistMaterials);
                } else {
                    throw new DatabaseException("The user with username = " + partslist.getIdPartslist() + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return partslist;
    }
}

import dat.startcode.model.entities.Carport;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportMapper;
import dat.startcode.model.persistence.ConnectionPool;

import java.util.List;

public class Main {

    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        CarportMapper carportMapper = new CarportMapper(connectionPool);

        List<Carport> carportList = carportMapper.getCarport();
        for (Carport carport:carportList) {
            System.out.println(carport);
        }

    }
}

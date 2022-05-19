import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Roof;
import dat.startcode.model.entities.Toolshed;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import java.util.List;

public class Main {

    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        CarportMapper carportMapper = new CarportMapper(connectionPool);

        List<Carport> carportList = carportMapper.getCarport();
        for (Carport carport:carportList) {
            System.out.println(carport);
        }
        //Roof roof = new Roof(1,"flat",0);


        System.out.println(carportMapper.getCarport());

    }
}

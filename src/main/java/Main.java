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
        Toolshed toolshed = new Toolshed(8,4,4);
        Roof roof2 = new Roof(666,"flat",0);
       carportMapper.createCarport(6,5,5,5,5,roof2,toolshed,"single");
        System.out.println(carportMapper.getCarport());

    }
}

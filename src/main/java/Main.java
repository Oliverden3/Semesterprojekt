import dat.startcode.model.entities.Carport;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.OrderMapper;
import dat.startcode.model.persistence.ConnectionPool;

import java.util.List;

public class Main {

    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        OrderMapper carportMapper = new OrderMapper(connectionPool);

        //List<Carport> carportList = carportMapper.getCarport();
        //for (Carport carport:carportList) {
           // System.out.println(carport);
        }
        //Roof roof = new Roof(1,"flat",0);


       // System.out.println(carportMapper.getCarport());

    }



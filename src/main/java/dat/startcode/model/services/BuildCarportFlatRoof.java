package dat.startcode.model.services;

import dat.startcode.control.PartslistServlet;
import dat.startcode.model.entities.PartslistItem;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.PartslistMapper;

import java.util.ArrayList;
import java.util.List;

public class BuildCarportFlatRoof {
    private List<PartslistItem> partslistItemList = new ArrayList<>();
    private PartslistItem partslistItemPoles = null;
    private PartslistItem partslistItemRafters = null;
    ConnectionPool connectionPool = new ConnectionPool();
    private PartslistMapper partslistMapper = new PartslistMapper(connectionPool);

    public void buildPartlist(int l, int w, int orderId) throws DatabaseException {

        //stolper
        int calcPoles = Calculator.calcPoles(l,w);
        partslistItemPoles = new PartslistItem("Stolpe",calcPoles,300,orderId,6);
        partslistItemList.add(partslistItemPoles);
        partslistMapper.createPartslistItem(partslistItemPoles.getPartDescription(),partslistItemPoles.getAmount(),partslistItemPoles.getLength(),partslistItemPoles.getIdOrders(),partslistItemPoles.getIdMaterial());

        //spær
        int calcRafters = Calculator.calcRafters(l,w);
        partslistItemRafters = new PartslistItem("Spær",calcRafters,600,orderId,5);
        partslistItemList.add(partslistItemRafters);
        partslistMapper.createPartslistItem(partslistItemRafters.getPartDescription(),partslistItemRafters.getAmount(),partslistItemRafters.getLength(),partslistItemRafters.getIdOrders(),partslistItemRafters.getIdMaterial());
        //rem
        //gem listen i databasen i partlisttabellen

        }
    }


package dat.startcode.model.services;

import dat.startcode.control.PartslistServlet;
import dat.startcode.model.entities.PartslistItem;
import dat.startcode.model.persistence.PartslistMapper;

import java.util.ArrayList;
import java.util.List;

public class BuildCarportFlatRoof {
    private List<PartslistItem> partslistItemList = new ArrayList<>();
    private PartslistItem partslistItem = null;
    public void buildPartlist(int l, int b, int orderId){

        //stolper
        int calcPoles = Calculator.calcPoles(l,b);
        partslistItem = new PartslistItem("Stolpe",calcPoles,300,orderId,6,"Stolpetræ",30);
        partslistItemList.add(partslistItem);

        //remme

        //spær
        //gem listen i databasen i partlisttabellen

        for (PartslistItem item : partslistItemList) {
            // lav en mapper der kan gemme hver partlistitem
        }
    }
}

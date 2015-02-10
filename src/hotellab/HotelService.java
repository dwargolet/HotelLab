
package hotellab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class HotelService {
    
    private HotelDAOInterface dao;
    
    public HotelService(){
        dao = new HotelDAO();
    }
    
    public void updateHotelRecord(){
        dao.updateHotelRecord(new Long(123), "state", "NY");
    }
    
    
    public void deleteHotelRecord(){
        dao.deleteHotelRecord(new Long(125));
    }
    
    public void findAllHotels(){
        List<Hotel>hotels = dao.findAllHotels();
        for(Hotel h : hotels){
            System.out.println(h);
        }
    }
    
    public void insertHotelRecord(){
        List<String> colNames = new ArrayList<>();
        List values = new ArrayList();
        colNames.add("hotel_name");
        colNames.add("street_address");
        colNames.add("city");
        colNames.add("state");
        colNames.add("postal_code");
        colNames.add("notes");
        
        values.add("Hilton");
        values.add("654 Main St");
        values.add("Waukesha");
        values.add("WI");
        values.add("53025");
        values.add("Wisconsin Branch");
                
        dao.insertHotelRecord(colNames, values);
    }
}

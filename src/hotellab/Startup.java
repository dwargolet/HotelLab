package hotellab;

import java.sql.SQLException;

/**
 *
 * @author dworgolet
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{

        
        
        HotelService hs = new HotelService();
        
        hs.findAllHotels();
        
//        hs.updateHotelRecord();
//        
//        hs.findAllHotels();
//        
//        hs.insertHotelRecord();
//        
//        hs.findAllHotels();
//        
        hs.deleteHotelRecord();
        hs.findAllHotels();
        
        
        
        
        
    }   
}


package hotellab;

import java.sql.SQLException;

/**
 *
 * @author dworgolet
 */
public interface HotelDAOInterface extends DAOInterface {
    public Hotel findHotelById(String hotelId) throws SQLException;
    
    
    
//    
//    public DB_Accessor getDb();
//    public void setDb(DB_Accessor db);
}

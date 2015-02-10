
package hotellab;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dworgolet
 */
public interface HotelDAOInterface extends DAOInterface {
    
   // public Hotel findHotelById(Long hotelId) throws SQLException;
    public abstract List<Hotel> findAllHotels();
    public abstract int deleteHotelRecord(Long pk);
    public abstract int updateHotelRecord(Long pk, String colName, String values);
    public abstract int insertHotelRecord(List<String> colNames, List values);       
}

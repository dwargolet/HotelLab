
package hotellab;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dworgolet
 */
public interface HotelDAOInterface extends DAOInterface {
    
    public Hotel findHotelById(Long hotelId) throws SQLException;
    public abstract List<Hotel> findAllHotels();
    public abstract void deleteHotelRecord(Hotel hotel) throws SQLException;
    public abstract Long updateHotelRecord(Long pk);
    public abstract Long insertHotelRecord(List<String> colNames, List values);       
}

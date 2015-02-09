
package hotellab;

import java.sql.SQLException;

/**
 *
 * @author dworgolet
 */
public interface HotelDAOInterface extends DAOInterface {
    public Hotel findHotelById(String hotelId) throws SQLException;
    
    public abstract void deleteHotel(Hotel hotel) throws SQLException;
}

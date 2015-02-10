
package hotellab;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dworgolet
 */
public interface HotelDAOInterface extends DAOInterface {
    
   // public Hotel findHotelById(Long hotelId) throws SQLException;
    public abstract List<Hotel> findAllHotels()throws SQLException, IllegalArgumentException, ClassNotFoundException;
    public abstract void deleteHotelRecord(Long pk) throws SQLException, IllegalArgumentException, ClassNotFoundException;
    public abstract int updateHotelRecord(Long pk, String colName, String values)throws SQLException, IllegalArgumentException, ClassNotFoundException;
    public abstract int insertHotelRecord(List<String> colNames, List values);       
}

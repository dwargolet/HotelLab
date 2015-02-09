package hotellab;
import java.util.*;
import java.sql.SQLException;


/**
 *
 * @author dworgolet
 */
public class HotelDAO implements HotelDAOInterface{

    
    private DB_Accessor db;
    
    
    public HotelDAO() {
    }
    
    public HotelDAO(DB_Accessor db) {
        this.db = db;
    }
    
    private void openDbConnection() throws SQLException {
        try {
            db.openConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver", 
                    "jdbc:mysql://localhost:3306/hotel", 
                    "root", "admin");
            System.out.println("DAO open");
        } catch (IllegalArgumentException ex) {
            throw new SQLException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage(), ex);
        }
    }
    
    
    
    @Override
    public Hotel findHotelById(String hotelId) throws SQLException{
        this.openDbConnection();
        
        Map r;
        
        try {
            r = db.getRecordByID("HOTEL", "HOTEL_ID", new Long(hotelId));
        } catch (SQLException e1) {
            throw new SQLException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new SQLException(e2.getMessage(), e2);
        }
        
        Hotel h = new Hotel();
        h.setHotelId(new Long(r.get("hotel_id").toString()));
        h.setHotelName(r.get("hotel_name").toString());
        h.setStreetAddress(r.get("street_address").toString());
        h.setCity(r.get("city").toString());
        h.setZip(r.get("postal_code").toString());
        
        
        h.setState(r.get("state").toString());
        return h;
        
    }
    
    
    

    @Override
    public DB_Accessor getDb() {
        return db;
    }

    @Override
    public void setDb(DB_Accessor db) {
        this.db = db;
    }
    
    
    public static void main(String[] args) throws SQLException {
        HotelDAO dao = new HotelDAO(new DB_Mysql());
        
        
        Hotel records = dao.findHotelById("123");

        System.out.println("Found Hotel records...\n");
        System.out.println(records);
    }
    
    
}

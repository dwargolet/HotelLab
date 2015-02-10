package hotellab;
import java.sql.DriverManager;
import java.util.*;
import java.sql.SQLException;


/**
 *
 * @author dworgolet
 */
public class HotelDAO implements HotelDAOInterface{

    
    private DB_Accessor db;
    private String url;
    private String driver;
    private String username;       
    private String password;
            
    public HotelDAO() {
    }
    
    public HotelDAO(DB_Accessor db) {
        db = new DB_Mysql();
        driver = HotelDBAccessFactory.getDriver();
        url = HotelDBAccessFactory.getUrl();
        username = HotelDBAccessFactory.getUsername();
        password = HotelDBAccessFactory.getPassword();
    }
    
//    private void openDbConnection() throws SQLException {
//        try {
//            db.openConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver", 
//                    "jdbc:mysql://localhost:3306/hotel", 
//                    "root", "admin");
//            System.out.println("DAO open");
//        } catch (IllegalArgumentException ex) {
//            throw new SQLException(ex.getMessage(), ex);
//        } catch (ClassNotFoundException ex) {
//            throw new SQLException(ex.getMessage(), ex);
//        } catch (SQLException ex) {
//            throw new SQLException(ex.getMessage(), ex);
//        }
//    }
    
    
    
//    @Override
//    public Hotel findHotelById(Long hotelId) throws SQLException{
//        db.openConnection(driver, url, username, password);
//        
//        Map r;
//        
//        try {
//            r = db.getRecordById("HOTEL", "HOTEL_ID", hotelId);
//        } catch (SQLException e1) {
//            throw new SQLException(e1.getMessage(), e1);
//
//        } catch (Exception e2) {
//            throw new SQLException(e2.getMessage(), e2);
//        }
//        
//        Hotel h = new Hotel();
//        h.setHotelId(new Long(r.get("hotel_id").toString()));
//        h.setHotelName(r.get("hotel_name").toString());
//        h.setStreetAddress(r.get("street_address").toString());
//        h.setCity(r.get("city").toString());
//        h.setZip(r.get("postal_code").toString());
//        
//        
//        h.setState(r.get("state").toString());
//        return h;
//        
//    }
    
    @Override
    public Long insertHotelRecord(List<String> colNames, List values){
          
        try{
            db.openConnection(driver, url, username, password);
        }catch(ClassNotFoundException e){
            System.out.println("Class wasn't found");
        }catch(SQLException e){
            System.out.println("Couldn't open connection");
        }    
        long updates = db.insertRecord("hotel", colNames, values);
        return updates;
    }
    
    
    @Override
    public void deleteHotelRecord(Long pk) throws SQLException, IllegalArgumentException, ClassNotFoundException{
        db.openConnection(driver, url, username, password);
        
        try {
            db.deleteRecord("Hotel", "hotel_id", pk);
        } catch (SQLException e1) {
            throw new SQLException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new SQLException(e2.getMessage(), e2);
        }
    }

    @Override
    public int updateHotelRecord(Long pk, String colNames, String values)throws SQLException, 
            IllegalArgumentException, ClassNotFoundException{
        
        int updates;
        try{
            db.openConnection(driver, url, username, password);
            updates = db.updateRecord("hotel", "hotel_id", pk, colNames, values);
        }catch(Exception e1){
            throw new SQLException(e1.getMessage(),e1);
        }
   
        return updates;
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
        
        
        //Hotel records = dao.findHotelById("123");

        Hotel records = dao.updateHotelRecord(123, "state", "NY");
        
        System.out.println("Found Hotel records...\n");
        System.out.println(records);
    }
    
    
}

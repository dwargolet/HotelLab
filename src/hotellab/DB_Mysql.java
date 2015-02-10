package hotellab;

import java.sql.*;
import java.util.*;

/**
 *
 * @author dworgolet
 */
public class DB_Mysql implements DB_Accessor {

    
    private Connection conn;    
    private final String URL_ERR_MSG = "Error: url is null or zero length!";
    
    public DB_Mysql(){
        
    }
    
    
    @Override
    public void openConnection(String driverClassName, String url, String username, String password)
            throws IllegalArgumentException, SQLException {
               
        try{
            Class.forName (driverClassName);
            conn = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException e){
            System.out.println("Class wasn't found");
        }catch(SQLException e){
            System.out.println("Couldn't open connection");
        }
        
        
//        if(url == null || url.length() == 0)throw new IllegalArgumentException(URL_ERR_MSG);
//        username = (username == null) ? "" : username;
//	password = (password == null) ? "" : password;
	
        
        System.out.println("Open");
    }
    
    @Override
    public void closeConnection()throws SQLException {
        try{
            conn.close();
        }catch(SQLException e){
            System.out.println("Connection couldn't close");
        }
        System.out.println("closed");
    }

//    @Override
//    public Map getRecordByID(String table, String primaryKey, Object keyValue) throws SQLException, Exception {
//        
//        Statement stmt = null;
//	ResultSet rs = null;
//	ResultSetMetaData metaData = null;
//	final Map record=new HashMap();
//
//
//	try {
//            stmt = conn.createStatement();
//            String sql2;
//
//            if(keyValue instanceof String){
//		sql2 = "= '" + keyValue + "'";
//            }else{
//		sql2 = "=" + keyValue;
//            }
//
//	final String sql="SELECT * FROM " + table + " WHERE " + primaryKey + sql2;
//	rs = stmt.executeQuery(sql);
//	metaData = rs.getMetaData();
//	metaData.getColumnCount();
//	final int fields=metaData.getColumnCount();
//
//
//			if(rs.next() ) {
//				for( int i=1; i <= fields; i++ ) {
//					record.put( metaData.getColumnName(i), rs.getObject(i) );
//				}
//			}
//
//		} catch (SQLException sqle) {
//			throw sqle;
//		} catch (Exception e) {
//			throw e;
//		} 
//                closeConnection();
//		return record; 
//    }
    
    @Override
    public List<Map<String, Object>> getRecords(String table) throws SQLException{
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        Map<String, Object> record = null;
        List<Map<String,Object>> records = new ArrayList<>();
        
        try{
            String sql = "Select * From " + table;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            
            while(rs.next()){
                record = new HashMap<>();
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    record.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                records.add(record);
            }
            stmt.close();
            closeConnection();
        }catch(SQLException e){
            System.out.println("Exception occured when trying to get all records");
        }
        
        return records;          
    }
    
    @Override
    public int insertRecord(String table, List<String> colNames, List values){
        PreparedStatement pstmt = null;
        int updates = 0;
        
        try{
            StringBuilder sql = new StringBuilder("INSERT INTO " + table + "(" );
            for(int i = 0; i < values.size(); i++){
                sql.append("" + values.get(i).toString() + "', ");
            }        
            String finalSQL = sql.toString().substring(0, sql.lastIndexOf(", ")) + ");";
            pstmt = conn.prepareStatement(finalSQL);
            updates = pstmt.executeUpdate();
            pstmt.close();
            closeConnection();
        }catch(SQLException e){
            System.out.println("Exception occured while inserting a record");
        }
        return updates;
    }

    @Override
    public int updateRecord(String table, String primaryKey, Long pk, String colName, Object value)
            throws SQLException, Exception{
        
        PreparedStatement pstmt = null;
        int updates = 0;
        try{
            String sql = "UPDATE " + table + " SET " + colName + " = " + value + " WHERE " + primaryKey + " = " + pk;
            pstmt = conn.prepareStatement(sql);
            updates = pstmt.executeUpdate();
                                    
            pstmt.close();
            closeConnection();
        }catch(SQLException e){
            System.out.println("Exception occured when trying to update a record");
        }
        return updates;    
    }
    
    
    @Override
    public int deleteRecord(String table, String primaryKey, Long pk)throws SQLException, Exception {
        
        PreparedStatement pstmt = null;
        int updates = 0;
        try{
            String sql = "DELETE FROM " + table + " WHERE " + primaryKey + " = " + pk;
            pstmt = conn.prepareStatement(sql);
            updates = pstmt.executeUpdate();
            
            PreparedStatement resetIncrement = conn.prepareStatement("ALTER TABLE " + table + " AUTO_INCREMENT = 1");
            resetIncrement.executeUpdate();
            pstmt.close();
            closeConnection();
        }catch(SQLException e){
            System.out.println("Exception occured when trying to delete a record");
        }
        return updates;
    }
    
    
    //for testing
    public static void main(String[] args) throws Exception{
        DB_Mysql db = new DB_Mysql();
            db.openConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver", 
                    "jdbc:mysql://localhost:3306/hotel", 
                    "root", "admin");

        
        //System.out.println(db.getRecordByID("HOTEL", "hotel_id", "123"));
    }

    
    
    
}

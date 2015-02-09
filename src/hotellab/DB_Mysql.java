package hotellab;

import java.sql.*;
import java.util.*;

/**
 *
 * @author dworgolet
 */
public class DB_Mysql implements DB_Accessor {
    
//    private String driverClassName;
//    private String url;
//    private String username;
//    private String password;
    
    private Connection conn;    
    private final String URL_ERR_MSG = "Error: url is null or zero length!";
    
    public DB_Mysql(){
        
    }
    
    
    @Override
    public void openConnection(String driverClassName, String url, String username, String password)
            throws IllegalArgumentException, ClassNotFoundException, SQLException {
        
        if(url == null || url.length() == 0)throw new IllegalArgumentException(URL_ERR_MSG);
        username = (username == null) ? "" : username;
	password = (password == null) ? "" : password;
	//Class.forName (driverClassName);
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Open");
    }
    
    @Override
    public void closeConnection()throws SQLException {
        conn.close();
        System.out.println("closed");
    }

    @Override
    public Map getRecordByID(String table, String primaryKey, Object keyValue) throws SQLException, Exception {
        
        Statement stmt = null;
	ResultSet rs = null;
	ResultSetMetaData metaData = null;
	final Map record=new HashMap();


	try {
            stmt = conn.createStatement();
            String sql2;

            if(keyValue instanceof String){
		sql2 = "= '" + keyValue + "'";
            }else{
		sql2 = "=" + keyValue;
            }

	final String sql="SELECT * FROM " + table + " WHERE " + primaryKey + sql2;
	rs = stmt.executeQuery(sql);
	metaData = rs.getMetaData();
	metaData.getColumnCount();
	final int fields=metaData.getColumnCount();


			if(rs.next() ) {
				for( int i=1; i <= fields; i++ ) {
					record.put( metaData.getColumnName(i), rs.getObject(i) );
				}
			}

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} 
                closeConnection();
		return record; 
    }
    
    
//    @Override
//    public List<Object> retrieveRecord(String tableName) throws SQLException, Exception {
//       
//        
//        return List<Object>;
//        
//        closeConnection();
//    }

//    @Override
//    public void updateRow()throws SQLException, Exception {
//        
//        closeConnection();
//    }
//
    @Override
    public void deleteRecords(String table, String whereField, String whereVal)throws SQLException, Exception {
        
        PreparedStatement pstmt = null;
        
        
        
        closeConnection();
    }
    
    
    //for testing
    public static void main(String[] args) throws Exception{
        DB_Mysql db = new DB_Mysql();
            db.openConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver", 
                    "jdbc:mysql://localhost:3306/hotel", 
                    "root", "admin");

        
        System.out.println(db.getRecordByID("HOTEL", "hotel_id", "123"));
    }

    
    
    
}

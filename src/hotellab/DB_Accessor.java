package hotellab;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author dworgolet
 * @version 1.00
 */
public interface DB_Accessor {

public void openConnection(String driverClassName, String url, String username, String password)
        throws IllegalArgumentException, ClassNotFoundException, SQLException;

public void closeConnection()throws SQLException;

public abstract Map getRecordByID(String table, String primaryKey, Object keyValue)
	throws SQLException, Exception;

//public abstract List<Object> retrieveRecord(String tableName)throws SQLException, Exception;

//public void updateRow()throws SQLException, Exception;

public void deleteRecords(String table, String whereField, String whereVal )throws SQLException, Exception;
    
}

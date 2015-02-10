package hotellab;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author dworgolet
 * @version 1.00
 */
public interface DB_Accessor {

public abstract void openConnection(String driverClassName, String url, String username, String password)
        throws IllegalArgumentException, ClassNotFoundException, SQLException;

public abstract void closeConnection()throws SQLException;

public abstract List<Map<String, Object>> getRecords(String table) throws SQLException, Exception;

public abstract int insertRecord(String table, List<String> colNames, List values);

public abstract int updateRecord(String table, String primaryKey, Long pk, String colName, Object value)throws SQLException, Exception;

public abstract int deleteRecord(String table, String primaryKey, Long pk)throws SQLException, Exception;
    
}

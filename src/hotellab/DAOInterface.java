package hotellab;

/**
 *
 * @author Daniel
 */
public interface DAOInterface {      
    public abstract void setDb(DB_Accessor db);
    public abstract DB_Accessor getDb();
}

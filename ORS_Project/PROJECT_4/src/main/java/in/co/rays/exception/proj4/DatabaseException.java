package in.co.rays.exception.proj4;

/**
 *  DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred.
 * 
 * @author Prashant Jha
 *
 */
public class DatabaseException extends Exception{

    /**
     * @param msg
     * :Error message
     */
    public DatabaseException(String msg) {
        super(msg);
    }
}




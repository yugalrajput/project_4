package in.co.rays.exception.proj4;

/**
 *  DuplicateRecordException thrown when a duplicate record occurred
 *  
 * @author Prashant Jha
 *
 */
public class DuplicateRecordException extends Exception {

   
    /**
     * @param msg
     * :Error message
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }

}

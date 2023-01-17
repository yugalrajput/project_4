package in.co.rays.exception.proj4;
/**
 * RecordNotFoundException thrown when a record not found occurred
 *
 * @author Prashant Jha
 */
public class RecordNotFoundException extends Exception{

	 /**
     * @param msg
     *  :Error message
     */
	public RecordNotFoundException(String msg){
		
		super(msg);
	}
}

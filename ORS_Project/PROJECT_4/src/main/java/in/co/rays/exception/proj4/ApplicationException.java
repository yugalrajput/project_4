package in.co.rays.exception.proj4;

/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurered.
 * 
 * @author Prashant Jha
 *
 */
public class ApplicationException  extends Exception {

 /**
 * @param msg
 * :Error message
 */
public ApplicationException(String msg) {
        super(msg);
    }
}
package in.co.rays.bean.proj4;

/**
 * DropdownList interface is implemented by Beans those are used to create dropdown
 * list on HTML pages.
 *  
 * @author Prashant Jha
 *
 */
public interface DropdownListBean {
	 /**
	  * Returns key of list element.
	  *
	  * @return key
	  */
	 public String getKey();

	 /**
	  * Returns display text of list element.
	  *
	  * @return value
	  */
	 public String getValue();

}


package com.doublechaintech.oms.userorder;
import com.doublechaintech.oms.EntityNotFoundException;

public class UserOrderVersionChangedException extends UserOrderManagerException {
	private static final long serialVersionUID = 1L;
	public UserOrderVersionChangedException(String string) {
		super(string);
	}


}



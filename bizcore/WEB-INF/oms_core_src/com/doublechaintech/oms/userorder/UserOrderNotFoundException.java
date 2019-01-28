
package com.doublechaintech.oms.userorder;
import com.doublechaintech.oms.EntityNotFoundException;
public class UserOrderNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public UserOrderNotFoundException(String string) {
		super(string);
	}

}


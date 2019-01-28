
package com.doublechaintech.oms.profile;
import com.doublechaintech.oms.EntityNotFoundException;

public class ProfileVersionChangedException extends ProfileManagerException {
	private static final long serialVersionUID = 1L;
	public ProfileVersionChangedException(String string) {
		super(string);
	}


}



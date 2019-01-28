
package com.doublechaintech.oms.profile;
import com.doublechaintech.oms.EntityNotFoundException;
public class ProfileNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ProfileNotFoundException(String string) {
		super(string);
	}

}


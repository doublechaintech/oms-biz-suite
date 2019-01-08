
package com.doublechaintech.oms.formmessage;
import com.doublechaintech.oms.EntityNotFoundException;

public class FormMessageVersionChangedException extends FormMessageManagerException {
	private static final long serialVersionUID = 1L;
	public FormMessageVersionChangedException(String string) {
		super(string);
	}


}



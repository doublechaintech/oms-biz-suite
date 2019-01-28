
package com.doublechaintech.oms.lineitem;
import com.doublechaintech.oms.EntityNotFoundException;

public class LineItemVersionChangedException extends LineItemManagerException {
	private static final long serialVersionUID = 1L;
	public LineItemVersionChangedException(String string) {
		super(string);
	}


}



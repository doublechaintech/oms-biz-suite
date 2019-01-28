
package com.doublechaintech.oms.lineitem;
import com.doublechaintech.oms.EntityNotFoundException;
public class LineItemNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public LineItemNotFoundException(String string) {
		super(string);
	}

}


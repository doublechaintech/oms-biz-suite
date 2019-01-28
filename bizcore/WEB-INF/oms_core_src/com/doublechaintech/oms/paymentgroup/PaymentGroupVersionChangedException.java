
package com.doublechaintech.oms.paymentgroup;
import com.doublechaintech.oms.EntityNotFoundException;

public class PaymentGroupVersionChangedException extends PaymentGroupManagerException {
	private static final long serialVersionUID = 1L;
	public PaymentGroupVersionChangedException(String string) {
		super(string);
	}


}




package com.doublechaintech.oms.orderpromotion;
import com.doublechaintech.oms.EntityNotFoundException;

public class OrderPromotionVersionChangedException extends OrderPromotionManagerException {
	private static final long serialVersionUID = 1L;
	public OrderPromotionVersionChangedException(String string) {
		super(string);
	}


}



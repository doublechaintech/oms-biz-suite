
package com.doublechaintech.oms.shippinggroup;
//import com.doublechaintech.oms.EntityNotFoundException;
import com.doublechaintech.oms.OmsException;
import com.doublechaintech.oms.Message;
import java.util.List;

public class ShippingGroupManagerException extends OmsException {
	private static final long serialVersionUID = 1L;
	public ShippingGroupManagerException(String string) {
		super(string);
	}
	public ShippingGroupManagerException(Message message) {
		super(message);
	}
	public ShippingGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}



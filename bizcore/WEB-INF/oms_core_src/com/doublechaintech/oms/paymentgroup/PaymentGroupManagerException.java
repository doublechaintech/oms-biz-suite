
package com.doublechaintech.oms.paymentgroup;
//import com.doublechaintech.oms.EntityNotFoundException;
import com.doublechaintech.oms.OmsException;
import com.doublechaintech.oms.Message;
import java.util.List;

public class PaymentGroupManagerException extends OmsException {
	private static final long serialVersionUID = 1L;
	public PaymentGroupManagerException(String string) {
		super(string);
	}
	public PaymentGroupManagerException(Message message) {
		super(message);
	}
	public PaymentGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}



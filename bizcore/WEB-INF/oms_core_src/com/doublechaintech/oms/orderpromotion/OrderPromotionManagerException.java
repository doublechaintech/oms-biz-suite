
package com.doublechaintech.oms.orderpromotion;
//import com.doublechaintech.oms.EntityNotFoundException;
import com.doublechaintech.oms.OmsException;
import com.doublechaintech.oms.Message;
import java.util.List;

public class OrderPromotionManagerException extends OmsException {
	private static final long serialVersionUID = 1L;
	public OrderPromotionManagerException(String string) {
		super(string);
	}
	public OrderPromotionManagerException(Message message) {
		super(message);
	}
	public OrderPromotionManagerException(List<Message> messageList) {
		super(messageList);
	}

}



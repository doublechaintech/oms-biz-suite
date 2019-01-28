
package com.doublechaintech.oms.userorder;
//import com.doublechaintech.oms.EntityNotFoundException;
import com.doublechaintech.oms.OmsException;
import com.doublechaintech.oms.Message;
import java.util.List;

public class UserOrderManagerException extends OmsException {
	private static final long serialVersionUID = 1L;
	public UserOrderManagerException(String string) {
		super(string);
	}
	public UserOrderManagerException(Message message) {
		super(message);
	}
	public UserOrderManagerException(List<Message> messageList) {
		super(messageList);
	}

}




package com.doublechaintech.oms.objectaccess;
//import com.doublechaintech.oms.EntityNotFoundException;
import com.doublechaintech.oms.OmsException;
import com.doublechaintech.oms.Message;
import java.util.List;

public class ObjectAccessManagerException extends OmsException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessManagerException(String string) {
		super(string);
	}
	public ObjectAccessManagerException(Message message) {
		super(message);
	}
	public ObjectAccessManagerException(List<Message> messageList) {
		super(messageList);
	}

}



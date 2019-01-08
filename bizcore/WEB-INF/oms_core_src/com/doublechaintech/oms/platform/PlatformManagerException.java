
package com.doublechaintech.oms.platform;
//import com.doublechaintech.oms.EntityNotFoundException;
import com.doublechaintech.oms.OmsException;
import com.doublechaintech.oms.Message;
import java.util.List;

public class PlatformManagerException extends OmsException {
	private static final long serialVersionUID = 1L;
	public PlatformManagerException(String string) {
		super(string);
	}
	public PlatformManagerException(Message message) {
		super(message);
	}
	public PlatformManagerException(List<Message> messageList) {
		super(messageList);
	}

}



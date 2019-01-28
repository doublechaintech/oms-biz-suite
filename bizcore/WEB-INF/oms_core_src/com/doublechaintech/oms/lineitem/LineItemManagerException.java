
package com.doublechaintech.oms.lineitem;
//import com.doublechaintech.oms.EntityNotFoundException;
import com.doublechaintech.oms.OmsException;
import com.doublechaintech.oms.Message;
import java.util.List;

public class LineItemManagerException extends OmsException {
	private static final long serialVersionUID = 1L;
	public LineItemManagerException(String string) {
		super(string);
	}
	public LineItemManagerException(Message message) {
		super(message);
	}
	public LineItemManagerException(List<Message> messageList) {
		super(messageList);
	}

}



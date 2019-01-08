
package com.doublechaintech.oms.formfieldmessage;
//import com.doublechaintech.oms.EntityNotFoundException;
import com.doublechaintech.oms.OmsException;
import com.doublechaintech.oms.Message;
import java.util.List;

public class FormFieldMessageManagerException extends OmsException {
	private static final long serialVersionUID = 1L;
	public FormFieldMessageManagerException(String string) {
		super(string);
	}
	public FormFieldMessageManagerException(Message message) {
		super(message);
	}
	public FormFieldMessageManagerException(List<Message> messageList) {
		super(messageList);
	}

}



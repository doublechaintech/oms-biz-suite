
package com.doublechaintech.oms.manualadjustment;
//import com.doublechaintech.oms.EntityNotFoundException;
import com.doublechaintech.oms.OmsException;
import com.doublechaintech.oms.Message;
import java.util.List;

public class ManualAdjustmentManagerException extends OmsException {
	private static final long serialVersionUID = 1L;
	public ManualAdjustmentManagerException(String string) {
		super(string);
	}
	public ManualAdjustmentManagerException(Message message) {
		super(message);
	}
	public ManualAdjustmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}



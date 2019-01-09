
package com.doublechaintech.oms;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonSerialize(using = OmsExceptionJsonSerializer.class)
public class OmsException extends Exception implements MessageContainer {
    static final long serialVersionUID = -1;
	@Override
	public String getMessage() {
    	
    	String pMessage = super.getMessage();
    	
    	if(this.getErrorMessageList().size()<=0) {
    		return pMessage;
    	}
    	if(this.getErrorMessageList().size()==1) {
    		if (pMessage == null) {
    			return getErrorMessageList().get(0).getBody();
    		}else {
    			return pMessage+"\n"+getErrorMessageList().get(0).getBody();
    		}
    	}
    	
		StringBuilder stringBuilder=new StringBuilder();
		if (pMessage != null) {
			stringBuilder.append(pMessage).append(':');
		}
		
		for(Message message: getErrorMessageList()) {
			stringBuilder.append(message.getBody());
		}
		
		
		return stringBuilder.toString();
	}
    public OmsException() {
        super();
    }
    
	
    public OmsException(String message) {
        super(message);
    }
    public OmsException(Message message) {
    	super();
        this.addErrorMessage(message);
    }
	public OmsException(List<Message> messageList) {
        super();
        this.addErrorMessages(messageList);
    }
    


    public OmsException(String message, Throwable cause) {
        super(message, cause);
    }


    public OmsException(Throwable cause) {
        super(cause);
    }
	private List<Message> errorMessageList;
    
    public List<Message> getErrorMessageList() {
		
    	ensureErrorList();
		
		return errorMessageList;
	}
	public void setErrorMessageList(List<Message> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	
	protected void ensureErrorList(){
		if(errorMessageList ==  null){
			errorMessageList =  new ArrayList<Message>();
		}
	}
	
	public void addErrorMessage(Message errorMessage) {
		ensureErrorList();
		errorMessageList.add(errorMessage);
		
	}
	public void addErrorMessages(List<Message> messageList) {
		ensureErrorList();
		errorMessageList.addAll(messageList);
		
	}
	public boolean hasErrors(){
		if(errorMessageList == null){
			return false;
		}
		if(errorMessageList.isEmpty()){
			return false;
		}
		return true;
	}

   
}


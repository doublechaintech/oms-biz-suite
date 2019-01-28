package com.doublechaintech.oms.userorder;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.oms.OmsObjectPlainCustomSerializer;
public class UserOrderSerializer extends OmsObjectPlainCustomSerializer<UserOrder>{

	@Override
	public void serialize(UserOrder userOrder, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, userOrder, provider);
		
	}
}



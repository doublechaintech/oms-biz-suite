package com.doublechaintech.oms.userwhitelist;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.oms.OmsObjectPlainCustomSerializer;
public class UserWhiteListSerializer extends OmsObjectPlainCustomSerializer<UserWhiteList>{

	@Override
	public void serialize(UserWhiteList userWhiteList, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, userWhiteList, provider);
		
	}
}


package com.doublechaintech.oms.profile;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.oms.OmsObjectPlainCustomSerializer;
public class ProfileSerializer extends OmsObjectPlainCustomSerializer<Profile>{

	@Override
	public void serialize(Profile profile, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, profile, provider);
		
	}
}



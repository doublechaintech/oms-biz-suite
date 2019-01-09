package com.doublechaintech.oms.platform;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.oms.OmsObjectPlainCustomSerializer;
public class PlatformSerializer extends OmsObjectPlainCustomSerializer<Platform>{

	@Override
	public void serialize(Platform platform, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, platform, provider);
		
	}
}



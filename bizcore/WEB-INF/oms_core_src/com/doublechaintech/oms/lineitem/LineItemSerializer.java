package com.doublechaintech.oms.lineitem;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.oms.OmsObjectPlainCustomSerializer;
public class LineItemSerializer extends OmsObjectPlainCustomSerializer<LineItem>{

	@Override
	public void serialize(LineItem lineItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, lineItem, provider);
		
	}
}



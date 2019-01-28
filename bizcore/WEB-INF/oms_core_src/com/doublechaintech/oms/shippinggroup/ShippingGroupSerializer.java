package com.doublechaintech.oms.shippinggroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.oms.OmsObjectPlainCustomSerializer;
public class ShippingGroupSerializer extends OmsObjectPlainCustomSerializer<ShippingGroup>{

	@Override
	public void serialize(ShippingGroup shippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, shippingGroup, provider);
		
	}
}



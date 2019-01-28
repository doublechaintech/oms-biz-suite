package com.doublechaintech.oms.paymentgroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.oms.OmsObjectPlainCustomSerializer;
public class PaymentGroupSerializer extends OmsObjectPlainCustomSerializer<PaymentGroup>{

	@Override
	public void serialize(PaymentGroup paymentGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, paymentGroup, provider);
		
	}
}



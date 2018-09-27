package _Jackson;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsondataFormatDeserialize extends JsonDeserializer<Timestamp>{

	@Override
	public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd");
		String text = p.getText();
		try {
			return new Timestamp(simpleformat.parse(text).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

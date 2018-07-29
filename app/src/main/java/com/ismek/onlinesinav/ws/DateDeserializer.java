package com.ismek.onlinesinav.ws;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

public class DateDeserializer implements JsonDeserializer<Date> {

  @Override
  public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
      //String date = element.getAsString();
      Long l = element.getAsLong();

      /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      format.setTimeZone(TimeZone.getTimeZone("GMT"));
      try {
          return format.parse(date);
      } catch (ParseException exp) {
          exp.printStackTrace();
          return null;
      }*/
      return new Date(l);
   }


}
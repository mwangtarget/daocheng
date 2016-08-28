package com.daocheng.clearout;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import org.joda.beans.Bean;
import org.joda.beans.ser.JodaBeanSer;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;

public class JodaBeanHttpMessageConverter extends AbstractGenericHttpMessageConverter<Object>{

	//Register jodabean as HTTPMessage converter
	public JodaBeanHttpMessageConverter(){
		super(MediaType.APPLICATION_JSON, new MediaType("application", "*+json"));
	}
	
	@Override
	public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode rootNode = objectMapper.readTree(inputMessage.getBody());
		
		JsonNode beanNode = rootNode.path("@bean");
		String beanName = beanNode.asText();
		Bean requestBean = JodaBeanSer.PRETTY.jsonReader().read(rootNode.asText());
		return requestBean;
	}

	@Override
	protected void writeInternal(Object t, Type type, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		// should not be called, since we override canRead/Write instead
		throw new UnsupportedOperationException();
	}

	@Override
	protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
		if (!canRead(mediaType)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		if (!canWrite(mediaType)) {
			return false;
		}
		return true;
	}

}

package com.intertech.lab1.transformers;

import java.io.File;
import java.io.IOException;

import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLtoJSONTransformer {
	
	@Transformer
	public Message toJSON(Message<String> iString) {
		String msg = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			XmlMapper xmlMapper = new XmlMapper();
			JsonNode root = xmlMapper.readTree(iString.getPayload().toString());
			msg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return MessageBuilder.withPayload(msg.toString()).build();
	}

}

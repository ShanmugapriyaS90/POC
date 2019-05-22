package com.intertech.lab1.splitters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JsonSplitter {
	
	public List<Message<String>> split(Message<String> inMessage) {
		List<Message<String>> messages = new ArrayList<Message<String>>();
		String jsonString = inMessage.getPayload().toString();
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			JsonNode root = mapper.readTree(jsonString);
			if (root.isArray()) {
				ArrayNode array = (ArrayNode) root;
				if (array.elements() != null) {
					Iterator<JsonNode> it = array.elements();
					while(it.hasNext()) {
						messages.add( MessageBuilder.withPayload(it.next().toString()).build());
					}
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return messages;
		
	}

}

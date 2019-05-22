package com.intertech.lab1.activators;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intertech.lab1.dao.MyBatisDAO;

public class FileServiceActivator {
	
	public void printShiporder(Object order){
		System.out.println(order);
	}
	
	public void insertToDB(Object order) {
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("si-components.xml");
		/* SqlSessionFactory sessionFactory  = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
         MyBatisDAO dao = new MyBatisDAO(sessionFactory);*/
         JsonNode node = null;
      // populate hashmap with values
         HashMap<String, Object> map = new HashMap();
         if (order instanceof String) {
        	 String jsonString =  order.toString();
        	 ObjectMapper mapper = new ObjectMapper(); 
     		try {
     			JsonNode root = mapper.readTree(jsonString);
     			if(root!=null ) {
     				node = root.path("orderid");
     				map.put("orderid", node.toString());
     				node = root.path("shipto");
     				map.put("shipto",node.get("name").toString());
     				map.put("country",node.get("country").toString());
     				node = root.path("item");
     				map.put("price",node.get("price").asInt());
     			}
     		} catch (JsonProcessingException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
         }
         printShiporder(order);
	    // dao.insert(map);
	}

}

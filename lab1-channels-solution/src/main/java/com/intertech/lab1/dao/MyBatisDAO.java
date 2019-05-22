package com.intertech.lab1.dao;

import java.util.HashMap;

/*import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;*/


public class MyBatisDAO {
	
 /*   private SqlSessionFactory sqlSessionFactory = null;
    
    public MyBatisDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }*/
 
    /*@SuppressWarnings("unchecked")
    public  List<Person> selectAll(){
        List<Person> list = null;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            list = session.selectList("Person.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> "+list);
        return list;
 
    }

    public Person selectById(int id){
        Person person = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            person = session.selectOne("Person.selectById", id);
 
        } finally {
            session.close();
        }
        System.out.println("selectById("+id+") --> "+person);
        return person;
    } 
*/
    /*public int insert(HashMap<String, Object> map){
       int id = -1;
       SqlSession session = sqlSessionFactory.openSession();
        try {
            id = session.insert("Order.insert", map);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("Inserted!!");
        return id;
    }*/

   /* public void update(Person person){
       int id = -1;
      SqlSession session = sqlSessionFactory.openSession();
 
      try {
          id = session.update("Person.update", person);
 
      } finally {
          session.commit();
          session.close();
      }
      System.out.println("update("+person+") --> updated");
  }
 
    public void delete(int id){
 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            session.delete("Person.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete("+id+")");
 
    }
*/
}

package com.maldives.repository.mapping;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.maldives.model.Empresa;

public class MyBatisExec {
	
	public static void main(String args[]) throws IOException {
	      
	      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	      SqlSession session = sqlSessionFactory.openSession();
	      
	      //Create a new student object
	      Empresa empresa = new Empresa();
	      empresa.setNmEmpresa("Resultados Virtuais");
	      empresa.setCdRamoAtividade(1);
	      empresa.setDeEmail("contato@resultadosvirtuais.com.br2"); 
	            
	      //Insert student data      
	      session.insert("Empresa.insert", empresa);
	      System.out.println("record inserted successfully");
	      session.commit();
	      session.close();
				
	   }

}

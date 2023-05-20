package com.ricardo.erp.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ricardo.erp.model.Empresa;

public class SchemaGeneration {
	
	public static void main(String[] args) {
		
		//criando a conexao com o banco pegando o valor do persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		EntityManager em = emf.createEntityManager();
		
		//listando todas as empresas
		List<Empresa> empresaList = em.createQuery("from Empresa", Empresa.class ).getResultList();
		System.out.println(empresaList);
		
		// fechando as conexoes
		em.close();
		emf.close();
	}
}

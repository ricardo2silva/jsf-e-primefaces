package com.ricardo.erp.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped // esta anotação pertence ao CDI, ela nos informa que ela deve sobreviver o ciclo de vida durante nossa aplicação estiver de pé
public class EntityManagerProducer {
	
	private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
	}
	
	@Produces // toda vez que alguma classe invocar o entityManager ele vai criar uma instancia 
	@RequestScoped // a cada requisição vai ser uma instancia nova
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	// toda vez que o entityManager for encerrado o CDI vai chamar este metódo para fechar o entityManager
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}

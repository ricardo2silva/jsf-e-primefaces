package com.ricardo.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ricardo.erp.model.Empresa;


public class Empresas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;
	
	public Empresas() {}
	
	public Empresas(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Empresa porId(Long id) {
		return entityManager.find(Empresa.class, id);
	}
	
	public List<Empresa> pesquisar(String nome) {
		TypedQuery<Empresa> query = entityManager.createQuery("from Empresa where nomeFantasia like :nomeFantasia",Empresa.class);
		query.setParameter("nomeFantasia",nome.concat("%"));
	
		return query.getResultList();
	}
	
	public Empresa guardar(Empresa empresa) {
		return entityManager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		entityManager.remove(empresa);
	}
	
}

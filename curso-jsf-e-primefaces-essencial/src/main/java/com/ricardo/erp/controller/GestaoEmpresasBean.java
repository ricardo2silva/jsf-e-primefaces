package com.ricardo.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ricardo.erp.enums.TipoEmpresa;
import com.ricardo.erp.model.Empresa;
import com.ricardo.erp.model.RamoAtividade;
import com.ricardo.erp.repository.RamoAtividades;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Empresa empresa = new Empresa();
	

	public Empresa getEmpresa() {
		return empresa;
	}
	

	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	
	public void salvar() { 
		System.out.println("Razao social: " + empresa.getRazaoSocial()); 
		System.out.println("Nome Fantasia: " + empresa.getNomeFantasia());
		System.out.println("Tipo Empresa: " + empresa.getTipo());
		System.out.println("Faturamento: " + empresa.getFaturamento());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		EntityManager em = emf.createEntityManager();
		RamoAtividades ramoAtividades = new RamoAtividades(em);
			
		limparFormulario();
	}
	
	public void limparFormulario() {
		empresa = new Empresa();
	}
	
	
	public String ajuda() {
		// senão colocamos faces-redirect= true o browser não consegue identificar a mudançã de página
		//pois ocorre a navegação implicita, dessa forma tornamos a navegação implicita mudando a url da página 
		return "AjudaGestaoEmpresas?faces-redirect=true";
	}
	 
}

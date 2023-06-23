package com.ricardo.erp.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.ricardo.erp.enums.TipoEmpresa;
import com.ricardo.erp.model.Empresa;

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
		
		limparFormulario();
	}
	
	public void limparFormulario() {
		empresa = new Empresa();
	}
	 
}

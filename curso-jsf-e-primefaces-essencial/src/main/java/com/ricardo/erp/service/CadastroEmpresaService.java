package com.ricardo.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.ricardo.erp.model.Empresa;
import com.ricardo.erp.repository.Empresas;
import com.ricardo.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.guardar(empresa);
	} 
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}

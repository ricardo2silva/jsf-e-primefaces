package com.ricardo.erp.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named// com esta anotation definimos essa classe acessivel aqualquer xhtml
//@RequestScoped // essa instancia é inicializada quando requisitada e finalizada quando a requisição termina
//@ViewScoped // o ciclo de vida é maior, poder durar uma sessao 
@SessionScoped // somente na proxima sessão ele inicializa
public class GestaoEmpresasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Integer NUMERO = 0;
	
	public GestaoEmpresasBean() {
		NUMERO++;
	}
	public Integer getNumero() {
		return NUMERO;
	}
	
}

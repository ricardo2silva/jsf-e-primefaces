package com.ricardo.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ricardo.erp.enums.TipoEmpresa;
import com.ricardo.erp.model.Empresa;
import com.ricardo.erp.model.RamoAtividade;

public class CamadaPersistenciaTeste {
	
	public static void main(String[] args) {
		// criando a conexao com o banco
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		EntityManager em = emf.createEntityManager();
		// iniciando a conexao
		em.getTransaction().begin();
		
		//declarando os repositorios
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);
		
		//buscando as informaçoes no banco
		List<RamoAtividade> ramoAtividadeList = ramoAtividades.pesquisar("");
		List<Empresa> empresaList = empresas.pesquisar("");
		System.out.println(empresaList);
		
		//criando uma empresa
		Empresa empresa  = new Empresa();
		empresa.setNomeFantasia("Ricardo Roldao");
		empresa.setCnpj("74.492.254/0001-00");
		empresa.setRazaoSocial("Ricardo t.i");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(ramoAtividadeList.get(0));
		
		// salvando no banco
		empresas.guardar(empresa);
		em.getTransaction().commit();
		
		
		// verificando se funcionou a inserção
		List<Empresa> empresaList2 = empresas.pesquisar("");
		System.out.println(empresaList2);
		
	
		
		em.close();
		emf.close();
		
		
		
	}
}

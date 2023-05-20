package com.ricardo.erp.enums;

public enum TipoEmpresa {
	
	MEI("Microempreendedor Individual"),
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	LTDA("Sociedade Limitada"),
	SA("Sociedade Anonima");
	
	private String descricao;
	
	TipoEmpresa(String descricao){
		this.descricao = descricao;
	}
	
	public String getdescricao() {
		return descricao;
				
	}
	

}

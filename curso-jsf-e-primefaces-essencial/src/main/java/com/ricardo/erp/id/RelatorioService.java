package com.ricardo.erp.id;

import java.math.BigDecimal;

import javax.inject.Inject;

public class RelatorioService {
	
	@Inject
	private Pedidos pedidos;
	
	public RelatorioService(Pedidos pedidos) {
		this.pedidos = pedidos;
	} 
	public RelatorioService() {}
	
	public BigDecimal totalPedidosMesAtual() {
		return pedidos.totalPedidosMesAtual();
	}
}

package org.soaspark.services;

import java.math.BigDecimal;

public class ClienteService {

	public <T> void gravar(T entidade) {
		System.out.println("gravando... " + entidade.getClass().getName());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(Long id) {
		System.out.println("find... id->" + id);
		return (T) new BigDecimal(id.intValue());
	}
	
}

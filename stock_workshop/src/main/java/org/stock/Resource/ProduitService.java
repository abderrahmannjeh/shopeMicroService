package org.stock.Resource;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProduitService {
	
	
	public Produit findByCode(String code)
	{
		return Produit.find("code", code).firstResult();
	}

}

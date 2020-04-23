package org.compte_workshop.Resource;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CompteService {
	
	public Compte add(Compte cp)
	{
		Compte.persist(cp);
		
		return cp;
		
	}
	
	public Compte findById(Long id)
	{
		return Compte.findById(id);
		
	}
	
	public Compte findByRib(Long rib)
	{
		return Compte.find("rib",rib).firstResult();
	}
	
	public Compte update(Compte cp)
	{
		Compte c=findById(cp.id);
		c.client=cp.client;
		c.mantant=cp.mantant;
		c.rib=cp.rib;
		return c;
		
	}
	public void delet(Long id)
	{
		Compte c=findById(id);
		c.delete();
	}

}

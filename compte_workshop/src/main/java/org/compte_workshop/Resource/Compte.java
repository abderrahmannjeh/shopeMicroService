package org.compte_workshop.Resource;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Compte extends PanacheEntity {
	
	
	public String client;
	public Long rib;
	public float mantant;
	public Compte(String client, Long rib, float mantant) {
		super();
		this.client = client;
		this.rib = rib;
		this.mantant = mantant;
	}
	
	public Compte() {
		super();
	}

	@Override
	public String toString() {
		return "Compte [client=" + client + ", rib=" + rib + ", mantant=" + mantant + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rib == null) ? 0 : rib.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (rib == null) {
			if (other.rib != null)
				return false;
		} else if (!rib.equals(other.rib))
			return false;
		return true;
	}
	
	
	

}

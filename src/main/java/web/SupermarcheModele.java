package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Supermarche;

public class SupermarcheModele {
	private String motCle;
	List<Supermarche> supermarches = new ArrayList<>();

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Supermarche> getSupermarches() {
		return supermarches;
	}

	public void setSupermarches(List<Supermarche> supermarches) {
		this.supermarches = supermarches;
	}

}

package dao;

import java.util.List;

import metier.entities.Supermarche;

public interface ISupermarcheDao {
	
	public Supermarche save(Supermarche s);
	public List<Supermarche> supermarcheParMC(String mc);
	public Supermarche getSupermarche(Long id);
	public Supermarche updateSupermarche(Supermarche s);
	public void deleteSupermarche(Long id);

}

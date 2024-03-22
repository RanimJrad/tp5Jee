package dao;


import java.util.List;
import metier.entities.Supermarche;

public class TestDao {
	public static void main(String[] args) {
		SupermarcheDaoImpl pdao= new SupermarcheDaoImpl();
		Supermarche sup= pdao.save(new Supermarche("Monoprix express","Superette", "Tozeur",null));
		System.out.println(sup);
		List<Supermarche> supers =pdao.supermarcheParMC("M");
		for (Supermarche s : supers)
		System.out.println(s);
		}

}

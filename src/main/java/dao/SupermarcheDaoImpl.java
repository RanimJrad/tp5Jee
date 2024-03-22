package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Supermarche;
import util.JPAutil;

public class SupermarcheDaoImpl implements ISupermarcheDao {
	
	private EntityManager entityManager=JPAutil.getEntityManager("Supermarche2");

	@Override
	public Supermarche save(Supermarche s) {
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(s);
		tx.commit();
		return s;
	}
	

	@Override
	public List<Supermarche> supermarcheParMC(String mc) {
		List<Supermarche> supers = entityManager.createQuery("select s from Supermarche s where s.nomSupermarche LIKE :mc", Supermarche.class)
			    .setParameter("mc", "%" + mc + "%")
			    .getResultList();	    return supers;
	}

	@Override
	public Supermarche getSupermarche(Long id) {
		return entityManager.find(Supermarche.class, id);
	}

	@Override
	public Supermarche  updateSupermarche(Supermarche s) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(s);
		tx.commit();
		return s;
	}

	@Override
	public void deleteSupermarche(Long id) {
		Supermarche supermarche = entityManager.find(Supermarche.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(supermarche);
		entityManager.getTransaction().commit();
	}
}

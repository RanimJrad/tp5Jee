package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.JPAutil;
import metier.entities.Type;

public class TypeDaoImp implements IType{
	
	private EntityManager entityManager=JPAutil.getEntityManager("Supermarche2");
	@Override
	public Type save(Type typ ) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(typ);
	tx.commit();


	return typ;
	}
	@Override
	public Type getType(Long id) {
	return entityManager.find(Type.class, id);
	}
	@Override
	public Type updateType(Type typ) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(typ);
	tx.commit();
	return typ;
	}
	@Override
	public void deleteType(Long id) {
	Type type = entityManager.find(Type.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(type);
	entityManager.getTransaction().commit();
	}
	@Override
	public List<Type> getAllTypes() {
	List<Type> typs =

	entityManager.createQuery("select t from Type t").getResultList();
	return typs;
	}

}

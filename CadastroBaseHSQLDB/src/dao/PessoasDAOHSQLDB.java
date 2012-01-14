package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.EntityManagerFactoryHSQLDB;
import entidades.PessoaHSQLDB;

public class PessoasDAOHSQLDB {
	
	public static int inserirPessoa(PessoaHSQLDB pHSQLDB){

		int result = 0;
		
		//HSQLDB
		EntityManager managerHSQLDB = EntityManagerFactoryHSQLDB.getInstanceHSQLDB();
		try{
			managerHSQLDB.getTransaction().begin();
			managerHSQLDB.persist(pHSQLDB);
			result = pHSQLDB.getId();
			managerHSQLDB.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerHSQLDB.getTransaction().rollback();
		}
		
		return result;
	}
	
	public static PessoaHSQLDB atualizarObjeto(int id){
		EntityManager managerFirebird = EntityManagerFactoryHSQLDB.getInstanceHSQLDB();
		Query q = managerFirebird.createQuery("FROM PessoaHSQLDB WHERE ID = :ID");
		q.setParameter("ID", id);
		return (PessoaHSQLDB) q.getSingleResult();
	}
}

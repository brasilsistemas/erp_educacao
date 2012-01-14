package dao;

import javax.persistence.EntityManager;

import util.EntityManagerFactory;
import entidades.Pessoa;

public class PessoasDAO {
	
	public static void inserirPessoa(Pessoa p){

		Pessoa pMySQL = new Pessoa();
		pMySQL.setId(p.getId());
		pMySQL.setNome(p.getNome());
		
		Pessoa pHSQLDB = new Pessoa();
		pHSQLDB.setId(p.getId());
		pHSQLDB.setNome(p.getNome());
		
		Pessoa pMsSqlServer = new Pessoa();
		pMsSqlServer.setId(p.getId());
		pMsSqlServer.setNome(p.getNome());
		
		//MySQL
		EntityManager managerMySQL = EntityManagerFactory.getInstanceMySQL();
		try{
			managerMySQL.getTransaction().begin();
			managerMySQL.persist(pMySQL);
			managerMySQL.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerMySQL.getTransaction().rollback();
		}
		
		//HSQLDB
		EntityManager managerHSQLDB = EntityManagerFactory.getInstanceHSQLDB();
		try{
			managerHSQLDB.getTransaction().begin();
			managerHSQLDB.persist(pHSQLDB);
			managerHSQLDB.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerHSQLDB.getTransaction().rollback();
		}
		
		//SQLServer
		EntityManager managerSQLServer = EntityManagerFactory.getInstanceSQLServer();
		try {
			managerSQLServer.getTransaction().begin();
			managerSQLServer.persist(pMsSqlServer);
			managerSQLServer.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			managerSQLServer.getTransaction().rollback();
		}	
		
		pMySQL = null;
		pHSQLDB = null;;
		pMsSqlServer = null;
		System.gc();
	}
}

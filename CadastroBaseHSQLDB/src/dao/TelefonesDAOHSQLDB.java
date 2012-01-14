package dao;

import entidades.TelefoneHSQLDB;
import util.EntityManagerFactoryHSQLDB;
import javax.persistence.EntityManager;

public class TelefonesDAOHSQLDB {
	
	public static void inserirTelefone(TelefoneHSQLDB telefoneHSQLDB){
		
		//HSQLDB
		EntityManager managerHSQLDB = EntityManagerFactoryHSQLDB.getInstanceHSQLDB();
		try{
			managerHSQLDB.getTransaction().begin();
			managerHSQLDB.persist(telefoneHSQLDB);
			managerHSQLDB.refresh(telefoneHSQLDB.getPessoa());
			managerHSQLDB.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerHSQLDB.getTransaction().rollback();
		}
	}
}

package util;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EntityManagerFactoryHSQLDB {
	private static EntityManager managerHSQLDB;
	
	public static EntityManager getInstanceHSQLDB(){
		
		if (managerHSQLDB == null){
			managerHSQLDB = Persistence.createEntityManagerFactory("hsqldb").createEntityManager();
		}
		
		return managerHSQLDB;
	}
}

package util;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EntityManagerFactory {
	private static EntityManager managerMySQL, managerHSQLDB;
	
	public static EntityManager getInstanceMySQL(){
		
		if (managerMySQL == null){
			managerMySQL = Persistence.createEntityManagerFactory("mysql").createEntityManager();
		}
		
		return managerMySQL;
	}
	public static EntityManager getInstanceHSQLDB(){
		
		if (managerHSQLDB == null){
			managerHSQLDB = Persistence.createEntityManagerFactory("hsqldb").createEntityManager();
		}
		
		return managerHSQLDB;
	}
}

package util;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EntityManagerFactory {
	private static EntityManager managerMySQL, managerHSQLDB, managerFirebird;
	
	public static EntityManager getInstanceMySQL(){
		
		if (managerMySQL == null){
			managerMySQL = Persistence.createEntityManagerFactory("mysql").createEntityManager();
		}
		
		return managerMySQL;
	}
	
	public static EntityManager getInstanceFirebird(){
		
		if (managerFirebird == null){
			managerFirebird = Persistence.createEntityManagerFactory("firebird").createEntityManager();
		}
		
		return managerFirebird;
	}

	public static EntityManager getInstanceHSQLDB(){
		
		if (managerHSQLDB == null){
			managerHSQLDB = Persistence.createEntityManagerFactory("hsqldb").createEntityManager();
		}
		
		return managerHSQLDB;
	}
}

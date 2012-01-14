package util;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EntityManagerFactoryMySQL {
	private static EntityManager managerMySQL;
	
	public static EntityManager getInstanceMySQL(){
		
		if (managerMySQL == null){
			managerMySQL = Persistence.createEntityManagerFactory("mysql").createEntityManager();
		}
		
		return managerMySQL;
	}
}

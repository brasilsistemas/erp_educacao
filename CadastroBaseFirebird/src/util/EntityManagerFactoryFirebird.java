package util;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EntityManagerFactoryFirebird {
	private static EntityManager managerFirebird;
	
	
	public static EntityManager getInstanceFirebird(){
		
		if (managerFirebird == null){
			managerFirebird = Persistence.createEntityManagerFactory("firebird").createEntityManager();
		}
		
		return managerFirebird;
	}
}

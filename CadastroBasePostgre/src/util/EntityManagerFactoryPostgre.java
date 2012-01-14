package util;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EntityManagerFactoryPostgre {
	private static EntityManager managerPostgre;
	
	public static EntityManager getInstancePostgre(){
	
	if (managerPostgre == null){
		managerPostgre = Persistence.createEntityManagerFactory("postgre").createEntityManager();
	}
	
	return managerPostgre;
}
}

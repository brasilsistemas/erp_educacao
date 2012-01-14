package util;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EntityManagerFactoryOracle {
	private static EntityManager managerOracle;
	
	public static EntityManager getInstanceOracle(){
		
		if (managerOracle == null){
			managerOracle = Persistence.createEntityManagerFactory("oracle").createEntityManager();
		}
		
		return managerOracle;
	}
}

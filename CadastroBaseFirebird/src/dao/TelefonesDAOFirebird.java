package dao;

import entidades.TelefoneFirebird;
import util.EntityManagerFactoryFirebird;
import javax.persistence.EntityManager;

public class TelefonesDAOFirebird {
	
	public static void inserirTelefone(TelefoneFirebird telefoneFirebird){
		
		//Firebird
		EntityManager managerFirebird = EntityManagerFactoryFirebird.getInstanceFirebird();
		try{
			managerFirebird.getTransaction().begin();
			managerFirebird.persist(telefoneFirebird);
			managerFirebird.refresh(telefoneFirebird.getPessoa());
			managerFirebird.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerFirebird.getTransaction().rollback();
		}
	}
}

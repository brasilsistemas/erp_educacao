package dao;

import entidades.TelefoneOracle;
import util.EntityManagerFactoryOracle;
import javax.persistence.EntityManager;

public class TelefonesDAOOracle {
	
	public static void inserirTelefone(TelefoneOracle telefoneOracle){
		
		//Oracle
		EntityManager managerOracle = EntityManagerFactoryOracle.getInstanceOracle();
		try{
			managerOracle.getTransaction().begin();
			managerOracle.persist(telefoneOracle);
			managerOracle.refresh(telefoneOracle.getPessoa());
			managerOracle.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerOracle.getTransaction().rollback();
		}
	}
}

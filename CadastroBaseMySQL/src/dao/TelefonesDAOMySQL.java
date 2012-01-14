package dao;

import entidades.TelefoneMySQL;
import util.EntityManagerFactoryMySQL;
import javax.persistence.EntityManager;

public class TelefonesDAOMySQL {
	
	public static void inserirTelefone(TelefoneMySQL tMySQL){

		//MySQL
		EntityManager managerMySQL = EntityManagerFactoryMySQL.getInstanceMySQL();
		try{
			managerMySQL.getTransaction().begin();
			managerMySQL.persist(tMySQL);
			managerMySQL.refresh(tMySQL.getPessoa());
			managerMySQL.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerMySQL.getTransaction().rollback();
		}
	}
}

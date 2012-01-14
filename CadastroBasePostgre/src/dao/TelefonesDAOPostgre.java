package dao;

import entidades.TelefonePostgre;
import util.EntityManagerFactoryPostgre;
import javax.persistence.EntityManager;

public class TelefonesDAOPostgre {
	
	public static void inserirTelefone(TelefonePostgre telefonePostgre){
		
		//Postgre
		EntityManager managerPostgre = EntityManagerFactoryPostgre.getInstancePostgre();
		try {
			managerPostgre.getTransaction().begin();
			managerPostgre.persist(telefonePostgre);
			managerPostgre.refresh(telefonePostgre.getPessoa());
			managerPostgre.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			managerPostgre.getTransaction().rollback();
		}
	}
}

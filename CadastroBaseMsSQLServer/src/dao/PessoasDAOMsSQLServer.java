package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.EntityManagerFactoryMsSQLServer;
import entidades.PessoaMsSQLServer;

public class PessoasDAOMsSQLServer {
	
	public static int inserirPessoa(PessoaMsSQLServer pMsSqlServer){

		int result = 0;
		
		//SQLServer
		EntityManager managerSQLServer = EntityManagerFactoryMsSQLServer.getInstanceSQLServer();
		try {
			managerSQLServer.getTransaction().begin();
			managerSQLServer.persist(pMsSqlServer);
			result = pMsSqlServer.getId();
			managerSQLServer.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			managerSQLServer.getTransaction().rollback();
		}	
		
		return result;
	}
	
	public static PessoaMsSQLServer atualizarObjeto(int id){
		EntityManager managerFirebird = EntityManagerFactoryMsSQLServer.getInstanceSQLServer();
		Query q = managerFirebird.createQuery("FROM PessoaMsSQLServer WHERE ID = :ID");
		q.setParameter("ID", id);
		return (PessoaMsSQLServer) q.getSingleResult();
	}
}

package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.EntityManagerFactoryMySQL;
import entidades.PessoaMySQL;

public class PessoasDAOMySQL {
	
	public static int inserirPessoa(PessoaMySQL pMySQL){
		
		int result = 0;
		
		//MySQL
		EntityManager managerMySQL = EntityManagerFactoryMySQL.getInstanceMySQL();
		try{
			managerMySQL.getTransaction().begin();
			managerMySQL.persist(pMySQL);
			result = pMySQL.getId();
			managerMySQL.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerMySQL.getTransaction().rollback();
		}
		
		return result;
	}
	
	public static PessoaMySQL atualizarObjeto(int id){
		EntityManager managerFirebird = EntityManagerFactoryMySQL.getInstanceMySQL();
		Query q = managerFirebird.createQuery("FROM PessoaMySQL WHERE ID = :ID");
		q.setParameter("ID", id);
		return (PessoaMySQL) q.getSingleResult();
	}
}

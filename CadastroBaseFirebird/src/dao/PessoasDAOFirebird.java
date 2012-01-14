package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.EntityManagerFactoryFirebird;
import entidades.PessoaFirebird;

public class PessoasDAOFirebird {
	
	public static int inserirPessoa(PessoaFirebird pessoaFirebird){
		
		int result = 0;
		
		//Firebird
		EntityManager managerFirebird = EntityManagerFactoryFirebird.getInstanceFirebird();
		try{
			managerFirebird.getTransaction().begin();
			managerFirebird.persist(pessoaFirebird);
			result = pessoaFirebird.getPessoaID();
			managerFirebird.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerFirebird.getTransaction().rollback();
		}
		
		return result;
	}
	
	public static PessoaFirebird atualizarObjeto(int id){
		EntityManager managerFirebird = EntityManagerFactoryFirebird.getInstanceFirebird();
		Query q = managerFirebird.createQuery("FROM PessoaFirebird WHERE pessoaID = :ID");
		q.setParameter("ID", id);
		
		return (PessoaFirebird)q.getSingleResult();
	}
}

package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.EntityManagerFactoryPostgre;
import entidades.PessoaPostgre;

public class PessoasDAOPostgre {
	
	public static int inserirPessoa(PessoaPostgre pessoaPostgre){
		
		int result = 0;
				
		//Postgre
		EntityManager managerPostgre = EntityManagerFactoryPostgre.getInstancePostgre();
		try {
			managerPostgre.getTransaction().begin();
			managerPostgre.persist(pessoaPostgre);
			result = pessoaPostgre.getPessoaID();
			managerPostgre.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			managerPostgre.getTransaction().rollback();
		}
		
		return result;
	}
	
	public static PessoaPostgre atualizarObjeto(int id){
		EntityManager managerFirebird = EntityManagerFactoryPostgre.getInstancePostgre();
		Query q = managerFirebird.createQuery("FROM PessoaPostgre WHERE pessoaID = :ID");
		q.setParameter("ID", id);
		return (PessoaPostgre) q.getSingleResult();
	}
}

package dao;

import entidades.Pessoa;
import entidades.Pessoas;
import util.EntityManagerFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PessoasDAO {
	
	public static void inserirPessoa(Pessoa p){

		Pessoa pH = new Pessoa();
		pH.setId(p.getId());
		pH.setNome(p.getNome());
		
		Pessoa pF = new Pessoa();
		pF.setId(p.getId());
		pF.setNome(p.getNome());
		
		//MySQL
		EntityManager managerMySQL = EntityManagerFactory.getInstanceMySQL();
		try{
			managerMySQL.getTransaction().begin();
			managerMySQL.persist(p);
			managerMySQL.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerMySQL.getTransaction().rollback();
		}
		
		//Firebird
		EntityManager managerFirebird = EntityManagerFactory.getInstanceFirebird();
		try{
			managerFirebird.getTransaction().begin();
			managerFirebird.persist(pF);
			managerFirebird.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerFirebird.getTransaction().rollback();
		}
		
		//HSQLDB
		EntityManager managerHSQLDB = EntityManagerFactory.getInstanceHSQLDB();
		try{
			managerHSQLDB.getTransaction().begin();
			managerHSQLDB.persist(pH);
			managerHSQLDB.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerHSQLDB.getTransaction().rollback();
		}
	}
			
	public static void inserirPessoas(Pessoas p){
		/*EntityManager manager = EntityManagerFactory.getInstance();
		int i;
		Pessoa pessoa;
		try{
			for (i = 0; i < p.quantidade(); i++) {
				pessoa = p.obterPessoa(i);
				
				manager.getTransaction().begin();
				manager.persist(pessoa);
				manager.getTransaction().commit();
			} 
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
		}*/
	}
}

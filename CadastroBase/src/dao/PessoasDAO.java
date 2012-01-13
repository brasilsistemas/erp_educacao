package dao;

import javax.persistence.EntityManager;

import util.EntityManagerFactory;
import entidades.Pessoa;
import entidades.Pessoas;

public class PessoasDAO {
	
	public static void inserirPessoa(Pessoa p){

		Pessoa pH = new Pessoa();
		pH.setId(p.getId());
		pH.setNome(p.getNome());
		
		Pessoa pF = new Pessoa();
		pF.setId(p.getId());
		pF.setNome(p.getNome());
		
		Pessoa pOra = new Pessoa();
		pOra.setId(p.getId());
		pOra.setNome(p.getNome());
		
		Pessoa pSQL = new Pessoa();
		pSQL.setId(p.getId());
		pSQL.setNome(p.getNome());
		
		Pessoa pPos = new Pessoa();
		pPos.setId(p.getId());
		pPos.setNome(p.getNome());
		
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
		
		//Oracle
		EntityManager managerOracle = EntityManagerFactory.getInstanceOracle();
		try{
			managerOracle.getTransaction().begin();
			managerOracle.persist(pOra);
			managerOracle.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerOracle.getTransaction().rollback();
		}
		
		//SQLServer
		EntityManager managerSQLServer = EntityManagerFactory.getInstanceSQLServer();
		try {
			managerSQLServer.getTransaction().begin();
			managerSQLServer.persist(pSQL);
			managerSQLServer.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			managerSQLServer.getTransaction().rollback();
		}	
		
		//Postgre
		EntityManager managerPostgre = EntityManagerFactory.getInstancePostgre();
		try {
			managerPostgre.getTransaction().begin();
			managerPostgre.persist(pPos);
			managerPostgre.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			managerPostgre.getTransaction().rollback();
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

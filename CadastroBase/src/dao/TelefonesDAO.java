package dao;

import entidades.Telefone;
import entidades.Telefones;
import util.EntityManagerFactory;
import javax.persistence.EntityManager;

public class TelefonesDAO {
	
	public static void inserirTelefone(Telefone t){
		
		Telefone tH = new Telefone();
		tH.setId(t.getId());
		tH.setPessoaID(t.getPessoaID());
		tH.setTelefone(t.getTelefone());
		
		Telefone tF = new Telefone();
		tF.setId(t.getId());
		tF.setPessoaID(t.getPessoaID());
		tF.setTelefone(t.getTelefone());
		
		Telefone tOra = new Telefone();
		tOra.setId(t.getId());
		tOra.setPessoaID(t.getPessoaID());
		tOra.setTelefone(t.getTelefone());
		
		Telefone tSQL = new Telefone();
		tSQL.setId(t.getId());
		tSQL.setPessoaID(t.getPessoaID());
		tSQL.setTelefone(t.getTelefone());
		
		Telefone tPos = new Telefone();
		tPos.setId(t.getId());
		tPos.setPessoaID(t.getPessoaID());
		tPos.setTelefone(t.getTelefone());
		
		//MySQL
		EntityManager managerMySQL = EntityManagerFactory.getInstanceMySQL();
		try{
			managerMySQL.getTransaction().begin();
			managerMySQL.persist(t);
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
			managerFirebird.persist(tF);
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
			managerHSQLDB.persist(tH);
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
			managerOracle.persist(tOra);
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
			managerSQLServer.persist(tSQL);
			managerSQLServer.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			managerSQLServer.getTransaction().rollback();
		}

		//Postgre
		EntityManager managerPostgre = EntityManagerFactory.getInstancePostgre();
		try {
			managerPostgre.getTransaction().begin();
			managerPostgre.persist(tPos);
			managerPostgre.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			managerPostgre.getTransaction().rollback();
		}
	}
	
	public static void inserirTelefones(Telefones t){
		/*EntityManager manager = EntityManagerFactory.getInstance();
		Telefone telefone;
		
		try{
			for (int i = 0; i < t.quantidade(); i++) {
				telefone = t.obterTelefone(i);
				
				manager.getTransaction().begin();
				manager.persist(telefone);
				manager.getTransaction().commit();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			manager.getTransaction().rollback();
		}*/
	}
}

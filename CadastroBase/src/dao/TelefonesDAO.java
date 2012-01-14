package dao;

import entidades.Pessoa;
import entidades.Telefone;
import entidades.Telefones;
import util.EntityManagerFactory;
import javax.persistence.EntityManager;

public class TelefonesDAO {
	
	public static void inserirTelefone(Telefone t){
				
		//Pessoa pFirebird = new Pessoa();
		Pessoa pOracle = new Pessoa();
		Pessoa pPostgre = new Pessoa();
		
		int pessID = t.getPessoa().getPessoaID();
		
		//pFirebird = PessoasDAO.atualizarObjeto(pessID);
		Telefone tFirebird = new Telefone();
		tFirebird.setTelefoneID(t.getTelefoneID());
		tFirebird.setPessoaID(t.getPessoaID());
		tFirebird.setTelefone(t.getTelefone());
		tFirebird.setPessoa(t.getPessoa());

		//Firebird
		EntityManager managerFirebird = EntityManagerFactory.getInstanceFirebird();
		try{
			managerFirebird.getTransaction().begin();
			managerFirebird.persist(tFirebird);
			managerFirebird.refresh(tFirebird.getPessoa());
			managerFirebird.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerFirebird.getTransaction().rollback();
		}
			
		pOracle = PessoasDAO.atualizarObjeto(pessID);
		Telefone tOracle = new Telefone();
		tOracle.setTelefoneID(t.getTelefoneID());
		tOracle.setPessoaID(t.getPessoaID());
		tOracle.setTelefone(t.getTelefone());	
		tOracle.setPessoa(pOracle);
		
		//Oracle
		EntityManager managerOracle = EntityManagerFactory.getInstanceOracle();
		try{
			managerOracle.getTransaction().begin();
			managerOracle.persist(tOracle);
			managerOracle.refresh(tOracle.getPessoa());
			managerOracle.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			managerOracle.getTransaction().rollback();
		}

		pPostgre = PessoasDAO.atualizarObjeto(pessID);
		Telefone tPostgre = new Telefone();
		tPostgre.setTelefoneID(t.getTelefoneID());
		tPostgre.setPessoaID(t.getPessoaID());
		tPostgre.setTelefone(t.getTelefone());
		tPostgre.setPessoa(pPostgre);
		
		//Postgre
		EntityManager managerPostgre = EntityManagerFactory.getInstancePostgre();
		try {
			managerPostgre.getTransaction().begin();
			managerPostgre.persist(tPostgre);
			managerPostgre.refresh(tPostgre.getPessoa());
			managerPostgre.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			managerPostgre.getTransaction().rollback();
		}
		
		tFirebird = null;
		tOracle = null;
		tPostgre = null;
		System.gc();
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

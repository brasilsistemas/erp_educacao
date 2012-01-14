package app;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Date;

import entidades.Pessoa;
import entidades.Telefone;
import dao.PessoasDAO;
import dao.TelefonesDAO;

public class TesteDAO {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	
		String nome = "nome_teste_";
		int numeroTelefone = 0;
		DecimalFormat df = new DecimalFormat();  
	    df.applyPattern("0000000000");  
	    
	    /*JPAUtil jpaUtil = new JPAUtil();
	    jpaUtil.executeSQLCommandFirebird("CREATE SEQUENCE seq_pess_id;");
	    jpaUtil.executeSQLCommandFirebird("CREATE SEQUENCE seq_tel_id;");
	    
	    jpaUtil.executeSQLCommandOracle("CREATE SEQUENCE seq_pess_id");
	    jpaUtil.executeSQLCommandOracle("CREATE SEQUENCE seq_tel_id");
	    
	    jpaUtil.executeSQLCommandPostgre("CREATE SEQUENCE seq_pess_id;");
	    jpaUtil.executeSQLCommandPostgre("CREATE SEQUENCE seq_tel_id;");
	    
	    */ 
	    File arquivo;  
    
        arquivo = new File("arquivo.txt");  
        FileOutputStream fos = new FileOutputStream(arquivo);  
        
        Date eINI = new Date();  
        System.out.println(eINI);
        String texto = "data e hora IN�CIO teste 10 mil registros " + eINI + "\r\n";  
        fos.write(texto.getBytes()); 

		for(int idPessoa=1; idPessoa<11; idPessoa++){
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome(nome + Integer.toString(idPessoa));
			//pessoa.setPessoaID(PessoasDAO.inserirPessoa(pessoa));
			int pessID = PessoasDAO.inserirPessoa(pessoa);
			pessoa = PessoasDAO.atualizarObjeto(pessID);
			
			Telefone telefone = new Telefone();
			numeroTelefone += 1;
			telefone.setTelefone(df.format(Double.parseDouble(Integer.toString(numeroTelefone))));
			telefone.setPessoa(pessoa);
			telefone.setPessoaID(pessoa.getPessoaID());
			TelefonesDAO.inserirTelefone(telefone);
			
			Telefone telefone2 = new Telefone();
			numeroTelefone += 1;
			telefone2.setTelefone(df.format(Double.parseDouble(Integer.toString(numeroTelefone))));
			telefone2.setPessoa(pessoa);
			telefone2.setPessoaID(pessoa.getPessoaID());
			TelefonesDAO.inserirTelefone(telefone2);

			pessoa = null;
			telefone = null;
			telefone2 = null;
			System.gc();
		}

		Date eFIM = new Date();  
        System.out.println(eFIM);
        texto = "\r\n data e hora FIM teste 10 mil registros " + eFIM;  
        fos.write(texto.getBytes());  
        fos.close();
	}
}

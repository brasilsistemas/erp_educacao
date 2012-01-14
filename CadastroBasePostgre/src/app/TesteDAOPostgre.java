package app;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Date;

import entidades.PessoaPostgre;
import entidades.TelefonePostgre;
import dao.PessoasDAOPostgre;
import dao.TelefonesDAOPostgre;

public class TesteDAOPostgre {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	
		String nome = "nome_teste_";
		int numeroTelefone = 0;
		DecimalFormat df = new DecimalFormat();  
	    df.applyPattern("0000000000"); 
	    
	    File arquivo = new File("postgre.txt");  
        FileOutputStream fos = new FileOutputStream(arquivo);  
        
        Date eINI = new Date();  
        System.out.println(eINI);
        String texto = "data e hora INÍCIO teste 4 mil registros " + eINI + "\r\n";  
        fos.write(texto.getBytes()); 

		for(int idPessoa=1; idPessoa<1334; idPessoa++){
			PessoaPostgre pessoa = new PessoaPostgre();
			
			pessoa.setNome(nome + Integer.toString(idPessoa));
			int pessID = PessoasDAOPostgre.inserirPessoa(pessoa);
			pessoa = PessoasDAOPostgre.atualizarObjeto(pessID);
			
			TelefonePostgre telefone = new TelefonePostgre();
			numeroTelefone += 1;
			telefone.setTelefone(df.format(Double.parseDouble(Integer.toString(numeroTelefone))));
			telefone.setPessoa(pessoa);
			telefone.setPessoaID(pessoa.getPessoaID());
			TelefonesDAOPostgre.inserirTelefone(telefone);
			
			TelefonePostgre telefone2 = new TelefonePostgre();
			numeroTelefone += 1;
			telefone2.setTelefone(df.format(Double.parseDouble(Integer.toString(numeroTelefone))));
			telefone2.setPessoa(pessoa);
			telefone2.setPessoaID(pessoa.getPessoaID());
			TelefonesDAOPostgre.inserirTelefone(telefone2);

			pessoa = null;
			telefone = null;
			telefone2 = null;
			System.gc();
		}

		Date eFIM = new Date();  
        System.out.println(eFIM);
        texto = "\r\n data e hora FIM teste 4 mil registros " + eFIM;  
        fos.write(texto.getBytes());  
        fos.close();
	}
}

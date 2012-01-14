package app;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Date;

import entidades.PessoaFirebird;
import entidades.TelefoneFirebird;
import dao.PessoasDAOFirebird;
import dao.TelefonesDAOFirebird;

public class TesteDAOFirebird {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	
		String nome = "nome_teste_";
		int numeroTelefone = 0;
		DecimalFormat df = new DecimalFormat();  
	    df.applyPattern("0000000000");  
	    
	    File arquivo = new File("firebird.txt");  
        FileOutputStream fos = new FileOutputStream(arquivo);  
        
        Date eINI = new Date();  
        System.out.println(eINI);
        String texto = "data e hora IN�CIO teste 4 mil registros " + eINI + "\r\n";  
        fos.write(texto.getBytes()); 

		for(int idPessoa=1; idPessoa<1334; idPessoa++){
			PessoaFirebird pessoa = new PessoaFirebird();
			
			pessoa.setNome(nome + Integer.toString(idPessoa));
			int pessID = PessoasDAOFirebird.inserirPessoa(pessoa);
			pessoa = PessoasDAOFirebird.atualizarObjeto(pessID);
			
			TelefoneFirebird telefone = new TelefoneFirebird();
			numeroTelefone += 1;
			telefone.setTelefone(df.format(Double.parseDouble(Integer.toString(numeroTelefone))));
			telefone.setPessoa(pessoa);
			telefone.setPessoaID(pessoa.getPessoaID());
			TelefonesDAOFirebird.inserirTelefone(telefone);
			
			TelefoneFirebird telefone2 = new TelefoneFirebird();
			numeroTelefone += 1;
			telefone2.setTelefone(df.format(Double.parseDouble(Integer.toString(numeroTelefone))));
			telefone2.setPessoa(pessoa);
			telefone2.setPessoaID(pessoa.getPessoaID());
			TelefonesDAOFirebird.inserirTelefone(telefone2);

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

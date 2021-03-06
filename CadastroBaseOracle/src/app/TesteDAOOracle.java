package app;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Date;

import entidades.PessoaOracle;
import entidades.TelefoneOracle;
import dao.PessoasDAOOracle;
import dao.TelefonesDAOOracle;

public class TesteDAOOracle {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	
		String nome = "nome_teste_";
		int numeroTelefone = 0;
		DecimalFormat df = new DecimalFormat();  
	    df.applyPattern("0000000000");  
	    
	    File arquivo = new File("oracle.txt");  
        FileOutputStream fos = new FileOutputStream(arquivo);  
        
        Date eINI = new Date();  
        System.out.println(eINI);
        String texto = "data e hora IN�CIO teste 4 mil registros " + eINI + "\r\n";  
        fos.write(texto.getBytes()); 

		for(int idPessoa=1; idPessoa<1334; idPessoa++){
			PessoaOracle pessoa = new PessoaOracle();
			
			pessoa.setNome(nome + Integer.toString(idPessoa));
			int pessID = PessoasDAOOracle.inserirPessoa(pessoa);
			pessoa = PessoasDAOOracle.atualizarObjeto(pessID);
			
			TelefoneOracle telefone = new TelefoneOracle();
			numeroTelefone += 1;
			telefone.setTelefone(df.format(Double.parseDouble(Integer.toString(numeroTelefone))));
			telefone.setPessoa(pessoa);
			telefone.setPessoaID(pessoa.getPessoaID());
			TelefonesDAOOracle.inserirTelefone(telefone);
			
			TelefoneOracle telefone2 = new TelefoneOracle();
			numeroTelefone += 1;
			telefone2.setTelefone(df.format(Double.parseDouble(Integer.toString(numeroTelefone))));
			telefone2.setPessoa(pessoa);
			telefone2.setPessoaID(pessoa.getPessoaID());
			TelefonesDAOOracle.inserirTelefone(telefone2);

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

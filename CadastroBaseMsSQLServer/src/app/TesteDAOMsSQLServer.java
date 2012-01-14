package app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import entidades.PessoaMsSQLServer;
import dao.PessoasDAOMsSQLServer;
import entidades.TelefoneMsSQLServer;
import dao.TelefonesDAOMsSQLServer;

public class TesteDAOMsSQLServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
		String nome = "nome_teste_";
		int idTelefone = 0;
		DecimalFormat df = new DecimalFormat();  
	    df.applyPattern("0000000000");  
	    
	    File arquivo = new File("sqlserver.txt");  
        FileOutputStream fos = new FileOutputStream(arquivo);  
        
        Date eINI = new Date();  
        System.out.println(eINI);
        String texto = "data e hora IN�CIO teste 4 mil registros " + eINI + "\r\n";  
        fos.write(texto.getBytes()); 
	     
		for(int idPessoa=1; idPessoa<1334; idPessoa++){
			PessoaMsSQLServer pessoa = new PessoaMsSQLServer();
			
			pessoa.setNome(nome + Integer.toString(idPessoa));
			int pessID = PessoasDAOMsSQLServer.inserirPessoa(pessoa);
			pessoa = PessoasDAOMsSQLServer.atualizarObjeto(pessID);
			
			TelefoneMsSQLServer telefone = new TelefoneMsSQLServer();
			idTelefone = idTelefone + 1;
			telefone.setTelefone(df.format(Double.parseDouble(Integer.toString(idTelefone))));
			telefone.setPessoa(pessoa);
			telefone.setPessoaID(pessoa.getId());
			TelefonesDAOMsSQLServer.inserirTelefone(telefone);
			
			TelefoneMsSQLServer telefone2 = new TelefoneMsSQLServer();
			idTelefone = idTelefone + 1;
			telefone2.setTelefone(df.format(Double.parseDouble(Integer.toString(idTelefone))));
			telefone.setPessoa(pessoa);
			telefone.setPessoaID(pessoa.getId());
			TelefonesDAOMsSQLServer.inserirTelefone(telefone2);
			
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

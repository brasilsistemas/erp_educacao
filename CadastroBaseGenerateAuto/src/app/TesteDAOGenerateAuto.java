package app;

import java.text.DecimalFormat;
import entidades.Pessoa;
import dao.PessoasDAO;
import entidades.Telefone;
import dao.TelefonesDAO;

public class TesteDAOGenerateAuto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String nome = "nome_teste_";
		int idTelefone = 0;
		DecimalFormat df = new DecimalFormat();  
	    df.applyPattern("0000000000");  
	     
		for(int idPessoa=1; idPessoa<11; idPessoa++){
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome(nome + Integer.toString(idPessoa));
			PessoasDAO.inserirPessoa(pessoa);
			
			Telefone telefone = new Telefone();
			idTelefone = idTelefone + 1;
			telefone.setPessoaID(idPessoa);
			telefone.setTelefone(df.format(Double.parseDouble(Integer.toString(idTelefone))));
			TelefonesDAO.inserirTelefone(telefone);
			
			Telefone telefone2 = new Telefone();
			idTelefone = idTelefone + 1;
			telefone2.setPessoaID(idPessoa);
			telefone2.setTelefone(df.format(Double.parseDouble(Integer.toString(idTelefone))));
			TelefonesDAO.inserirTelefone(telefone2);
			
			pessoa = null;
			telefone = null;
			telefone2 = null;
			System.gc();
		}
	}
}

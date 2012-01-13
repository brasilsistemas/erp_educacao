package app;

import java.text.DecimalFormat;
import java.text.Format;

import entidades.Pessoa;
import dao.PessoasDAO;
import entidades.Telefone;
import dao.TelefonesDAO;

public class TesteDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String nome = "nome_teste_";
		int idTelefone = 0;
		
		Pessoa pessoa = new Pessoa();
		Telefone telefone = new Telefone();
		DecimalFormat df = new DecimalFormat();  
	    df.applyPattern("0000000000");  
	     
		for(int idPessoa=1; idPessoa<10; idPessoa++){
			pessoa.setId(idPessoa);
			pessoa.setNome(nome + Integer.toString(idPessoa));
			PessoasDAO.inserirPessoa(pessoa);
			
			idTelefone = idTelefone + 1;
			telefone.setId(idTelefone);
			telefone.setPessoaID(idPessoa);
			telefone.setTelefone(df.format(Double.parseDouble(Integer.toString(idTelefone))));
			TelefonesDAO.inserirTelefone(telefone);
			
			idTelefone = idTelefone + 1;
			telefone.setId(idTelefone);
			telefone.setPessoaID(idPessoa);
			telefone.setTelefone(df.format(Double.parseDouble(Integer.toString(idTelefone))));
			TelefonesDAO.inserirTelefone(telefone);
		}
	}
}

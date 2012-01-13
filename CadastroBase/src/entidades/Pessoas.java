package entidades;

import java.util.ArrayList;
import entidades.Pessoa;
import entidades.Telefones;

public class Pessoas {
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Telefones telefones;

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public void addPessoa(Pessoa pessoa){
		this.pessoas.add(pessoa);
	}
	
	public Pessoa obterPessoa(int index){
		return pessoas.get(index);
	}

	public Telefones getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefones telefones) {
		this.telefones = telefones;
	}
	
	public int quantidade(){
		return this.pessoas.size();
	}
}

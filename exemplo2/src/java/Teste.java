import java.sql.SQLException;


public class Teste {
	public static void main(String[] args) throws SQLException {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("outronome");
		pessoa.setId(0);

		PessoaDAO dao = new PessoaDAO();
		try {
			dao.altera(pessoa);
			System.out.println("Pessoa alterado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		
		pessoa.setId(1);
		try {
			dao.remove(pessoa);
			System.out.println("removido com sucesso");
		} catch (Exception e) {
			System.out.println("Erro: "+e);
		}
	}
}

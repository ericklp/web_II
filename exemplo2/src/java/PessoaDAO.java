import db.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaDAO {
	private Connection conn;

	public PessoaDAO() throws SQLException, ClassNotFoundException
	{
		this.conn = (Connection) new ConnectionFactory().getConnection();
	}

	public ArrayList <Pessoa> seleciona() throws SQLException {
		String sql = "SELECT * from tb_pessoa;";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();

			ArrayList <Pessoa> pessoalist = new ArrayList <Pessoa>();

			while (res.next())
			{
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(res.getString(2));
                                pessoa.setSexo(res.getString(3));
				pessoalist.add(pessoa);
			}
			
			System.out.println("Executed: "+ pessoalist.toString());
                        
                        return pessoalist;
		}
		catch (SQLException e)
		{
			System.out.println("erro: "+e);
		}

                return null;
		
		
	}
	
	public void remove(Pessoa pessoa) throws SQLException {
		String sql = "DELETE from tb_pessoa WHERE id_pessoa=(?);";
		
		try
		{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,pessoa.getId());
			stmt.executeUpdate();
			System.out.println("deleted "+stmt.getUpdateCount()+" rows");
		}
		catch (SQLException e)
		{
			System.out.println("error(remove): "+e);
		}
	}
	
	public void altera(Pessoa pessoa) throws SQLException {
		String sql = "UPDATE tb_pessoa SET nm_pessoa=(?) WHERE id_pessoa=(?);";
		try
		{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setInt(2, pessoa.getId());
			stmt.executeUpdate();
			System.out.println("altered "+stmt.getUpdateCount()+" rows");
		}
		catch (SQLException e)
		{
			System.out.println("error(remove): "+e);
		}		
	}
}
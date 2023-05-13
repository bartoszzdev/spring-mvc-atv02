package br.com.fiap.atv02.atividade02.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;

import br.com.fiap.atv02.atividade02.model.Cidade;
import br.com.fiap.atv02.atividade02.model.Usuario;

public class UsuarioDAO implements DAO<Usuario> {

    private DataSource dataSource;

    public UsuarioDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    /* --- metodo CREATE --- */
    @Override
	public void create(Usuario object) {
	   try{
// declaro a STRING SQL correspondente ao comando
// substituindo os valores pelo caractere “?”
		 String SQL = "insert into TB_TIN_USUARIO (nivel,genero, email, senha, nome,nascimento, ultimo_acesso, foto, id_cidade)values (?,?,?,?,?,?,?,?,?) ";
// gero um Statement a partir da String
		PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
// preencho os parâmetros com valores do objeto
		stm.setString(1, object.getNivel());
		stm.setString(2, object.getGenero());
		stm.setString(3, object.getEmail());
		stm.setString(4, object.getSenha());
		stm.setString(5, object.getNome());
		stm.setString(6, object.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		stm.setString(7, object.getUltimoAcesso().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		stm.setString(8, object.getFoto());
		stm.setInt(9, object.getCidade().getId());
		stm.setInt(10,  object.getId());
		
// executo a operação de atualização da tabela
         int res = stm.executeUpdate();
	// se deu certo, a variável RES retorna != 0
		if (res != 0) {
			System.out.println("Usuario alterado com sucesso");
		}
		else {
			throw new RuntimeException("Erro ao inserir usuario ");
		}
	   } catch (Exception ex) {
		  System.out.println("UsuarioDAO.CREATE = " + ex.getMessage());
	   }
		
	}

    /* --- metodo READ --- */
    @Override
	public Usuario read(Usuario object) {
		// TODO Auto-generated method stub
		try {
// declaro a STRING SQL correspondente ao comando
// substituindo os valores pelo caractere “?”
			String SQL = "select * from TB_TIN_USUARIO inner join TB_TIN_CIDADE on TB_TIN_USUARIO.ID_CIDADE = TB_TIN_CIDADE.ID where email = ? and senha = ?";
// gero o Statement a partir da conexao
			PreparedStatement stm = 
  					dataSource.getConnection()
         .prepareStatement(SQL);

// preencho apenas com os atributos email e senha
			stm.setString(1, object.getEmail());
			stm.setString(2, object.getSenha());

// aqui o resultado é armazenado num objeto ResultSet
			ResultSet rs = stm.executeQuery();

// o método next() indica se há registro no resultado
// se houver, eu preencho o objeto
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("ID"));
				usuario.setNome(rs.getString("NOME"));
 	  		    usuario.setNivel(rs.getString("NIVEL"));
				usuario.setGenero(rs.getString("GENERO"));
	 		    usuario.setEmail(rs.getString("EMAIL"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setNascimento(rs.getDate("NASCIMENTO").toLocalDate());
				usuario.setUltimoAcesso(rs.getDate("ULTIMO_ACESSO").toLocalDate());
				usuario.setFoto(rs.getString("FOTO"));
				Cidade cidade = new Cidade();
				cidade.setId(rs.getInt("ID_CIDADE"));
				cidade.setCidade(rs.getString("CIDADE"));
				cidade.setEstado(rs.getString("ESTADO"));
				cidade.setSiglaEstado(rs.getString("SIGLA_ESTADO"));
				cidade.setPais(rs.getString("PAIS"));
				cidade.setSiglaPais(rs.getString("SIGLA_PAIS"));
				usuario.setCidade(cidade);
				return usuario;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("UsuarioDAO.READ = " + ex.getMessage());
		}
		return null;
	}

    /* --- metodo UPDATE --- */
    @Override
	public void update(Usuario object) {
		try {
// declaro a STRING SQL correspondente ao comando
// substituindo os valores pelo caractere “?”
			String SQL = "update TB_TIN_USUARIO set nivel = ?, genero = ?, email = ?, senha = ?, nome = ?, nascimento = ?, ultimo_acesso = ?, foto = ?, id_cidade = ? where id = ?";
// gero o Statement a partir da conexao			
 PreparedStatement stm = 
dataSource.getConnection()
 .prepareStatement(SQL);

     // preencho os parâmetros com os dados do objeto
			stm.setString(1, object.getNivel());
			stm.setString(2, object.getGenero());
			stm.setString(3, object.getEmail());
			stm.setString(4, object.getSenha());
			stm.setString(5, object.getNome());
			stm.setString(6,object.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
			stm.setString(7, object.getUltimoAcesso().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
			stm.setString(8, object.getFoto());
			stm.setInt(9, object.getCidade().getId());
			stm.setInt(10,  object.getId());
			
// executo a instrução para atualizar a tabela
			int res = stm.executeUpdate();
			if (res != 0) {
				System.out.println("Usuario alterado com sucesso");
			}
			else {
				throw new RuntimeException("Erro ao atualizar usuario ");
			}
		}
		catch(Exception ex) {
			System.out.println("UsuarioDAO.UPDATE =" + ex.getMessage());
		}
		
	}

    /* --- metodo DELETE --- */
    @Override
	public void delete(Usuario object) {
		try {
			// definimos nossa instrucão SQL
			String SQL = "delete from TB_TIN_USUARIO where ID = ?";
			PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
			stm.setInt(1, object.getId());
            int res = stm.executeUpdate();
			if (res != 0) {
				System.out.println("Usuario excluido com sucesso");
			}
			else {
				throw new RuntimeException("ERRO ao apagar usuario");
			}
		}
		catch (Exception ex) {
			System.out.println("UsuarioDAO.DELETE = " + ex.getMessage());
		}
	}
}

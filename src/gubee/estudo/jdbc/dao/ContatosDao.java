package gubee.estudo.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import gubee.estudo.jdbc.ConnectionFactory;
import gubee.estudo.web.Contato;

public class ContatosDao {
	
	private Connection connection;
	
	public ContatosDao() {
		
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Contato contato) {
		
		 try {
			String sql = "insert into contatos" +
			            " (nome,email,endereco,datanascimento)" +
			            " values (?,?,?,?)";
			    PreparedStatement stmt = connection.prepareStatement(sql);

			    stmt.setString(1, contato.getName());
			    stmt.setString(2, contato.getEmail());
			    stmt.setString(3, contato.getAddress());
			    stmt.setDate(4, new Date(contato.getBirthday().getTimeInMillis()));

			    stmt.execute();
			    stmt.close();
			    
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	 public List<Contato> getList() {
         try {
             List<Contato> contatos = new ArrayList<Contato>();
             PreparedStatement stmt = this.connection.
                     prepareStatement("select * from contatos");
             ResultSet rs = stmt.executeQuery();

             while (rs.next()) {
                 // criando o objeto Contato
                 Contato contato = new Contato();
                 contato.setId(rs.getLong("id"));
                 contato.setName(rs.getString("nome"));
                 contato.setEmail(rs.getString("email"));
                 contato.setAddress(rs.getString("endereco"));

                 // montando a data através do Calendar
                 Calendar data = Calendar.getInstance();
                 data.setTime(rs.getDate("dataNascimento"));
                 contato.setBirthday(data);

                 // adicionando o objeto à lista
                 contatos.add(contato);
             }
             rs.close();
             stmt.close();
             return contatos;
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }

	
	public void update(Contato contato) {
		
	    String sql = "update contatos set nome=?, email=?, endereco=?," +
	            "dataNascimento=? where id=?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, contato.getName());
	        stmt.setString(2, contato.getEmail());
	        stmt.setString(3, contato.getAddress());
	        stmt.setDate(4, new Date(contato.getBirthday()
	                .getTimeInMillis()));
	        stmt.setLong(5, contato.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void delete(Contato contato){
		
		String sql = "delete * from contatos where id=?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);	       
	        stmt.setLong(1, contato.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }		
	}
	
	

}

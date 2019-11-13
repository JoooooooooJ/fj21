package gubee.estudo.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import gubee.estudo.jdbc.ConnectionFactory;
import gubee.estudo.web.Contact;

public class ContactDao implements Database<Contact>{
	
	private Connection connection;
	
	public ContactDao() {
		
		this.connection = new ConnectionFactory().getConnection();
	}
	
	@Override
	public void add(Object obj) {
		
		Contact contact = (Contact)obj;
		
		 try {
			String sql = "insert into contatos" +
			            " (nome,email,endereco,datanascimento)" +
			            " values (?,?,?,?)";
			    PreparedStatement stmt = connection.prepareStatement(sql);

			    stmt.setString(1, contact.getName());
			    stmt.setString(2, contact.getEmail());
			    stmt.setString(3, contact.getAddress());
			    stmt.setDate(4, new Date(contact.getBirthday().getTimeInMillis()));

			    stmt.execute();
			    stmt.close();
			    
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Object obj) {
		
		Contact contact = (Contact)obj;
		
	    String sql = "update contatos set nome=?, email=?, endereco=?," +
	            "dataNascimento=? where id=?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, contact.getName());
	        stmt.setString(2, contact.getEmail());
	        stmt.setString(3, contact.getAddress());
	        stmt.setDate(4, new Date(contact.getBirthday()
	                .getTimeInMillis()));
	        stmt.setLong(5, contact.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@Override	
	public void remove(Object obj){
		
		Contact contact = (Contact)obj;
		
		String sql = "delete from contatos where id=?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);	       
	        stmt.setLong(1, contact.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }		
	}	
	@Override
	public List<Contact> getList() {
        try {
            List<Contact> contacts = new ArrayList<Contact>();
            PreparedStatement stmt = this.connection
            		.prepareStatement("select * from contatos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                Contact contact = new Contact();
                contact.setId(rs.getLong("id"));
                contact.setName(rs.getString("nome"));
                contact.setEmail(rs.getString("email"));
                contact.setAddress(rs.getString("endereco"));

                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contact.setBirthday(data);

                contacts.add(contact);
            }
            rs.close();
            stmt.close();
            return contacts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	

}

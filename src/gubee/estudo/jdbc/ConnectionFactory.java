package gubee.estudo.jdbc;

import java.sql.*;

public class ConnectionFactory {

    public Connection getConnection() {   	
    	try {

    		Class.forName("org.postgresql.Driver");
    		return DriverManager.getConnection(
    				"jdbc:postgresql://localhost:6060/fj21", "postgres", "123");

    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}

    }   
}

package serpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Prueba {

	public static Connection connection;
	public static void main(String[] args) throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");

		//insert();
		//delete(1);
		//load();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from categoria");
		while (resultSet.next())
			System.out.printf("%s %s\n",resultSet.getObject(1), resultSet.getObject(2));
		statement.close(); //implicit resultSet.close()
		connection.close();
	}

	private static void insert() throws SQLException {
		String insertSql = "insert into categoria (nombre) values (?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
		preparedStatement.setObject(1, "categoria " + LocalDateTime.now());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	private static void delete(int id) {
		String deleteSql = "delete from categoria where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			//System.out.println(e);
			System.out.println("No se puede eliminar porque existe una foreignkey");
		}
	}

	/*private static void load() throws SQLException {
		String loadSql = "select * from categoria";
		PreparedStatement preparedStatement = connection.prepareStatement(loadSql);
		//TODO
	}*/
}

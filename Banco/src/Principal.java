
public class Principal {

	public static void main(String[] args) {
		
		conectar(new MySql());
		conectar(new Oracle());

	}
	
	public static void conectar(Connection connection) {
		connection.connect();
		connection.commit();
		connection.rollback();
	}

}

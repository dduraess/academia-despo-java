
public class MySql implements Connection {

	@Override
	public void rollback() {
		System.out.println("Rollback com sucesso");

	}

	@Override
	public void commit() {
		System.out.println("Commit com sucesso");
	}

	@Override
	public void connect() {
		System.out.println("Conectando com MySQL");

	}

}

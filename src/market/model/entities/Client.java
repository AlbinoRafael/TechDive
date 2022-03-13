package market.model.entities;

public class Client {

	private long id;
	private String name;
	private String cpf;
	
	public Client() {}

	public Client(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + "]";
	}
	
	
	
}

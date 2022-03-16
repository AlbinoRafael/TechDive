package market.model.entities;

import java.util.Date;

public class Sale {

	private long id;
	private Client client;
	private double price;
	private Date data;
	
	public Sale() {}

	public Sale(Client client, Date data) {
		this.client = client;
		this.data = data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", client=" + client + ", price=" + price + ", data=" + data + "]";
	}
	
	
	
}

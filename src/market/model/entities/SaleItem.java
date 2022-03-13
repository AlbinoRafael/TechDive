package market.model.entities;

public class SaleItem {

	private long id;
	private Sale sale;
	private Product product;
	private int amount;
	private double unitPrice;
	private double subtotal;
	
	public SaleItem() {}

	public SaleItem(Sale sale, Product product, int amount, double unitPrice) {
		super();
		this.sale = sale;
		this.product = product;
		this.amount = amount;
		this.unitPrice = unitPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "SaleItem [id=" + id + ", sale=" + sale + ", product=" + product + ", amount=" + amount + ", unitPrice="
				+ unitPrice + ", subtotal=" + subtotal + "]";
	}

	
	
	
}

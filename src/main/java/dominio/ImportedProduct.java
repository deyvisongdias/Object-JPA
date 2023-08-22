package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImportedProduct extends Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee=customsFee;
	}

	/*
	 * public Integer getId() { return id; }
	 */

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	/*
	 * @Override public void tagPrice() {
	 * 
	 * System.out.println(this.getName() + "$ " + this.getPrice() +
	 * "(Customs fee: $ " + this.customsFee);
	 * 
	 * }
	 */

}

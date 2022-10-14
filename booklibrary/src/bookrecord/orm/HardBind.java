package bookrecord.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("hb")
@Entity
public class HardBind extends Book{
	private int isin;
	private float hbprice;
	private String publishedYear;
	private int edition;
	public HardBind() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HardBind(int isin, float price, String publishedYear, int edition) {
		super();
		this.isin = isin;
		this.hbprice = price;
		this.publishedYear = publishedYear;
		this.edition = edition;
	}
	public int getIsin() {
		return isin;
	}
	public void setIsin(int isin) {
		this.isin = isin;
	}
	public float getPrice() {
		return hbprice;
	}
	public void setPrice(float price) {
		this.hbprice = price;
	}
	public String getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	

}

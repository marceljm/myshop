package com.marceljm.shop.entity;

import java.text.DecimalFormat;

public class Product {

	private String programId;
	private String zupid;
	private String name;
	private float price;
	private String brand;
	private String image;
	private String link;
	private String category;
	private String index;

	public Product(String line) {
		String field[] = line.split(";");
		this.programId = field[0];
		this.zupid = field[1];
		this.name = field[2];
		this.price = Float.parseFloat(field[3]);
		this.brand = field[4];
		this.image = field[5];
		this.link = field[6];
		this.category = field[7];
		this.index = field[8];
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getZupid() {
		return zupid;
	}

	public void setZupid(String zupid) {
		this.zupid = zupid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public String getFormattedPrice() {
		return new DecimalFormat("R$ #,##0.00").format(price);
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return "https://static.wmobjects.com.br/imgres/arquivos/ids/" + image + "-250-250";
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLink() {
		return "http://ad.zanox.com/ppc/?38441474C295166823&ULP=[[" + link
				+ "/sk?utm_medium=afiliados&utm_source=zanox&utm_campaign=xml_zanox&utm_term=zanox]]";
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((zupid == null) ? 0 : zupid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (zupid == null) {
			if (other.zupid != null)
				return false;
		} else if (!zupid.equals(other.zupid))
			return false;
		return true;
	}

}

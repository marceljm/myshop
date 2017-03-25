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
	private String index;
	private String category;

	public Product(String line, String category) {
		String field[] = line.split("<");
		this.programId = field[0];
		this.zupid = field[1];
		this.name = field[2];
		this.price = Float.parseFloat(field[3]);
		this.brand = field[4];
		this.image = field[5];
		this.link = field[6];
		this.category = category;
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
		switch (programId) {
		case "12011":
			return "https://static.wmobjects.com.br/imgres/arquivos/ids/" + image + "-250-250";
		case "11100":
			return "https://dafitistatic-a.akamaihd.net/" + image + "/1-catalog.jpg";
		case "12784":
			return "http://www.extra-imagens.com.br/Control/ArquivoExibir.aspx?IdArquivo=" + image;
		case "12781":
			return "http://www.pontofrio-imagens.com.br/Control/ArquivoExibir.aspx?IdArquivo=" + image;
		case "12785":
			return "http://www.casasbahia-imagens.com.br/Control/ArquivoExibir.aspx?IdArquivo=" + image;
		case "14607":
			return "http://www.merchandisingplaza.com/images/products/" + image + "/img1.jpg";
		default:
			return image;
		}
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

	public String getLink() {
		String restId;
		switch (programId) {
		case "12011":
			restId = "38441474C295166823";
			link += "/sk?utm_medium=afiliados&utm_source=zanox&utm_campaign=xml_zanox&utm_term=zanox";
			break;
		case "11100":
			restId = "37507707C988197367";
			break;
		case "12078":
			restId = "37530559C203096277";
			break;
		case "12390":
			restId = "37507853C43315444";
			break;
		case "12396":
			restId = "41761702C999842786";
			break;
		case "12587":
			restId = "37927677C478546917";
			break;
		case "12781":
			restId = "41760353C627566515";
			break;
		case "12784":
			restId = "41761329C222568561";
			break;
		case "12785":
			restId = "41760261C446857031";
			break;
		case "12841":
			restId = "41762066C49575666";
			break;
		case "13041":
			restId = "37927679C242812370";
			break;
		case "13123":
			restId = "38447179C82573227";
			break;
		case "13212":
			restId = "41513732C58869915";
			break;
		case "13314":
			restId = "38441990C471122962";
			break;
		case "13426":
			restId = "38431540C474858058";
			break;
		case "13602":
			restId = "41733413C409324161";
			break;
		case "13604":
			restId = "41733411C646492058";
			break;
		case "13724":
			restId = "41733362C711099018";
			break;
		case "13843":
			restId = "38842274C74321094";
			break;
		case "14132":
			restId = "38842272C591189868";
			break;
		case "14141":
			restId = "37892851C591547001";
			break;
		case "14607":
			restId = "38842280C502015560";
			break;
		case "14694":
			restId = "37904309C437451622";
			break;
		case "14929":
			restId = "37606609C365962420";
			break;
		case "15242":
			restId = "38441811C160226887";
			break;
		case "15316":
			restId = "37904307C568735092";
			break;
		case "15412":
			restId = "37805257C982646459";
			break;
		case "15458":
			restId = "41733407C533534372";
			break;
		case "15558":
			restId = "38430158C442643304";
			break;
		case "15562":
			restId = "38454086C767161320";
			break;
		case "15948":
			restId = "37494472C764259751";
			break;
		case "15949":
			restId = "41924108C867157175";
			break;
		case "15951":
			restId = "41924107C184752061";
			break;
		case "16197":
			restId = "37976794C925144868";
			break;
		case "16411":
			restId = "37976790C874974097";
			break;
		case "16557":
			restId = "41924098C352754997";
			break;
		case "16588":
			restId = "38447306C185701572";
			break;
		case "16888":
			restId = "37976791C15830954";
			break;
		case "16966":
			restId = "38431554C266882658";
			break;
		case "17017":
			restId = "37976788C10682670";
			break;
		case "17020":
			restId = "38842271C886409478";
			break;
		case "17122":
			restId = "37976793C18863476";
			break;
		case "17286":
			restId = "41924102C958928242";
			break;
		case "17630":
			restId = "41729669C200883294";
			break;
		case "17791":
			restId = "41924101C196885014";
			break;
		case "17794":
			restId = "41924072C716180127";
			break;
		case "18229":
			restId = "41924104C288659008";
			break;
		case "18317":
			restId = "41924106C574623116";
			break;
		case "18820":
			restId = "41924103C381135916";
			break;
		case "18878":
			restId = "41761806C655327738";
			break;
		default:
			return link;
		}
		return "http://ad.zanox.com/ppc/?" + restId + "&ULP=[[" + link + "]]";
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

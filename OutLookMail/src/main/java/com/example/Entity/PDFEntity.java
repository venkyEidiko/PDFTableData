package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PDFTable")
public class PDFEntity {
	@Id
	private String CurrencyGrid;  
	private String FristWeek;
	private String FirstMonth;
	private String SecondMonth;
	private String ThirdMonth;
	private String Sixthmonth;
	private String NinthMonth;
	private String OneYear;
	private String FromRange;
	public String getCurrencyGrid() {
		return CurrencyGrid;
	}
	public void setCurrencyGrid(String currencyGrid) {
		CurrencyGrid = currencyGrid;
	}
	public String getFristWeek() {
		return FristWeek;
	}
	public void setFristWeek(String fristWeek) {
		FristWeek = fristWeek;
	}
	public String getFirstMonth() {
		return FirstMonth;
	}
	public void setFirstMonth(String firstMonth) {
		FirstMonth = firstMonth;
	}
	public String getSecondMonth() {
		return SecondMonth;
	}
	public void setSecondMonth(String secondMonth) {
		SecondMonth = secondMonth;
	}
	public String getThirdMonth() {
		return ThirdMonth;
	}
	public void setThirdMonth(String thirdMonth) {
		ThirdMonth = thirdMonth;
	}
	public String getSixthmonth() {
		return Sixthmonth;
	}
	public void setSixthmonth(String sixthmonth) {
		Sixthmonth = sixthmonth;
	}
	public String getNinthMonth() {
		return NinthMonth;
	}
	public void setNinthMonth(String ninthMonth) {
		NinthMonth = ninthMonth;
	}
	public String getOneYear() {
		return OneYear;
	}
	public void setOneYear(String oneYear) {
		OneYear = oneYear;
	}
	public String getFromRange() {
		return FromRange;
	}
	public void setFromRange(String fromRange) {
		FromRange = fromRange;
	}
	@Override
	public String toString() {
		return "PDFEntity [CurrencyGrid=" + CurrencyGrid + ", FristWeek=" + FristWeek + ", FirstMonth=" + FirstMonth
				+ ", SecondMonth=" + SecondMonth + ", ThirdMonth=" + ThirdMonth + ", Sixthmonth=" + Sixthmonth
				+ ", NinthMonth=" + NinthMonth + ", OneYear=" + OneYear + ", FromRange=" + FromRange + "]";
	}
	public PDFEntity() {
		super();
	}
	

	
	
	
}

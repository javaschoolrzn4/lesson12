package ru.sbt.javaschool.step3.servers;

import java.io.Serializable;

public class Card implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	private  String  name  ;
	private  String  number;
	private  double  money ;
	
	public Card(String name, String number, double money)
	{
		super();
		this.name   = name;
		this.number = number;
		this.money  = money;
	}
	@Override
	public boolean equals(Object card)
	{
		Card crd = (Card)card;
		return this.getNumber().equals(crd.getNumber());
	}
}
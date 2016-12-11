package staff;

import restaurant.Chladnicka;
import restaurant.Sklad;

public class Skladnik 
{
	String meno;
	boolean busy = false;
	int id;
	Sklad s;
	Chladnicka f;
	
	public Skladnik()
	{
		
	}
	
	public Skladnik(String _meno, int _id, Sklad _s, Chladnicka _f)
	{
		this.meno = _meno;
		this.id = _id;
		this.s = _s;
		this.f = _f;
	}
	
	public void resupply(String surovina, int pocetS) //skladnik dostal za ulohu doplnit chybajucu surovinu - dostal tiez pocet skladnikov, ktori s nim budu pracovat
	{
		this.busy = true;
		carry(pocetS); //suroviny su balene vo velkom, cize doniest ich vyzaduje cas
		switch(surovina) //vyhodnoti sa potrebna surovina a doplni sa
		{
			case "beef":
				s.beef -= 5;				
				f.beef += 5;	
				break;
				
			case "fries":
				s.fries -= 2;
				f.fries += 2;
				break;
				
			case "salad":
				s.salad -= 1.5;
				f.salad += 1.5;
				break;
				
			case "chicken":
				s.chicken -= 5;
				f.chicken += 5;
				break;
		}
		System.out.println("Surovina " + surovina + " bola doplnena");
		this.busy = false;
	}
	
	public static void carry(int pocetSkladnikov)
	{
		try 
		{
			int time = 5000/(pocetSkladnikov*pocetSkladnikov); //kedze skladnici si naklad rovnomerne rozdelia, cim viac ich je, tym rychlejsie dokazu nosit suroviny
	   		Thread.sleep(time);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
	}
}

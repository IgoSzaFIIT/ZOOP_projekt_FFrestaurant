package staff;

import restaurant.Chladnicka;

public class Kuchar 
{
	String meno;
	int id;
	boolean busy = false;
	Chladnicka f;
	
	public Kuchar()
	{
		
	}
	
	public Kuchar(String _meno, int _id, Chladnicka _f)
	{
		this.meno = _meno;
		this.id = _id;
		this.f = _f;
	}
	
	public void prepare(int ID, int pocetK) //kuchar dostane za ulohu spracovat objednavku - dostal tiez pocet kucharov, ktori s nim budu pracovat
	{
		this.busy = true;
		switch(ID) //menu 1: hamburger s hranolkami, menu 2: kuraci salat, menu 3: chickenburger s hranolkami
		{
			case 1:
				f.beef -= 0.5/pocetK; //kedze sa na objednavke moze podielat viacero kucharov, robotu si rovnomerne rozdelia
				f.fries -= 0.2/pocetK;		
				break;
			case 2:
				f.salad -= 0.3/pocetK;
				f.chicken -= 0.5/pocetK;
				break;
			case 3:
				f.chicken -= 0.5/pocetK;
				f.fries -= 0.2/pocetK;				
				break;
		}
		cook(pocetK); //kuchar vstupi do samotneho procesu pripravy jedla
		this.busy = false;
	}
	public static void cook(int pocetKucharov)
	{
		try 
		{
			int time = 10000/(pocetKucharov*pocetKucharov); //kedze kuchari si pracu rovnomerne rozdelia, cim viac ich je, tym rychlejsie sa jedlo pripravi
	   		Thread.sleep(time);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
	}

}

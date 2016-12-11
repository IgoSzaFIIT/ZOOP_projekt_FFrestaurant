package staff;
import java.util.*;

import restaurant.Chladnicka;
import restaurant.Objednavka;

public class Manazer
{
	String meno;
	int id;
	Pokladnik michal; //agregacia objektov, ktore bude mat manazer na starosti
	Kuchar [] kuchari;
	Skladnik [] skladnici;
	Chladnicka f;
	
	public Manazer()
	{
		
	}
	
	public Manazer(String _meno, int _id, Pokladnik _michal, Skladnik [] _skladnici, Kuchar [] _kuchari, Chladnicka _f)
	{
		this.meno = _meno;
		this.id = _id;
		this.michal = _michal;
		this.skladnici = _skladnici;
		this.kuchari = _kuchari;	
		this.f = _f;
	}
	
	public void notifyManager(Objednavka _akt) //manazer bol notifikovany o aktuanej objednavke
	{
		List<Integer> volniKuchari = findNotBusyK(kuchari); //najdu sa nezaneprazdneni kuchari a skladnici
		List<Integer> volniSkladnici = findNotBusyS(skladnici);
		if(volniKuchari.isEmpty())
		{
			System.out.println("Bohuzial, vsetci kuchari su momentalne zaneprazdneni. Skuste neskor prosim.");
		}
		switch(_akt.menuID) //menu 1: hamburger s hranolkami, menu 2: kuraci salat, menu 3: chickenburger s hranolkami
		{
			case 1: //manazer vyhodnoti objednavku, pozrie sa do chladnicky a rozhodne, ci treba doplnit suroviny alebo nie
				if(f.beef < 0.5)
				{
					System.out.println("Nedostatok hovadzieho masa! Notifikujem skladnikov.");
					for(int i = 0; i<volniSkladnici.size(); i++)
					{
					skladnici[volniSkladnici.get(i)-1].resupply("beef", volniSkladnici.size());	
					}
				}
				if(f.fries < 0.2)	
				{
					System.out.println("Nedostatok hranoliek! Notifikujem skladnikov.");
					for(int i = 0; i<volniSkladnici.size(); i++)
					{
					skladnici[volniSkladnici.get(i)-1].resupply("fries", volniSkladnici.size());	
					}
				}
				for(int i = 0; i<volniKuchari.size(); i++) //manazer posle vsetkych volnych kucharov do prace na objednavke
				{
					kuchari[volniKuchari.get(i)-1].prepare(1, volniKuchari.size());
				}
				System.out.println("Menu 1 pripravene!"); //koniec objednavky
				break;
			case 2:
				if(f.chicken < 0.5)
				{
					System.out.println("Nedostatok kuracieho masa! Notifikujem skladnikov.");
					for(int i = 0; i<volniSkladnici.size(); i++)
					{
					skladnici[volniSkladnici.get(i)-1].resupply("chicken", volniSkladnici.size());	
					}
				}
				if(f.salad < 0.3)	
				{
					System.out.println("Nedostatok salatu! Notifikujem skladnikov.");
					for(int i = 0; i<volniSkladnici.size(); i++)
					{
					skladnici[volniSkladnici.get(i)-1].resupply("salad", volniSkladnici.size());	
					}
				}
				for(int i = 0; i<volniKuchari.size(); i++)
				{
					kuchari[volniKuchari.get(i)-1].prepare(2, volniKuchari.size());
				}
				System.out.println("Menu 2 pripravene!");
				break;
			case 3:		
				if(f.chicken < 0.5)
				{
					System.out.println("Nedostatok kuracieho masa! Notifikujem skladnikov.");
					for(int i = 0; i<volniSkladnici.size(); i++)
					{
					skladnici[volniSkladnici.get(i)-1].resupply("chicken", volniSkladnici.size());	
					}
				}
				if(f.fries < 0.2)	
				{
					System.out.println("Nedostatok hranoliek! Notifikujem skladnikov.");
					for(int i = 0; i<volniSkladnici.size(); i++)
					{
					skladnici[volniSkladnici.get(i)-1].resupply("fries", volniSkladnici.size());	
					}
				}
				for(int i = 0; i<volniKuchari.size(); i++)
				{
					kuchari[volniKuchari.get(i)-1].prepare(3, volniKuchari.size());
				}
				System.out.println("Menu 3 pripravene!");
				break;
		}
		volniKuchari.clear(); //resetuju sa polia volnych zamestnancov
		volniSkladnici.clear();
		michal.poke(); //manazer stuchne do pokladnika michala, co je signalom ze vsetky objednavky boli pripravene		
	}
	public static List<Integer> findNotBusyK(Kuchar[] pole) //funkcia zodpovedna za najdenie volnych kucharov
	{
		List<Integer> res = new ArrayList<Integer>(); //pricom vytvori novy list integerov, do ktoreho sa zapisu iba ID volnych kucharov
		for(int i = 0; i<pole.length; i++)
		{
			if(!pole[i].busy)
				res.add(pole[i].id);
		}
		return res;
	}
	public static List<Integer> findNotBusyS(Skladnik[] pole)
	{
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i<pole.length; i++)
		{
			if(!pole[i].busy)
				res.add(pole[i].id);
		}
		return res;
	}
}

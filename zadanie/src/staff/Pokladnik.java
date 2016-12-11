package staff;

import restaurant.Chladnicka;
import restaurant.Objednavka;

public class Pokladnik
{
	String meno;
	int id;
	SuperMozog b; //pokladnik ma specialny dar - svoj SuperMozog, ktory dokaze s presnostou na milisekundy ratat uplynuty cas
	boolean busy = false;
	
	public Pokladnik()
	{
		
	}
	
	public Pokladnik(String _meno, int _id)
	{
		this.meno = _meno;
		this.id = _id;
		this.b = new SuperMozog();
	}
	
	public void takeOrder(Objednavka _akt, Manazer _pavol, Chladnicka _f) //pokladnik prijme objednavku
	{
		if(_akt.sposobPlatby == 2) //1 pre hotovost, 2 pre kartu, 3 pre gastrolistky
			if(!M.platbaKartou)
				System.out.println("Bohuzial, platobny terminal je mimo prevadzky. Platit sa da iba v hotovosti.\n");
		b.startCount(); //vyuzije svoj mozog a zacne pocitat uplynuty cas, zatial co sa objednavka spracuje
		_pavol.notifyManager(_akt); //pokladnik da vediet manazerovi o aktualnej objednavke
	}
	
	public void poke() //stuchnutim do ramena pokladnik vie, ze objednavky boli uspesne spracovane
	{		
		System.out.println("Vasa objednavka bola pripravena za " + b.endCount()/1000 + "s, dobru chut!\n"); //vyuzije znovu svoj mozog na urcenie trvania pripravy objednavok
	}
}

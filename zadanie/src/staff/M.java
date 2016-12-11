package staff;

import java.util.Scanner;

import restaurant.Chladnicka;
import restaurant.Objednavka;
import restaurant.Sklad;

import java.util.*;

public class M 
{
	protected static final boolean platbaKartou = true; //urcuje, ci je mozne platit kartou
	private static final boolean platbaDefinovana = true; //mozte zmenit na false pre pripadne testovacie ucely - aby program neustale nepytal sposob platby
	protected final String menu1 = "menu1";
	protected final String menu2 = "menu2";
	protected final String menu3 = "menu3";
	protected final String platba1 = "hotovost";
	protected final String platba2 = "kartou";
	protected final String platba3 = "gastro";
	
	public static void main(String[] args) //hlavna funkcia
	{			
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobry den! Zadajte pozadovane menu prosim! Napiste \"zobrazit\" pre zobrazenie vsetkych menu.");
		boolean load = true;
		String volba = new String();
		List<Integer> zoznamObj = new ArrayList<Integer>();  //zoznam objednavok na spracovanie
		while(load) //nacitava, kym pouzivatel nezada prikaz "end"
		{
		  volba = sc.next();
		  if(volba.compareToIgnoreCase("zobrazit") == 0)
		  {
		    System.out.println("Menu 1: Hamburger s hranolkami. Volba: 1");
			System.out.println("Menu 2: Salat s kuskami kuracieho masa. Volba: 2");
			System.out.println("Menu 3: Chickenburger s hranolkami. Volba: 3");
			System.out.println("\nAk ste si vybrali, zadajte prosim vasu volbu!");
			volba = sc.nextLine();
		  }
		  else if(volba.compareToIgnoreCase("end") == 0)
		  {
			  load = false;
			  continue;
		  }
		  else
		  {
			  if(isInteger(volba)) //ak sa jedna o validnu objednavku, prida sa do zoznamu objednavok
			  {
			    int obj = Integer.parseInt(volba);
			    if((obj < 1) || (obj > 3))
			    {
			    	System.out.println("Chyba! Nespravny znak na vstupe! Zadajte 1, 2, 3 alebo \"end\" pre ukoncenie vstupu");
			    	continue;
			    }
			    zoznamObj.add(obj);
			  }
			  else
			  {
				System.out.println("Chyba! Nespravny znak na vstupe! Zadajte 1, 2, 3 alebo \"end\" pre ukoncenie vstupu");
				continue;
			  }
		  }
		}
		
		System.out.println("Zadajte pocet kucharov, ktorych ma restauracia zamestnat.");	
		int pocetK = sc.nextInt();
		System.out.println("Zadajte pocet skladnikov, ktorych ma restauracia zamestnat.");	
		int pocetS = sc.nextInt();
		
		String platba;
		if(platbaDefinovana) //ak ma  byt specifikovany sposob platby, program si ho vypyta
		{
		  System.out.println("Ako si prajete zaplatit?");
		  platba = sc.next();
		}
		else
		  platba = "hotovost"; //inak ho defaultne nastavi na hotovost
		
		if((pocetK <= 0) || (pocetS <= 0) || (zoznamObj.size() == 0))
		{
			System.out.println("Chyba! Pocet kucharov, skladnikov a objednavok musi byt vacsi ako 0. Ukoncujem program.");
			sc.close();
			return;
		}
		
		Sklad s = new Sklad(50, 20, 10, 50); //vytvori sa sklad a chladnicka so specifickym poctom surovin
		Chladnicka f = new Chladnicka(10, 10, 10, 10); 
		Pokladnik michal = new Pokladnik("michal", 1);		
		
		Kuchar [] kuchari = new Kuchar[pocetK]; //vytvoria sa timy kucharov a skladnikov, podla zadaneho parametra o ich pozadovanom pocte
		for(int i = 0; i<pocetK; i++)
			kuchari[i] = new Kuchar("kuchar" + (i+1), (i+1), f);
		Skladnik [] skladnici = new Skladnik[pocetS];
		for(int i = 0; i<pocetS; i++)
			skladnici[i] = new Skladnik("skladnik" + (i+1), (i+1), s, f);
		
		Manazer pavol = new Manazer("pavol", 1, michal, skladnici, kuchari, f);		
		Objednavka akt;
		
		for(int i = 0; i<zoznamObj.size(); i++) //cyklus zodpovedny za spracovanie nacitanych objednavok
		{
		  switch(zoznamObj.get(i))
		  {
		    case 1: 
		      akt = new Objednavka(1, platba);
		      michal.takeOrder(akt, pavol, f);	//objednavky sa podla cisla posielaju pokladnikovi michalovi na spracovanie
		      break;
		    case 2:
		      akt = new Objednavka(2, platba);
			  michal.takeOrder(akt, pavol, f);	
		      break;
		    case 3:
		      akt = new Objednavka(3, platba);
			  michal.takeOrder(akt, pavol, f);	
		      break;
		  }		  
		}
		System.out.println("Vsetky objednavky boli spracovane! Ukoncujem program.");
		sc.close();
		return; //koniec programu po uspesnom spracovani objdnavok
	}
	public static boolean isInteger(String x) //zisti, ci retazec zo vstupu je integer
	{
	    try
	    {
	         Integer.parseInt(x);
	         return true;
	    }
	    catch (NumberFormatException ex)
	    {
	    }
	    return false;
	}
}

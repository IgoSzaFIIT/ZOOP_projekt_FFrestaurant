package restaurant;

import staff.M;

public class Objednavka extends M
{
	public int sposobPlatby;
	public int menuID; //menu 1: hamburger s hranolkami, menu 2: kuraci salat, menu 3: chickenburger s hranolkami
	
	public Objednavka()
	{
		
	}
	
	public Objednavka(int _volba, String _platba) //tu sa vytvori nova objednavka
	{
		switch(_volba) //a priradi sa jej ID podla volby
		{
		  case 1:
			this.menuID = 1; 
		    break;
		  case 2:
		    this.menuID = 2;
		    break;
		  case 3:
		    this.menuID = 3;
		    break;
		}
		
		if(_platba.compareToIgnoreCase(platba1) == 0) //priradi sa jej aj sposob platby
		{
			this.sposobPlatby = 1;
		}
		else if(_platba.compareToIgnoreCase(platba2) == 0)
		{
			this.sposobPlatby = 2;
		}
		else if(_platba.compareToIgnoreCase(platba3) == 0)
		{
			this.sposobPlatby = 3;
		}	
		
	}
}

package restaurant;

public class Sklad //ma vacsiu kapacitu ako chladnicka
{
	public double beef;
	public double fries;
	public double salad;
	public double chicken;
	
	public Sklad()
	{
		
	}
	
	public Sklad(double _beef, double _fries, double _salad, double _chicken)
	{
		if(_beef>50)
	      this.beef = 50;
		else if(_beef<0)
		  this.beef = 0;
		else
	      this.beef = _beef;
			
		if(_fries>50)
		  this.fries = 50;
		else if(_fries<0)
		  this.fries = 0;
		else
		  this.fries = _fries;
			
		if(_salad>50)
		  this.salad = 50;
		else if(_salad<0)
		  this.salad = 0;
		else
		  this.salad = _salad;
			
		if(_chicken>50)
		  this.chicken = 50;
		else if(_chicken<0)
		  this.chicken = 0;
		else
		  this.chicken = _chicken;
	}
}

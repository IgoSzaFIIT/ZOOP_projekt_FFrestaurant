package restaurant;

public class Chladnicka //oproti skladu ma len limitovanu kapacitu
{
	public double beef;
	public double fries;
	public double salad;
	public double chicken;
	
	public Chladnicka()
	{
		
	}
	
	public Chladnicka(double _beef, double _fries, double _salad, double _chicken)
	{
		if(_beef>10)
		  this.beef = 10;
		else if(_beef<0)
		  this.beef = 0;
		else
		  this.beef = _beef;
		
		if(_fries>10)
		  this.fries = 10;
		else if(_fries<0)
		  this.fries = 0;
		else
		  this.fries = _fries;
		
		if(_salad>10)
		  this.salad = 10;
		else if(_salad<0)
		  this.salad = 0;
		else
		  this.salad = _salad;
		
		if(_chicken>10)
		  this.chicken = 10;
		else if(_chicken<0)
		  this.chicken = 0;
		else
		  this.chicken = _chicken;
	}
}

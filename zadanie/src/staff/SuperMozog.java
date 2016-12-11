package staff;

public class SuperMozog //velmi vykonny mozog - kazdy kto ho vlastni, ziska velke nadanie predovsetkym v matematike
{
  double startTime;
  double endTime;
	
  public SuperMozog()
  {
	  
  }
  
  public void startCount() //mozog zacne pocitat cas
  {
	  startTime = System.currentTimeMillis();
  }
  public double endCount() //mozog ukonci pocitanie casu a vyhodnoti uplynuty cas
  {
	  endTime = System.currentTimeMillis();
	  return (endTime - startTime);
  }
  
}

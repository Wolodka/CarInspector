package carinspectorlib.entities;

public class Car 
{
	String _name;
	int _yearCreated;
	
	public Car(String name, int yearCreated)
	{
		_name = name;
		_yearCreated =  yearCreated;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public int getYearCreated()
	{
		return _yearCreated;
	}
}

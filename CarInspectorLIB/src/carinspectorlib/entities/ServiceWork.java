package carinspectorlib.entities;

public class ServiceWork 
{
	private int _id;
	private String _name;
	
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public int getID()
	{
		return _id;
	}
	
	public void setID(int id)
	{
		_id = id;
	}
	
	public ServiceWork()
	{}
	
	@Override
	public String toString()
	{
		return _id + " " + _name;
	}

}

package carinspectorlib.model;

import java.util.ArrayList;

import carinspectorlib.entities.Car;
import carinspectorlib.entities.ServiceWork;

public class CarManager 
{
	Car _car;
	ArrayList<ServiceWork> _serviceWorks;

	public CarManager(Car car, ArrayList<ServiceWork> serviceWorks)
	{
		_car = car;
		_serviceWorks = serviceWorks;
	}
	
	public Car getCar()
	{
		return _car;
	}
	
	public ArrayList<ServiceWork> getServiceWorks()
	{
		return _serviceWorks;
	}
	
	public static CarManager GetTestCarManager()
	{
		ArrayList<ServiceWork> works = new ArrayList<ServiceWork>();
		ServiceWork zamenaMasla = new ServiceWork();
		zamenaMasla.setID(1);
		zamenaMasla.setName("Замена масла");
		works.add(zamenaMasla);
		
		ServiceWork adaptationEasyTronic = new ServiceWork();
		adaptationEasyTronic.setID(2);
		adaptationEasyTronic.setName("Адаптация коробки передач");
		works.add(adaptationEasyTronic);
		
		ServiceWork zamenaLampochki = new ServiceWork();
		zamenaLampochki.setID(3);
		zamenaLampochki.setName("Замена лампочки");
		works.add(zamenaLampochki);
		
		Car car = new Car("Honda Civic", 2009);
		
		return new CarManager(car, works);
		
	}
}

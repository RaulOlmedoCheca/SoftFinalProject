package hdss.data;

public class PlantInternalData {
	private String name;
	private double maxCapacity;
	private double currentCapacity;
	public String getName()
	{
		return name;
	}
	
	public void setName (String value)
	{
		this.name = value;
	}
	
	public void setMaxCapacity (double value)
	{
		this.maxCapacity = value;
	}
	
	public double getCurrentCapacity() {
		return currentCapacity;
	}
	
	public double getMaxCapacity() {
		return maxCapacity;
	}
	
	public void setCurrentCapacity (double value)
	{
		this.currentCapacity = value;
	}
	
	// Esfuerzo : 5 minutos

	public PlantInternalData (String newName, double newMaxCapacity)
	{
		this.name = newName;
		this.maxCapacity = newMaxCapacity;
		this.currentCapacity = 0.0f;
	}
}

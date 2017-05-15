package hdss.data;

public class AquiferInternalData {
	private String name;
	private double currentLevel;
	public String getName()
	{
		return this.name;
	}
	
	public double getCurrentLevel()
	{
		return this.currentLevel;
	}

	public void setCurrentLevel (double value)
	{
		this.currentLevel = value;
	}
	
	public AquiferInternalData (String newName)
	{
		this.name = newName;
		this.currentLevel = 0.0f;
	}
}

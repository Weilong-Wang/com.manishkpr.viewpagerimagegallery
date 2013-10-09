package com.manishkpr.viewpagerimagegallery;

public class CartridgeType
{
	private int id;
	private String name;
	private String description;
	private String partNumber;
	private String coilType;
	private String coilMaterial;
	private double coilMeanDiameter;
	private double coilPitch;
	private double coilGauge;
	private double coilLength;
	private String coilInterfaceType;
	private int maxItems;
	private int maxInsertions;
	
	public CartridgeType(int id, String name)
	{
		this.id = id;
		this.setName(name);
		System.out.println("Cartridge id: " + id + ", name: " + name);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getPartNumber()
	{
		return partNumber;
	}

	public void setPartNumber(String partNumber)
	{
		this.partNumber = partNumber;
	}

	public String getCoilType()
	{
		return coilType;
	}

	public void setCoilType(String coilType)
	{
		this.coilType = coilType;
	}

	public String getCoilMaterial()
	{
		return coilMaterial;
	}

	public void setCoilMaterial(String coilMaterial)
	{
		this.coilMaterial = coilMaterial;
	}

	public double getCoilMeanDiameter()
	{
		return coilMeanDiameter;
	}

	public void setCoilMeanDiameter(double coilMeanDiameter)
	{
		this.coilMeanDiameter = coilMeanDiameter;
	}

	public double getCoilPitch()
	{
		return coilPitch;
	}

	public void setCoilPitch(double coilPitch)
	{
		this.coilPitch = coilPitch;
	}

	public double getCoilGauge()
	{
		return coilGauge;
	}

	public void setCoilGauge(double coilGauge)
	{
		this.coilGauge = coilGauge;
	}

	public double getCoilLength()
	{
		return coilLength;
	}

	public void setCoilLength(double coilLength)
	{
		this.coilLength = coilLength;
	}

	public String getCoilInterfaceType()
	{
		return coilInterfaceType;
	}

	public void setCoilInterfaceType(String coilInterfaceType)
	{
		this.coilInterfaceType = coilInterfaceType;
	}

	public int getMaxItems()
	{
		return maxItems;
	}

	public void setMaxItems(int maxItems)
	{
		this.maxItems = maxItems;
	}

	public int getMaxInsertions()
	{
		return maxInsertions;
	}

	public void setMaxInsertions(int maxInsertions)
	{
		this.maxInsertions = maxInsertions;
	}

	@Override
	public String toString()
	{
		return name;
	}
	
	
}

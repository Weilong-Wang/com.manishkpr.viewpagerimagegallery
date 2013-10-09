package com.manishkpr.viewpagerimagegallery;

public class Product {



	int imageId; 
	private int pid;
	String name;
	private double price;
	private String filename;
	private String description;
	int maxQuantity;
	private String selectionImageURL;
	private String adImageURL;
	private String popupImageURL;
	private boolean over21;
	
	
	
	public String getProductname()
	{
		return this.name;
	}
	
	/**
	 * Initalize the product object with the name, filename, and description
	 * @param String name
	 * @param double price
	 * @param String filename
	 * @param String description
	 */
	
	public Product()
	{
		
	}
	
	public Product(String name, int maxQuantity)
	{
		this.name=name;
		this.maxQuantity=maxQuantity;
		if(name.equalsIgnoreCase("aquaphor"))
		this.imageId=R.drawable.aquaphor;
		else if(name.equalsIgnoreCase("aveeno"))
			this.imageId=R.drawable.aveeno;
		else if(name.equalsIgnoreCase("billyboy"))
			this.imageId=R.drawable.billyboy;
		else this.imageId=R.drawable.ic_launcher;
		
	}
	
	
	public Product(String name, double price, String filename, String description)
	{
		this.setName(name);
		this.setPrice(price);
		this.setFilename(filename);
		this.setDescription(description);
	}
	
	public Product(String name, double price, String filename, boolean over21)
	{
		this.setName(name);
		this.setPrice(price);
		this.setFilename(filename);
		this.setOver21(over21);
	}
	
	/**
	 * Initalize the product object with the pid, name, price, filename, and description
	 * @param int pid
	 * @param String name
	 * @param double price
	 * @param String filename
	 * @param String description
	 */
	public Product(int pid, String name, double price, String filename, String description)
	{
		this.setPid(pid);
		this.setName(name);
		this.setPrice(price);
		this.setFilename(filename);
		this.setDescription(description);
	}
	
	public Product(int pid, String name, double price, String filename, String description, int quantity)
	{
		this.setPid(pid);
		this.setName(name);
		this.setPrice(price);
		this.setFilename(filename);
		this.setDescription(description);
		this.setMaxQuantity(quantity);
	}
	
	public Product(int pid, String name, double price, String filename, String description, int quantity, 
			String selectImage, String adImage, String popupImage, boolean over21)
	{
		this.setPid(pid);
		this.setName(name);
		this.setPrice(price);
		this.setFilename(filename);
		this.setDescription(description);
		this.setMaxQuantity(quantity);
		this.setSelectionImageURL(selectImage);
		this.setAdImageURL(adImage);
		this.setPopupImageURL(popupImage);
		this.setOver21(over21);
	}

	/**
	 * Get the product pid
	 * @return pid
	 */
	public int getPid()
	{
		return pid;
	}

	/**
	 * Set the product pid
	 * @param int pid
	 */
	public void setPid(int pid)
	{
		this.pid = pid;
	}

	/**
	 * Get the product name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set the product name
	 * @param String name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Get the product price
	 * @return price
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * Set the product price
	 * @param price
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

	/**
	 * Get the product image filename
	 * @return filename
	 */
	public String getFilename()
	{
		return filename;
	}

	/**
	 * Set the product image filename
	 * @param filename
	 */
	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	/**
	 * Get the product description
	 * @return description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Set the product description
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getMaxQuantity()
	{
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity)
	{
		this.maxQuantity = maxQuantity;
	}

	@Override
	public String toString()
	{
		return name;
	}

	public String getSelectionImageURL()
	{
		return selectionImageURL;
	}

	public void setSelectionImageURL(String selectionImageURL)
	{
		this.selectionImageURL = selectionImageURL;
	}

	public String getAdImageURL()
	{
		return adImageURL;
	}

	public void setAdImageURL(String adImageURL)
	{
		this.adImageURL = adImageURL;
	}

	public String getPopupImageURL()
	{
		return popupImageURL;
	}

	public void setPopupImageURL(String popupImageURL)
	{
		this.popupImageURL = popupImageURL;
	}

	public boolean isOver21()
	{
		return over21;
	}

	public void setOver21(boolean over21)
	{
		this.over21 = over21;
	}
	
	public boolean getOver21()
	{
		return this.over21;
	}

	
}

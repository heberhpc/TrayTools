package domain;
/**This class represents a product inside Tray Ecommerce*/

public class Product{

	//INSTANCE VARIABLES

	//The unique ID of the Product inside Tray System
	private int ProductID;

	//Product Name
	private String ProductName;

	//Product Full HTML Descrition
	private String ProductFullDescrciption;

	//
	public Product (int pID, String pName, String pDesc){
		this.ProductID = pID;
		this.ProductName = pName;
		this.ProductFullDescrciption = pDesc;
	}

	//get for Product ID
	public int getID(){
		return this.ProductID;
	}

	//get for Product Name
	public String getName(){
		return this.ProductName;
	}

	//set Product Name
	public void setName(String n){
		this.ProductName = n;
	}

	//get for HTML Description
	public String getProductFullDescrciption(){
		return this.ProductFullDescrciption;
	}

	//set for ProductFullDescrciption
	public void setProductFullDescrciption(String d){
		this.ProductFullDescrciption = d;
	}
}
package com.example.drag;

public class User {
	
	String ID;
	String Name;
	String Email;
	String Mob;
	String Pass;
	
	
	public User()
	{
		this.ID = null;
		this.Name = null;
		this.Email = null;
		this.Mob = null;
		this.Pass = null;
	}
	
	public User(String ID,String Name,String Email,String Mob,String Pass)
	{
		this.ID = ID;
		this.Name = Name;
		this.Email = Email;
		this.Mob = Mob;
		this.Pass = Pass;
	}
	
	public void setID(String ID)
	{
		this.ID = ID;
	}
	
	public void setName(String Name)
	{
		this.Name = Name;
	}
	
	public void setEmail(String Email)
	{
		this.Email = Email;
	}
	
	public void setMob(String Mob)
	{
		this.Mob = Mob;
	}
	
	public void setPass(String Pass)
	{
		this.Pass = Pass;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String getEmail()
	{
		return Email;
	}
	
	public String getMob()
	{
		return Mob;
	}
	
	public String getPass()
	{
		return Pass;
	}
}

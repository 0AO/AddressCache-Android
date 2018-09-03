

import java.lang.reflect.*;
import java.net.*;


//github:BlackSwordman

public class AddressCache
{
	private Object obj;
	private Class<? extends Object> AddressCache1;
	private Method get;
	private Method put;
	private Method putUnknownHost;
	private Method clear;
	
	public InetAddress[] get(String hostname) throws InvocationTargetException, IllegalAccessException, IllegalArgumentException {
	Class<?>[] ParameterTypes=get.getParameterTypes();
	if(ParameterTypes.length==1)return (InetAddress[])get.invoke(obj,hostname);
	else
	return (InetAddress[])get.invoke(obj,hostname,0);
	}

	public void put(String hostname, InetAddress[] addresses) throws InvocationTargetException, IllegalAccessException, IllegalArgumentException
	{
	Class<?>[] ParameterTypes=put.getParameterTypes();
	if(ParameterTypes.length==2)
	put.invoke(obj,hostname,addresses);
	else
	put.invoke(obj,hostname,0,addresses);
	}

	public void putUnknownHost(String hostname, String detailMessage) throws InvocationTargetException, IllegalAccessException, IllegalArgumentException
	{
	Class<?>[] ParameterTypes=putUnknownHost.getParameterTypes();
    if(ParameterTypes.length==2)
	putUnknownHost.invoke(obj,hostname,detailMessage);
	else
	putUnknownHost.invoke(obj,hostname,0,detailMessage);
	}
	

  public AddressCache() throws ClassNotFoundException, NoSuchFieldException
  {
	Field AddressCacheField = null;
	try
	{AddressCacheField = InetAddress.class.getDeclaredField("addressCache");
	}catch (NoSuchFieldException e){}
	if (AddressCacheField == null)
	AddressCacheField = Class.forName("java.net.Inet6AddressImpl").getDeclaredField("addressCache");
	AddressCacheField.setAccessible(true);
	try{
	obj = AddressCacheField.get(null);
	}catch (Exception e){}
	AddressCache1 = obj.getClass();
	Method[] Method1=AddressCache1.getDeclaredMethods();
	for (Method i:Method1)
	{
	if(i.getName().equals("get"))
	get=i;
	else if(i.getName().equals("put"))
	put=i;
	else if(i.getName().equals("putUnknownHost"))
	putUnknownHost=i;
	else if(i.getName().equals("clear"))
	clear=i;
}}

}

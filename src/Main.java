import java.util.*;
import java.net.*;

//github:BlackSwordman

public class Main
{
	public static void main(String[] args)
	{
	try
	{
	InetAddress.getAllByName("www.Google.com");
	AddressCache ac=new AddressCache();
	InetAddress[] ip=ac.get("www.Google.com");
	ip[0]=InetAddress.getAllByName("127.0.0.1")[0];
	InetAddress[] i=InetAddress.getAllByName("www.Google.com");
	for (InetAddress i1:i)
	System.out.println(i1.toString());
	}
	catch (Exception e)
	{e.printStackTrace();}
	}
}

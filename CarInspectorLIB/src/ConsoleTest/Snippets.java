package ConsoleTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import carinspectorlib.entities.ServiceWork;

public class Snippets 
{

	public void WriteFile()
	{
		String filePath = "c:\\test\\java_test.txt";
		String encoding = "UTF-8";
		
		try
		{
			PrintWriter writer = new PrintWriter(filePath, encoding);
			writer.println("the first string");
			writer.println("the second string");
			writer.println("the first string");
			writer.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("did not find file with the path: " + filePath);
		}
		catch(UnsupportedEncodingException e)
		{
			System.out.println("do not support encoding: " + encoding);
		}
		
	}

	public void ReadXmlFile()
	{
		String id = null;
		String name = null;
		ArrayList<ServiceWork> serviceWorks;
		
		String xmlPath = "c:\\test\\java_xml.xml";
		
		serviceWorks = new ArrayList<ServiceWork>();
		Document dom;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder db = dbf.newDocumentBuilder(); 
			dom = db.parse(xmlPath);
			Element doc = dom.getDocumentElement();
			
			NodeList worksNodeList = doc.getElementsByTagName("work");
			for(int i = 0; i < worksNodeList.getLength(); i++ )
			{
				if(worksNodeList.item(i).hasChildNodes())
				{
					ServiceWork work = new ServiceWork();
					NodeList workAttrs = worksNodeList.item(i).getChildNodes();
					id = GetNodeValue(workAttrs, "id");
					name = GetNodeValue(workAttrs, "name");

					work.setID(Integer.parseInt(id));
					work.setName(name);
					
					serviceWorks.add(work);
				}
			}
			
		}
		catch(ParserConfigurationException pce)
		{
			System.out.println(pce.getMessage());
		}
		catch(SAXException se)
		{
			System.out.println(se.getMessage());
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
		
		for(ServiceWork work: serviceWorks)
			System.out.println(work);
		
	}
	
	private String GetNodeValue(NodeList nodes, String nodeName)
	{
		for( int i = 0; i < nodes.getLength(); i++ )
		{
			if(nodes.item(i).hasChildNodes() 
					&& nodes.item(i).getNodeName()==nodeName)
				return nodes.item(i).getFirstChild().getNodeValue();
		}
		
		return "";
	}

}

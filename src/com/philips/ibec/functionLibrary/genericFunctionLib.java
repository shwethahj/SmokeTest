package com.philips.ibec.functionLibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.*;
import org.xml.sax.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.NoValidation;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This library function contains the generic method
 */

public class genericFunctionLib {

	/**
	 * This function is used to get file content example HL7 message and JSON
	 * messages
	 * 
	 * @param fileFullPath- Mention full file path of input message from inputdata
	 *        folder
	 * @return Returns the message from the specified file
	 * @throws IOException
	 */

	public static String getFileContent(String fileFullPath) throws IOException

	{
		String result;
		BufferedReader br = new BufferedReader(new FileReader(fileFullPath));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}

			result = sb.toString();
		} finally {
			br.close();
		}
		return result;
	}

	/**
	 * This function is used to get the Element value from XML file
	 * 
	 * @param Filename - Pass the full file path of XML file
	 * @param Node     - Enter the parent node
	 * @param Tag      - Enter Tag name to fetch the value of tag
	 * @param i        - Occurrence of the tag in entire XML
	 * @return Returns the value of the element from XML file
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */

	public static String XMLValue(String Filename, String Node, String Tag, int i)
			throws ParserConfigurationException, SAXException, IOException {
		String value;
		File inputFile = new File(Filename);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(Node);
		Node nNode = nList.item(0);
		if (i == 0) {

			Element eElement = (Element) nNode;
			if (eElement.getElementsByTagName(Tag).item(0) == null) {
				return "false";
			} else {
				value = eElement.getElementsByTagName(Tag).item(0).getTextContent();
				return value;
			}

		} else {
			Element eElement = (Element) nNode;
			if (eElement.getElementsByTagName(Tag).item(i) == null) {
				return "false";
			} else {
				value = eElement.getElementsByTagName(Tag).item(i).getTextContent();
				return value;
			}

		}

	}

	/**
	 * This function returns system time in HH:MM format
	 * 
	 * @return Returns system time in HH:MM format
	 */

	public static String Systemtime() {

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HH:mm");
		String time = format.format(date);
		// System.out.println(format.format(date));

		return time;

	}

	/**
	 * This function returns system Date in DD-MM-YYYY format
	 * 
	 * @return -Returns system Date in DD-MM-YYYY format
	 */
	public static String Date() {

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("d-M-Y");
		return format.format(date);

	}

	public static String SplitXML(String filename, String Tags, String DEST) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException, TransformerException {
		String Result = "false";

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(filename);
		TransformerFactory tranFactory = TransformerFactory.newInstance();
		Transformer aTransformer = tranFactory.newTransformer();
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList list = (NodeList) xpath.evaluate(Tags, doc, XPathConstants.NODESET);
		for (int i = 0; i < list.getLength(); i++) {
			Node element = list.item(i).cloneNode(true);
			if (element.hasChildNodes()) {
				Source src = new DOMSource(element);
				FileOutputStream fs = new FileOutputStream(DEST + i + ".xml");
				Result dest = new StreamResult(fs);
				aTransformer.transform(src, dest);
				fs.close();
				Result = "true";
			}
		}
		return Result;
	}
	
	

	
	/*
	public static String getSpecificFHIRResource(String fileFullPath, String FHIRResourceName) throws ParserConfigurationException, SAXException, IOException
    {
          String FHIRResourceFileName = null;     
          File folder = new File(fileFullPath);
          File[] listOfFiles = folder.listFiles();
          System.out.println("listOfFiles:"+listOfFiles.length);
             if (listOfFiles.length==0)
               {
               return("0");  
            }
          else
            {
               for (int i = 0; i < listOfFiles.length; i++) 
                   {
                    
                    DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(listOfFiles[i]);
                    doc.getDocumentElement().normalize();
                    Element root = doc.getDocumentElement();
                    NodeList nList = doc.getElementsByTagName("fullUrl");

                    Node nNode = nList.item(0);
                    String value = nNode.getAttributes().getNamedItem("value").getNodeValue();
                    //if (value.startsWith(FHIRResourceName)) {
                    if (value.contains(FHIRResourceName)) {
                    	FHIRResourceFileName = listOfFiles[i].getAbsolutePath();
                    }
                   }
            }
			return FHIRResourceFileName;
		
    }*/
	
	public static String getSpecificFHIRResource(String fileFullPath, String FHIRResourceName)
	{
	      File FHIRResourceFileName = null;	
	      File folder = new File(fileFullPath);
	      File[] listOfFiles = folder.listFiles();
		  if (listOfFiles.length==0)
		    {
	           return("0");  
	        }
	      else
	        {
	           for (int i = 0; i < listOfFiles.length; i++) 
		        {
	                if (listOfFiles[i].isFile()) 
			        {			
	                  File file = new File(fileFullPath+ "\\" +listOfFiles[i].getName());
	                  try 
	                    {
						   Scanner scanner = new Scanner(file);				
					        int lineNum = 0;
					        while (scanner.hasNextLine()) 
						    {
						        String line = scanner.nextLine();
								line = line.replaceAll("&lt;","<");
								line = line.replaceAll("&gt;",">");								
						        if(line.contains(FHIRResourceName)) 
						        { 
							       FHIRResourceFileName = file;
							       scanner.close();
							       return FHIRResourceFileName.getAbsolutePath();
                                   
						        }
						        else
						        {
						        	lineNum++;
						        }
								
					        }   
				        } 
				        catch(FileNotFoundException e) 
				        { 
				        	return "0";
				        }
			        }
			    }
	          return ("1");
		    }
	}

	
      	public static String XMLAttributeValue(String Filename,String Node,String Tag,String Attribute,int i) throws ParserConfigurationException, SAXException, IOException
	{
	              String value;
	       File inputFile = new File(Filename);
	DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(inputFile);
	doc.getDocumentElement().normalize();
	//Element root = doc.getDocumentElement();

	NodeList nList = doc.getElementsByTagName(Node);

	       Node nNode = nList.item(i);
	       if(i==0)
	       {
	                                  
	                                  Element eElement = (Element) nNode;
	                                  value = eElement.getElementsByTagName(Tag).item(0).getAttributes().getNamedItem("value").getNodeValue();
	                                  return (String) value;
	       }
	       else
	       {
	                           Element eElement = (Element) nNode;
	                           value = eElement.getElementsByTagName(Tag).item(0).getAttributes().getNamedItem("value").getNodeValue();
	                           return (String) value;
	                           
	       }
	       
	       
	    }

	public static String getHL7FieldValue(String hL7Path, String fieldName)
            throws IOException, EncodingNotSupportedException, HL7Exception {

     String fieldValue = null;

     String strHL7 = new String(Files.readAllBytes(Paths.get(hL7Path)));

     PipeParser pipeParser = new PipeParser();
     pipeParser.setValidationContext(new NoValidation());

     Message message = pipeParser.parse(strHL7);

     Terser terser = new Terser(message);
     fieldValue = terser.get(fieldName);

     return fieldValue;
}
	
	 public static String getFormatDate(String dateField)
		{
			String strDate;
			strDate = dateField;
			
			String Year = strDate.substring(0, 4);

			String month = strDate.substring(4, 6);

			String DATE = strDate.substring(6, 8);

			String formattedDate = Year+"-"+month+"-"+DATE;
			return formattedDate;
		}
	 
	public static  void cleanDirectory(String fileFullPath) throws IOException
     {
	    File folder = new File(fileFullPath);
        FileUtils.cleanDirectory(folder);
     }  
	 
	public static String getFormattedDate(String dateTimeField)
	{
		String strDate;
		strDate = dateTimeField;
		
		String Year = strDate.substring(0, 4);

		String month = strDate.substring(4, 6);

		String DATE = strDate.substring(6, 8);
		String hour = strDate.substring(8, 10);
		String minutes = strDate.substring(10, 12);
		String seconds = strDate.substring(12, 14);
		String Millseconds= strDate.substring(14, 18);
		String offset1= strDate.substring(18, 21);
		String offset2= strDate.substring(21, 23);

		String formattedDate = Year+"-"+month+"-"+DATE+"T"+hour+":"+minutes+":"+seconds+Millseconds+offset1+":"+offset2;
		return formattedDate;
	}
	
}
    

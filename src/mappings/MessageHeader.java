package mappings;

import java.io.IOException;
import com.philips.ibec.functionLibrary.genericFunctionLib;
import ca.uhn.hl7v2.HL7Exception;

public class MessageHeader {
	
	private static String MSH9_2hl7;
	private static String MSH3hl7;
	private static String MSH4hl7;
	private static String MSH5hl7;
	private static String MSH6hl7;
	private static String MSH10hl7;
	
	private static String eventCoding;
	private static String destinationname;
	private static String destinationendpoint;
	private static String sourcename;
	private static String sourceendpoint;
	private static String responseid;
	

	public static boolean messageHeaderMapping(String practitionerFHIRXMLFileName, String hl7filepath) {
	
			hl7values(hl7filepath);
			xmlvalues(practitionerFHIRXMLFileName);
			
			assert (MSH9_2hl7.equals(eventCoding)) : "Test Failed";
			assert (MSH5hl7.equals(destinationname)) : "Test Failed";
			assert (MSH6hl7.equals(destinationendpoint)) : "Test Failed";
			assert (MSH3hl7.equals(sourcename)) : "Test Failed";
			assert (MSH4hl7.equals(sourceendpoint)) : "Test Failed";
			assert (MSH10hl7.equals(responseid)) : "Test Failed";

		return true;

	}
	
	public static void hl7values(String hl7filepath)  {
		
		try {
			MSH9_2hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.MSH-9-2");
			MSH3hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.MSH-3");
			 MSH4hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.MSH-4");
			 MSH5hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.MSH-5");
			 MSH6hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.MSH-6");
			 MSH10hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.MSH-10");

		} catch (HL7Exception | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void xmlvalues(String practitionerFHIRXMLFileName) {
		 try {
			eventCoding = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "eventCoding",
					"code", "value", 0);
			destinationname = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "destination",
					"name", "value", 0);
			 destinationendpoint = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName,
					"destination", "endpoint", "value", 0);
			 sourcename = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "source", "name",
					"value", 0);
			 sourceendpoint = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "source",
					"endpoint", "value", 0);
			 responseid = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "response",
					"identifier", "value", 0);
		} catch (Exception e) {
		
			System.out.println(e);;
		}
	}

}

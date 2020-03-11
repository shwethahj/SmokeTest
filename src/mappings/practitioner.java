package mappings;


import java.util.HashMap;
import java.util.Map;
import com.philips.ibec.functionLibrary.RestAPI_Calls;
import com.philips.ibec.functionLibrary.genericFunctionLib;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;

public class practitioner {
	
	private static String STF2_1hl7;
	private static String STF3_1hl7;
	private static String STF3_2hl7;
	private static String STF3_5hl7;
	private static String STF11_1hl7;
	private static String STF11_3hl7;
	private static String STF11_4hl7;
	private static String STF11_5hl7;
	private static String STF11_6hl7;
	private static String STF2_11_1hl7;
	private static String STF2_11_3hl7;
	private static String STF2_11_4hl7;
	private static String STF2_11_6hl7;
	private static String STF6hl7;
	private static String stf6hl7;
	private static String EDU2;
	private static String LAN2;
	private static String birthDate;
	private static String identifier;
	private static String familyname;
	private static String givenname;
	private static String prefix;
	private static String addressline;
	private static String city;
	private static String state;
	private static String postalcode;
	private static String country;
	private static String addressline1;
	private static String city1;
	private static String state1;
	private static String country1;
	private static String qualificationcode;
	private static String qualificationdisplay;
	private static String qualificationsystem;
	private static String communicationcode;
	private static String communicationdisplay;
	private static String communicationsystem;
	private static Map<String, String> valuesmapLocal = new HashMap<String, String>();
	private static String[] FieldNames;
	private static String[] Texttobelooked;

	public static boolean practitionerMapping(String practitionerFHIRXMLFileName, String hl7filepath) {
			
		hl7values(hl7filepath);
		xmlvalues(practitionerFHIRXMLFileName);
		lookupValues();

		assert (STF2_1hl7.equals(identifier)) : "Test Failed";
		assert (STF3_1hl7.equals(familyname)) : "Test Failed";
		assert (STF3_2hl7.equals(givenname)) : "Test Failed";
		assert (STF3_5hl7.equals(prefix)) : "Test Failed";

		assert (STF11_1hl7.equals(addressline)) : "Test Failed";
		assert (STF11_3hl7.equals(city)) : "Test Failed";
		assert (STF11_4hl7.equals(state)) : "Test Failed";
		assert (STF11_5hl7.equals(postalcode)) : "Test Failed";
		assert (STF11_6hl7.equals(country)) : "Test Failed";

		assert (STF2_11_1hl7.equals(addressline1)) : "Test Failed";
		assert (STF2_11_3hl7.equals(city1)) : "Test Failed";
		assert (STF2_11_4hl7.equals(state1)) : "Test Failed";
		assert (STF2_11_6hl7.equals(country1)) : "Test Failed";
		
		assert (stf6hl7.equals(birthDate)) : "Test Failed";

		assert (valuesmapLocal.get("Qualification_Code").equals(qualificationcode)) : "Test Failed";
		assert (valuesmapLocal.get("Qualification_Text").equals(qualificationdisplay)) : "Test Failed";
		assert (valuesmapLocal.get("Qualification_System").equals(qualificationsystem)) : "Test Failed";

		assert (valuesmapLocal.get("PractitionerLanguage_Code").equals(communicationcode)) : "Test Failed";
		assert (valuesmapLocal.get("PractitionerLanguage_Text").equals(communicationdisplay)) : "Test Failed";
		assert (valuesmapLocal.get("PractitionerLanguage_System").equals(communicationsystem)) : "Test Failed";

		return true;

	}

	public static void hl7values(String hl7filepath) {

		try {
			STF2_1hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-2-1");
			STF3_1hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-3-1");
			STF3_2hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-3-2");
			STF3_5hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-3-5");
			STF11_1hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-11-1");
			STF11_3hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-11-3");
			STF11_4hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-11-4");
			STF11_5hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-11-5");
			STF11_6hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-11-6");

			STF2_11_1hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-11(1)-1");
			STF2_11_3hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-11(1)-3");
			STF2_11_4hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-11(1)-4");
			STF2_11_6hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-11(1)-6");

			STF6hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.STF-6");
			stf6hl7 = genericFunctionLib.getFormatDate(STF6hl7);
			
			EDU2 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.EDU(1)-2");
			LAN2 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.LAN-2-1");

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public static void xmlvalues(String practitionerFHIRXMLFileName) {

		try {

			identifier = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "identifier", "value",
					"value", 0);
			familyname = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "name", "family", "value",
					0);
			givenname = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "name", "given", "value", 0);
			prefix = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "name", "prefix", "value", 0);

			addressline = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "line", "value",
					0);
			city = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "city", "value", 0);
			state = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "state", "value", 0);
			postalcode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "postalCode",
					"value", 0);
			country = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "country", "value",
					0);

			addressline1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "line", "value",
					1);
			city1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "city", "value", 1);
			state1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "state", "value", 1);
			country1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "country", "value",
					1);
			birthDate = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "resource", "birthDate", "value",
					0);
			

			qualificationcode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "code", "code",
					"value", 0);
			qualificationdisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "code", "display",
					"value", 0);
			qualificationsystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "code", "system",
					"value", 0);

			communicationcode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "communication",
					"code", "value", 0);
			communicationdisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "communication",
					"display", "value", 0);
			communicationsystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "communication",
					"system", "value", 0);

		} catch (Exception e) {

			System.out.println(e);
		}

	}

	public static void lookupValues() {

		
		FieldNames = new String[3];
		FieldNames[0] = "Qualification";
		FieldNames[1] = "PractitionerLanguage";

		Texttobelooked = new String[13];
		Texttobelooked[0] = EDU2;
		Texttobelooked[1] = LAN2;

		String url = "https://rhapsody-raviscicd.ibe.philips-healthsuite.com:8445/api/lookuptable/lookupall";

		int i = 0;
		for (i = 0; i <=1; i++) {

			String Request_body = "	 {\"table\":\"IBE_HSDP_V2_Practitioner_FHIR_Codes_Lookup\", \"queryColumns\":[{\"name\":\"Text_To_Be_Looked_Up\",\"value\":\""
					+ Texttobelooked[i]
					+ "\"} ,{\"name\":\"FHIRCodeSetID\",\"value\":\"Codeset_R4_1\"},{\"name\":\"FieldName\",\"value\":\""
					+ FieldNames[i] + "\"}],\"returnColumns\":[\"Code\",\"Display\",\"System\"],\"limit\":10} ";

			System.out.println(Request_body);

			String response = RestAPI_Calls.postheader(url, Request_body, "body");
			System.out.println(response);
			Map<String, String> lookedUpResultMap = null;

			lookedUpResultMap = new HashMap<String, String>();

			JsonObject object = new JsonParser().parse(response).getAsJsonObject();
			JsonArray data = object.getAsJsonArray("data").get(0).getAsJsonArray();

			for (int index = 0; index < data.size(); index++) {
				JsonObject element = data.get(index).getAsJsonObject();
				lookedUpResultMap.put(element.get("name").getAsString(), element.get("value").getAsString());
			}

			valuesmapLocal.put(FieldNames[i] + "_Code", lookedUpResultMap.get("code"));
			valuesmapLocal.put(FieldNames[i] + "_Text", lookedUpResultMap.get("display"));
			valuesmapLocal.put(FieldNames[i] + "_System", lookedUpResultMap.get("system"));
			System.out.println("valuesmapLocal: " + valuesmapLocal);
		}

	}


}

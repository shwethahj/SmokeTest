package mappings;

import java.util.HashMap;
import java.util.Map;
import com.philips.ibec.functionLibrary.RestAPI_Calls;
import com.philips.ibec.functionLibrary.genericFunctionLib;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;

public class practitionerRole {
	
	private static String PRA3hl7;
	private static String PRA5hl7;
	private static Map<String, String> valuesmapLocal = new HashMap<String, String>();
	private static String[] FieldNames;
	private static String[] Texttobelooked;
	private static String practitionercode;
	private static String practitionerdisplay;
	private static String practitionersystem;
	private static String specialtycode;
	private static String specialtydisplay;
	private static String specialtysystem;
	private static String practitionerreference;

	public static boolean practitionerRoleMapping(String practitionerFHIRXMLFileName, String hl7filepath) {
		hl7values(hl7filepath);
		xmlvalues(practitionerFHIRXMLFileName);
		lookupValues();

		assert (valuesmapLocal.get("PractitionerRole_Code").equals(practitionercode)) : "Test Failed";
		assert (valuesmapLocal.get("PractitionerRole_Text").equals(practitionerdisplay)) : "Test Failed";
		assert (valuesmapLocal.get("PractitionerRole_System").equals(practitionersystem)) : "Test Failed";

		assert (valuesmapLocal.get("Specialty_Code").equals(specialtycode)) : "Test Failed";
		assert (valuesmapLocal.get("Specialty_Text").equals(specialtydisplay)) : "Test Failed";
		assert (valuesmapLocal.get("Specialty_System").equals(specialtysystem)) : "Test Failed";

		assert (practitionerreference.contains("Practitioner")) : "Test Failed";
		return true;
	}

	public static void hl7values(String hl7filepath) {
		try {
			PRA3hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PRA-3");
			PRA5hl7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PRA-5-1");
		} catch (Exception e) {

		System.out.println(e);
		}
	}

	public static void xmlvalues(String practitionerFHIRXMLFileName) {

		try {
			practitionercode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "code", "code",
					"value", 0);
			practitionerdisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "code", "display",
					"value", 0);
			practitionersystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "code", "system",
					"value", 0);

			specialtycode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "specialty", "code",
					"value", 0);
			specialtydisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "specialty", "display",
					"value", 0);
			specialtysystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "specialty", "system",
					"value", 0);

			practitionerreference = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "practitioner",
					"reference", "value", 0);
		} catch (Exception e) {

			System.out.println(e);
		}

	}

	public static void lookupValues() {

		FieldNames = new String[2];
		FieldNames[0] = "PractitionerRole";
		FieldNames[1] = "Specialty";

		Texttobelooked = new String[2];
		Texttobelooked[0] = PRA3hl7;
		Texttobelooked[1] = PRA5hl7;

		String url = "https://rhapsody-raviscicd.ibe.philips-healthsuite.com:8445/api/lookuptable/lookupall";

		int i = 0;
		for (i = 0; i <= 1; i++) {

			String Request_body = "	 {\"table\":\"IBE_HSDP_V2_PractitionerRole_FHIR_Codes_Lookup\", \"queryColumns\":[{\"name\":\"Text_To_Be_Looked_Up\",\"value\":\""
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

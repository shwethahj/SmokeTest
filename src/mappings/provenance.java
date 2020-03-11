package mappings;


import java.util.HashMap;
import java.util.Map;
import com.philips.ibec.functionLibrary.RestAPI_Calls;
import com.philips.ibec.functionLibrary.genericFunctionLib;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;

public class provenance {

	private static String reasonCode;
	private static String reasonDisplay;
	private static String reasonSystem;
	private static String activityCode;
	private static String activityDisplay;
	private static String activitySystem;
	private static String agentroleCode;
	private static String agentroleDisplay;
	private static String agentroleSystem;
	private static String[] FieldNames;
	private static String[] Texttobelooked;
	private static Map<String, String> valuesmapLocal = new HashMap<String, String>();

	public static boolean provenanceMapping(String practitionerFHIRXMLFileName, String hl7filepath) {

		xmlvalues(practitionerFHIRXMLFileName);
		lookupValues();

		assert (valuesmapLocal.get("reason_Code").equals(reasonCode)) : "Test Failed";
		assert (valuesmapLocal.get("reason_Text").equals(reasonDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("reason_System").equals(reasonSystem)) : "Test Failed";

		assert (valuesmapLocal.get("activity_Code").equals(activityCode)) : "Test Failed";
		assert (valuesmapLocal.get("activity_Text").equals(activityDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("activity_System").equals(activitySystem)) : "Test Failed";

		assert (valuesmapLocal.get("agentrole_Code").equals(agentroleCode)) : "Test Failed";
		assert (valuesmapLocal.get("agentrole_Text").equals(agentroleDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("agentrole_System").equals(agentroleSystem)) : "Test Failed";

		return true;
	}

	public static void xmlvalues(String practitionerFHIRXMLFileName) {

		try {

			reasonCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "reason", "code", "value",
					0);
			reasonDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "reason", "display",
					"value", 0);
			reasonSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "reason", "system",
					"value", 0);

			activityCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "activity", "code",
					"value", 0);
			activityDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "activity", "display",
					"value", 0);
			activitySystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "activity", "system",
					"value", 0);

			agentroleCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "role", "code", "value",
					0);
			agentroleDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "role", "display",
					"value", 0);
			agentroleSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "role", "system",
					"value", 0);

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public static void lookupValues() {

		FieldNames = new String[3];
		FieldNames[0] = "reason";
		FieldNames[1] = "activity";
		FieldNames[2] = "agentrole";

		Texttobelooked = new String[3];

		Texttobelooked[0] = "Default";
		Texttobelooked[1] = "Default";
		Texttobelooked[2] = "Default";

		String url = "https://rhapsody-raviscicd.ibe.philips-healthsuite.com:8445/api/lookuptable/lookupall";

		int i = 0;
		for (i = 0; i <= 2; i++) {

			String Request_body = "	 {\"table\":\"IBE_HSDP_V2_Provenance_FHIR_Codes_Lookup\", \"queryColumns\":[{\"name\":\"Text_To_Be_Looked_Up\",\"value\":\""
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

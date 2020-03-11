package mappings;

import java.util.HashMap;
import java.util.Map;

import com.philips.ibec.functionLibrary.RestAPI_Calls;
import com.philips.ibec.functionLibrary.genericFunctionLib;

import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;

public class Patient {
	
	private static String pid3;
	private static String pid2;
	private static String pid7;
	private static String pid11;
	private static String PID7;
	private static String pid29;
	private static String PID29;
	private static String pid19;
	private static String pid25;
	private static String pid18;
	private static String pid5_1;
	private static String pid5_2;
	private static String pid13_5;
	private static String pid13_6;
	private static String pid13_7;
	private static String pid14_5;
	private static String pid14_6;
	private static String pid14_7;
	private static String pid11_3;
	private static String pid11_4;
	private static String pid13_4;
	private static String pid11_5;
	private static String pid11_6;
	private static String NK12_1;
	private static String NK12_2;
	private static String NK22_1;
	private static String NK22_2;
	private static String NK24_1;
	private static String NK24_3;
	private static String NK24_5;
	private static String NK25_5;
	private static String NK15_5;
	private static String NK16_5;
	private static String NK1_4;
	private static String NK14_3;
	private static String NK14_4;
	private static String NK14_5;
	private static String NK14_6;
	private static String telecom1hl7;
	private static String telecom2hl7;
	private static String ssn;
	private static String pid20;
	private static String pid8;
	private static String pid15_1;
	private static String NK2_3;
	private static String identifier1;
	private static String identifier2;
	private static String identifier3;
	private static String identifier4;
	private static String identifier5;
	private static String identifier6;
	private static String familyname1;
	private static String givenname1;
	private static String familyname2;
	private static String givenname2;
	private static String familyname3;
	private static String givenname3;
	private static String telecom1;
	private static String telecom2;
	private static String telecom3;
	private static String telecom4;
	private static String telecom5;
	private static String telecom6;
	private static String birthDate;
	private static String deceasedDateTime;
	private static String addresslinevalue;
	private static String addresslinevalue2;
	private static String addresslinevalue3;
	private static String city1;
	private static String state1;
	private static String postalcode1;
	private static String country1;
	private static String multipleBirthInteger;
	private static String city2;
	private static String city3;
	private static String state2;
	private static String postalcode2;
	private static String postalcode3;
	private static String country2;
	private static String MRNIdentifierCode;
	private static String MRNIdentifierDisplay;
	private static String MRNIdentifierSystem;
	private static String PIDIdentifierCode;
	private static String PIDIdentifierDisplay;
	private static String PIDIdentifierSystem;
	private static String SSNIdentifierCode;
	private static String SSNIdentifierDisplay;
	private static String SSNIdentifierSystem;
	private static String MaskSSNIdentifierCode;
	private static String MaskSSNIdentifierDisplay;
	private static String MaskSSNIdentifierSystem;
	private static String PatientAccountIdentifierCode;
	private static String PatientAccountIdentifierDisplay;
	private static String PatientAccountIdentifierSystem;
	private static String maritalStatusCode;
	private static String maritalStatusDisplay;
	private static String maritalStatusSystem;
	private static String ContactRelationshipCode;
	private static String ContactRelationshipDisplay;
	private static String ContactRelationshipSystem;
	private static String PatientLanguageCode;
	private static String PatientLanguageDisplay;
	private static String PatientLanguageSystem;
	private static String DrivingLicenseIdentifierCode;
	private static String DrivingLicenseIdentifierDisplay;
	private static String DrivingLicenseIdentifierSystem;
	private static Map<String, String> valuesmapLocal = new HashMap<String, String>();
	private static String[] FieldNames;
	private static String[] Texttobelooked;

	public static boolean patientMapping(String practitionerFHIRXMLFileName, String hl7filepath) {

		hl7values(hl7filepath);
		xmlvalues(practitionerFHIRXMLFileName);
		lookupValues();

		assert (pid3.equals(identifier1)) : "Test Failed";
		assert (pid2.equals(identifier2)) : "Test Failed";
		assert (pid19.equals(identifier3)) : "Test Failed";
		assert (ssn.equals(identifier4)) : "Test Failed";
		assert (pid18.equals(identifier5)) : "Test Failed";
		assert (pid20.equals(identifier6)) : "Test Failed";
		assert (pid5_1.equals(familyname1)) : "Test Failed";
		assert (pid5_2.equals(givenname1)) : "Test Failed";
		assert (telecom1hl7.equals(telecom1)) : "Test Failed";
		assert (telecom2hl7.equals(telecom2)) : "Test Failed";
		assert (PID7.equals(birthDate)) : "Test Failed";
		assert (PID29.equals(deceasedDateTime)) : "Test Failed";
		assert (pid11.equals(addresslinevalue)) : "Test Failed";
		assert (pid11_3.equals(city1)) : "Test Failed";
		assert (pid11_4.equals(state1)) : "Test Failed";
		assert (pid11_5.equals(postalcode1)) : "Test Failed";
		assert (pid11_6.equals(country1)) : "Test Failed";
		assert (pid25.equals(multipleBirthInteger)) : "Test Failed";
		assert (NK12_1.equals(familyname2)) : "Test Failed";
		assert (NK12_2.equals(givenname2)) : "Test Failed";
		assert (pid13_4.equals(telecom3)) : "Test Failed";
		assert (NK15_5.equals(telecom4)) : "Test Failed";
		assert (NK16_5.equals(telecom5)) : "Test Failed";
		assert (NK1_4.equals(addresslinevalue2)) : "Test Failed";
		assert (pid11.equals(addresslinevalue2)) : "Test Failed";
		assert (NK14_3.equals(city2)) : "Test Failed";
		assert (NK14_4.equals(state2)) : "Test Failed";
		assert (NK14_5.equals(postalcode2)) : "Test Failed";
		assert (NK14_6.equals(country2)) : "Test Failed";
		assert (NK22_1.equals(familyname3)) : "Test Failed";
		assert (NK22_2.equals(givenname3)) : "Test Failed";
		assert (NK25_5.equals(telecom6)) : "Test Failed";
		assert (NK24_1.equals(addresslinevalue3)) : "Test Failed";
		assert (NK24_3.equals(city3)) : "Test Failed";
		assert (NK24_5.equals(postalcode3)) : "Test Failed";

		assert (valuesmapLocal.get("MRNIdentifier_Code").equals(MRNIdentifierCode)) : "Test Failed";
		assert (valuesmapLocal.get("MRNIdentifier_Text").equals(MRNIdentifierDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("MRNIdentifier_System").equals(MRNIdentifierSystem)) : "Test Failed";

		assert (valuesmapLocal.get("PIDIdentifier_Code").equals(PIDIdentifierCode)) : "Test Failed";
		assert (valuesmapLocal.get("PIDIdentifier_Text").equals(PIDIdentifierDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("PIDIdentifier_System").equals(PIDIdentifierSystem)) : "Test Failed";

		assert (valuesmapLocal.get("SSNIdentifier_Code").equals(SSNIdentifierCode)) : "Test Failed";
		assert (valuesmapLocal.get("SSNIdentifier_Text").equals(SSNIdentifierDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("SSNIdentifier_System").equals(SSNIdentifierSystem)) : "Test Failed";

		assert (valuesmapLocal.get("MaskSSNIdentifier_Code").equals(MaskSSNIdentifierCode)) : "Test Failed";
		assert (valuesmapLocal.get("MaskSSNIdentifier_Text").equals(MaskSSNIdentifierDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("MaskSSNIdentifier_System").equals(MaskSSNIdentifierSystem)) : "Test Failed";

		assert (valuesmapLocal.get("PatientAccountIdentifier_Code")
				.equals(PatientAccountIdentifierCode)) : "Test Failed";
		assert (valuesmapLocal.get("PatientAccountIdentifier_Text")
				.equals(PatientAccountIdentifierDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("PatientAccountIdentifier_System")
				.equals(PatientAccountIdentifierSystem)) : "Test Failed";

		assert (valuesmapLocal.get("DrivingLicenseIdentifier_Code")
				.equals(DrivingLicenseIdentifierCode)) : "Test Failed";
		assert (valuesmapLocal.get("DrivingLicenseIdentifier_Text")
				.equals(DrivingLicenseIdentifierDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("DrivingLicenseIdentifier_System")
				.equals(DrivingLicenseIdentifierSystem)) : "Test Failed";

		assert (valuesmapLocal.get("maritalStatus_Code").equals(maritalStatusCode)) : "Test Failed";
		assert (valuesmapLocal.get("maritalStatus_Text").equals(maritalStatusDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("maritalStatus_System").equals(maritalStatusSystem)) : "Test Failed";

		assert (valuesmapLocal.get("ContactRelationship_Code").equals(ContactRelationshipCode)) : "Test Failed";
		assert (valuesmapLocal.get("ContactRelationship_Text").equals(ContactRelationshipDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("ContactRelationship_System").equals(ContactRelationshipSystem)) : "Test Failed";

		assert (valuesmapLocal.get("PatientLanguage_Code").equals(PatientLanguageCode)) : "Test Failed";
		assert (valuesmapLocal.get("PatientLanguage_Text").equals(PatientLanguageDisplay)) : "Test Failed";
		assert (valuesmapLocal.get("PatientLanguage_System").equals(PatientLanguageSystem)) : "Test Failed";

		return true;
	}

	public static void hl7values(String hl7filepath) {

		try {
			pid3 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-3");
			pid2 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-2");
			ssn = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-19").substring(5);
			pid19 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-19");
			pid18 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-18");
			pid20 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-20");
			pid5_1 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-5-1");
			pid5_2 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-5-2");

			pid13_5 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-13-5");
			pid13_6 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-13-6");
			pid13_7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-13-7");
			telecom1hl7 = pid13_5 + "-" + pid13_6 + "-" + pid13_7;

			pid14_5 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-14-5");
			pid14_6 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-14-6");
			pid14_7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-14-7");
			telecom2hl7 = pid14_5 + "-" + pid14_6 + "-" + pid14_7;

			pid7 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-7");
			PID7 = genericFunctionLib.getFormatDate(pid7);

			pid29 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-29");
			PID29 = genericFunctionLib.getFormattedDate(pid29);

			pid11 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-11-1") + " "
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-11-1-2") + " "
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-11-1-3");

			pid11_3 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-11-3");
			pid11_4 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-11-4");
			pid11_5 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-11-5");
			pid11_6 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-11-6");

			pid25 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-25");

			NK12_1 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-2-1");
			NK12_2 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-2-2");
			NK15_5 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-5-5") + "-"
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-5-6") + "-"
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-5-7");

			pid13_4 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-13-4");
			NK16_5 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-6-5") + "-"
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-6-6") + "-"
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-6-7");
			NK1_4 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-4-1") + " "
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-4-1-2") + " "
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-4-1-3");
			NK14_3 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-4-3");
			NK14_4 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-4-4");
			NK14_5 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-4-5");
			NK14_6 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1-4-6");
			NK22_1 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1(1)-2-1");
			NK22_2 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1(1)-2-2");
			NK25_5 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1(1)-5-5") + "-"
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1(1)-5-6") + "-"
					+ genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1(1)-5-7");
			NK24_1 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1(1)-4-1");
			NK24_3 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1(1)-4-3");
			NK24_5 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1(1)-4-5");
			pid8 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-8");
			NK2_3 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.NK1(1)-3");
			pid15_1 = genericFunctionLib.getHL7FieldValue(hl7filepath, "/.PID-15-1");

		} catch (Exception e) {

			System.out.println(e);
		}

	}

	public static void xmlvalues(String practitionerFHIRXMLFileName) {

		try {
			
			identifier1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "identifier", "value",
					"value", 0);
			identifier2 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "identifier", "value",
					"value", 1);
			identifier3 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "identifier", "value",
					"value", 2);
			identifier4 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "identifier", "value",
					"value", 3);
			identifier5 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "identifier", "value",
					"value", 4);
			identifier6 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "identifier", "value",
					"value", 5);
			familyname1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "name", "family", "value",
					0);
			givenname1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "name", "given", "value", 0);
			telecom1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "telecom", "value", "value",
					0);
			telecom2 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "telecom", "value", "value",
					1);
			birthDate = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "resource", "birthDate",
					"value", 0);
			deceasedDateTime = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "resource",
					"deceasedDateTime", "value", 0);
			addresslinevalue = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "line",
					"value", 0);
			city1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "city", "value", 0);
			state1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "state", "value", 0);
			postalcode1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "postalCode",
					"value", 0);
			country1 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "country", "value",
					0);
			multipleBirthInteger = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "resource",
					"multipleBirthInteger", "value", 0);
			familyname2 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "name", "family", "value",
					1);
			givenname2 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "name", "given", "value", 1);
			telecom3 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "telecom", "value", "value",
					2);
			telecom4 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "telecom", "value", "value",
					4);

			telecom5 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "telecom", "value", "value",
					5);
			addresslinevalue2 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "line",
					"value", 1);
			city2 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "city", "value", 1);
			state2 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "state", "value", 1);
			postalcode2 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "postalCode",
					"value", 1);
			country2 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "country", "value",
					1);
			familyname3 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "name", "family", "value",
					2);
			givenname3 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "name", "given", "value", 2);
			telecom6 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "telecom", "value", "value",
					6);
			addresslinevalue3 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "line",
					"value", 2);
			city3 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "city", "value", 2);
			postalcode3 = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "address", "postalCode",
					"value", 2);

			MRNIdentifierCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "code",
					"value", 0);
			MRNIdentifierDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"display", "value", 0);
			MRNIdentifierSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "system",
					"value", 0);

			PIDIdentifierCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "code",
					"value", 1);
			PIDIdentifierDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"display", "value", 1);
			PIDIdentifierSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "system",
					"value", 1);

			SSNIdentifierCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "code",
					"value", 2);
			SSNIdentifierDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"display", "value", 2);
			SSNIdentifierSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "system",
					"value", 2);

			MaskSSNIdentifierCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "code",
					"value", 3);
			MaskSSNIdentifierDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"display", "value", 3);
			MaskSSNIdentifierSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"system", "value", 3);

			PatientAccountIdentifierCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"code", "value", 4);
			PatientAccountIdentifierDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName,
					"coding", "display", "value", 4);
			PatientAccountIdentifierSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"system", "value", 4);

			DrivingLicenseIdentifierCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"code", "value", 5);
			DrivingLicenseIdentifierDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName,
					"coding", "display", "value", 5);
			DrivingLicenseIdentifierSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"system", "value", 5);

			maritalStatusCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "code",
					"value", 6);
			maritalStatusDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"display", "value", 6);
			maritalStatusSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "system",
					"value", 6);

			ContactRelationshipCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"code", "value", 7);
			ContactRelationshipDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"display", "value", 7);
			ContactRelationshipSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"system", "value", 7);

			PatientLanguageCode = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding", "code",
					"value", 9);
			PatientLanguageDisplay = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"display", "value", 9);
			PatientLanguageSystem = genericFunctionLib.XMLAttributeValue(practitionerFHIRXMLFileName, "coding",
					"system", "value", 9);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void lookupValues() {

		FieldNames = new String[9];
		FieldNames[0] = "MRNIdentifier";
		FieldNames[1] = "PIDIdentifier";
		FieldNames[2] = "SSNIdentifier";
		FieldNames[3] = "MaskSSNIdentifier";
		FieldNames[4] = "PatientAccountIdentifier";
		FieldNames[5] = "DrivingLicenseIdentifier";
		FieldNames[6] = "maritalStatus";
		FieldNames[7] = "ContactRelationship";
		FieldNames[8] = "PatientLanguage";

		Texttobelooked = new String[9];
		Texttobelooked[0] = "Default";
		Texttobelooked[1] = "Default";
		Texttobelooked[2] = "Default";
		Texttobelooked[3] = "Default";
		Texttobelooked[4] = "Default";
		Texttobelooked[5] = "Default";
		Texttobelooked[6] = pid8;
		Texttobelooked[7] = NK2_3;
		Texttobelooked[8] = pid15_1;

		String url = "https://rhapsody-raviscicd.ibe.philips-healthsuite.com:8445/api/lookuptable/lookupall";

		int i = 0;
		for (i = 0; i <= 8; i++) {

			String Request_body = "	 {\"table\":\"IBE_HSDP_V2_Patient_FHIR_Codes_Lookup\", \"queryColumns\":[{\"name\":\"Text_To_Be_Looked_Up\",\"value\":\""
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

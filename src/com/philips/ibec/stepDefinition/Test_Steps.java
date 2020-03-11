package com.philips.ibec.stepDefinition;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.philips.ibec.functionLibrary.RestAPI_Calls;
import com.philips.ibec.functionLibrary.genericFunctionLib;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import mappings.MessageHeader;
import mappings.practitioner;
import mappings.practitionerRole;
import mappings.provenance;

public class Test_Steps {

	public static String hl7filepath = "C:\\IOBridge\\inputdata\\EncounterMFNM02.hl7";
	public static String autoconfigpath = "C:\\IOBridge\\Autoconfig\\AutoConfig.xml";
	public static String fileFullPath = "C:\\IOBridge\\resources";
	public static String dest = "C://IOBridge/resources" + "/resource";
	public static String filename = "C:\\IOBridge\\Bundle\\bundle.xml";
	public static String dirpath = "C:\\IOBridge\\Bundle";
	
	
	@Given("^The Message is send to Toolkit_Test$")
	public void the_MFN_Message_is_send_to_Toolkit_Test() throws IOException, ParserConfigurationException, SAXException {
	    
		genericFunctionLib.cleanDirectory(fileFullPath);
		genericFunctionLib.cleanDirectory(dirpath);
		String MFNM02FileContent = genericFunctionLib.getFileContent(hl7filepath);
		System.out.println(MFNM02FileContent);

		String Url = genericFunctionLib.XMLValue(autoconfigpath, "TestEnv", "EncResourceToolkit", 0);
		System.out.println("Url:"+Url);

		String response = RestAPI_Calls.sendMessage(Url, MFNM02FileContent, "code");
		System.out.println(response);
		assert response.contains("200");
		System.out.println("first scenario completed");
	    
	}

	@And("^The Message is processed successfully$")
	public void the_Message_is_processed_successfully() throws Throwable {
		             
		File f = new File(filename);
		for (int i = 0; i <= 6; i++) {
			if (f.exists()) {
						
					genericFunctionLib.SplitXML(filename, "//Bundle/entry", dest);
				}
			else {
				Thread.sleep(1000);
				}
		}
		System.out.println("Second scenario completed");
	}


	@Then("^Verify the MESSAGEHEADER resource mapping$")
	public void Validation_of_MESSAGEHEADER() {
		
		try {
			String MessageHeaderresourceName = "MessageHeader";
			String MSHFHIRXMLFileName = genericFunctionLib.getSpecificFHIRResource(fileFullPath, MessageHeaderresourceName);
			System.out.println("MSHFHIRXMLFileName:" + MSHFHIRXMLFileName);
			boolean res1 = MessageHeader.messageHeaderMapping(MSHFHIRXMLFileName, hl7filepath);
			System.out.println("MSH resource mapping:" + res1);
			} catch (Exception e) {
			
			System.out.println(e);
			}
	}
		
		@Then("^Verify the PRACTITIONER resource mapping$")
		public void Validation_of_practitioner() {
			
			try {
			
			String PractitionerresourceName = "Harold";
			String practitionerFHIRXMLFileName = genericFunctionLib.getSpecificFHIRResource(fileFullPath, PractitionerresourceName);
			System.out.println("practitionerFHIRXMLFileName:" + practitionerFHIRXMLFileName);
			boolean res2 = practitioner.practitionerMapping(practitionerFHIRXMLFileName, hl7filepath);
			System.out.println("practitioner resource mapping:" + res2);
			} catch (Exception e) {
				
				System.out.println(e);
			}
		}
		
		@Then("^Verify the PRACTITIONERROLE resource mapping$")
		public void Validation_of_practitionerRole() {
			
			try {
			
			String PractitionerRoleresourceName = "PractitionerRole";
			String practitionerRoleFHIRXMLFileName = genericFunctionLib.getSpecificFHIRResource(fileFullPath, PractitionerRoleresourceName);
			System.out.println("practitionerRoleFHIRXMLFileName:" + practitionerRoleFHIRXMLFileName);
			boolean res3 = practitionerRole.practitionerRoleMapping(practitionerRoleFHIRXMLFileName, hl7filepath);
			System.out.println("practitionerRole resource mapping:" + res3);
			} catch (Exception e) {
				
				System.out.println(e);
			}
	}
		@Then("^Verify the PROVENANCE resource mapping$")
		public void Validation_of_provenance() {
			
			try {
				
			String ProvenanceName = "Provenance";
			String ProvenanceFHIRXMLFileName = genericFunctionLib.getSpecificFHIRResource(fileFullPath, ProvenanceName);
			System.out.println("ProvenanceFHIRXMLFileName:" + ProvenanceFHIRXMLFileName);
			boolean res4 = provenance.provenanceMapping(ProvenanceFHIRXMLFileName, hl7filepath);
			System.out.println("provenance resource mapping:" + res4);
			} catch (Exception e) {
				
				System.out.println(e);
			}
	
		System.out.println("Third scenario completed");

	}
}

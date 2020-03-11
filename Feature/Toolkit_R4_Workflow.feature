Feature: Verify the Bundle publishing in toolkit workflow for R4
 
 @RegressionTest@SmokeTest
  Scenario: Verify the Message is getting Published to R4 
     Given The Message is send to Toolkit_Test 
     And The Message is processed successfully
     Then Verify the MESSAGEHEADER resource mapping
     Then Verify the PRACTITIONER resource mapping
     Then Verify the PRACTITIONERROLE resource mapping
     Then Verify the PROVENANCE resource mapping
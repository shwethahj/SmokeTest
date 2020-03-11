package com.philips.ibec.SmokeTest;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="Feature/Toolkit_R4_Workflow.feature"
		,glue={"com.philips.ibec.stepDefinition"}
		,tags = {"@SmokeTest","@RegressionTest"})

public class TestRunner {

	@BeforeClass
	public static void fun() {
		System.out.println("Running Smoke Tests....:)");
	}

}

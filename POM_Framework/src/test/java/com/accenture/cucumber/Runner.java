package com.accenture.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.TestCase;

@RunWith(Cucumber.class)
@CucumberOptions(features=".\\src\\test\\java\\com\\accenture\\cucumber\\LoginTest.feature")
public class Runner{
}
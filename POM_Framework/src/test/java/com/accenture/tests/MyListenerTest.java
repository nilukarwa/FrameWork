package com.accenture.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class MyListenerTest {
  @Test
  public void pass() {
	  boolean ps = true;
	  boolean pa = true;
	  Assert.assertEquals(ps, pa);
  }
  @Test
  public void fail() {
	  boolean ps = true;
	  boolean pa = false;
	  Assert.assertEquals(ps, pa);
  }
}
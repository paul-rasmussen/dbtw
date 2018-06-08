package com.dbtw.widgets;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringWidgetTest {

	//Static variables
	//Constants
	//Private variables
	//Public variables

	//Constructors
	public StringWidgetTest() {
		init();
	}

	//Static methods
	//Public methods
	@Test
	public void testLpad() {
		assertEquals("StringWidget Test lpad:", "         This, is a test.", StringWidget.lpad("This, is a test.", 25));
	}

	@Test
	public void testRpad() {
		assertEquals("StringWidget Test rpad:", "This, is a test.         ", StringWidget.rpad("This, is a test.", 25));
	}

	@Test
	public void testClean() {
		assertEquals("StringWidget Test lpad:", "This, is a test.", StringWidget.clean("This,: is- a t3est."));
	}
	//Private methods
	private void init() {
	}
	
	
}

package com.dbtw.widgets;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateWidgetTest {

	private DateWidget widget = new DateWidget();
	
	public DateWidgetTest() {
		init();
	}
	
	@Test
	public void testGetFormattedDate(){
		assertEquals("Testing Oracle format:", "05/10/2013", widget.getFormattedDate(DateWidget.ORACLE_FORMAT));
		assertEquals("Testing MySQL format:", "2005-05-10", widget.getFormattedDate(DateWidget.MYSQL_FORMAT));
	}
	
	private void init() {
		widget.setDate("5/10/2013");
	}
}

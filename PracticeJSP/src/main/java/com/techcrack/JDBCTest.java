package com.techcrack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JDBCTest {

	@Test
	void test() {
		JDBC db=new JDBC();
		assertTrue(db.dataBaseConnect("DharaniKavin", 40));
	}

}

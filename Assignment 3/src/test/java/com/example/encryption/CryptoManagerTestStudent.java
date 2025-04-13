/*
 * Class: CMSC203
 * Instructor: Dr. Grinberg
 * Description: Java program to encrypt and decrypt a phrase using two similar approaches, each insecure by modern standards.  
 * Due: 03/08/2025 
 * Platform/compiler: IntelliJ / vscode-javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Paolo Nessim
 */


package com.example.encryption;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO WORLD!"));
		assertTrue(CryptoManager.isStringInBounds("12345"));
		assertFalse(CryptoManager.isStringInBounds("hello"));
		assertFalse(CryptoManager.isStringInBounds("~INVALID"));
		assertFalse(CryptoManager.isStringInBounds("TEST\tTAB"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("BCD", CryptoManager.caesarEncryption("ABC", 1));
		assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("hello", 3));
		assertEquals("89:;", CryptoManager.caesarEncryption("4567", 4));
		assertEquals("KLMNOP", CryptoManager.caesarEncryption("GHIJKL", 4));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("ABC", CryptoManager.caesarDecryption("BCD", 1));
		assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
		assertEquals("4567", CryptoManager.caesarDecryption("89:;", 4));
		assertEquals("GHIJKL", CryptoManager.caesarDecryption("KLMNOP", 4));
		assertEquals("-!\",9\",9Z9,^\\+^-", CryptoManager.caesarDecryption("THIS IS A SECRET", 999));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("_J,_N'R", CryptoManager.bellasoEncryption("TESTING", "KEY"));
		assertEquals("]LQ]H\"", CryptoManager.bellasoEncryption("JGNKCN", "SECRET"));
		assertEquals("UFSUR!FZ]", CryptoManager.bellasoEncryption("HELLOTEST", "MAGICMAGIC"));
		assertEquals("VTGZ%&", CryptoManager.bellasoEncryption("CODES!", "SECURE"));
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING", CryptoManager.bellasoDecryption("_J,_N'R", "KEY"));
		assertEquals("JGNKCN", CryptoManager.bellasoDecryption("]LQ]H\"", "SECRET"));
		assertEquals("HELLOTEST", CryptoManager.bellasoDecryption("UFSUR!FZ]", "MAGICMAGIC"));
		assertEquals("CODES!", CryptoManager.bellasoDecryption("VTGZ%&", "SECURE"));
	}
}

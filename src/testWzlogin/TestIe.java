package testWzlogin;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import basepage.BasePage;

public class TestIe extends BasePage {
	String test_url = "http://192.168.101.192:81/wz/login";

	@Before
	public void setUp() throws Exception {
		setupChrome(test_url);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFF() {
		
	}

}

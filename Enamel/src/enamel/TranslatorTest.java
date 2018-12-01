package enamel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TranslatorTest {

	private BufferedReader in = null;
	@BeforeEach
	void setUp() throws Exception {//need to fix input stream file cuz it is giving null pointer
		in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("")));
	}
	
	@AfterEach
	void teardown() throws Exception{
		if (in != null) {
			in.close();
		}
		in = null;
	}

	@Test
	final void testReadScenario() throws IOException {	//gives a null pointer exception
		//fail("Not yet implemented"); // TODO
		String line = in.readLine();
		//assertThat(line, ));
		assertNotNull(line);
		
	}

}

package channels;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

public class MainTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
	@Test
	public void mainTest() {
		Main.main(null);
		System.setIn(new ByteArrayInputStream("123".getBytes()));
		System.setIn(new ByteArrayInputStream("45".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 2".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 3".getBytes()));
		System.setIn(new ByteArrayInputStream("thisis 4".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 5".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("garbled".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 2".getBytes()));
		System.setIn(new ByteArrayInputStream("Why wouldn't you increase the transmission power, so that I can hear what you are saying?".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 2".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 3".getBytes()));
		System.setIn(new ByteArrayInputStream("thisis unreadable".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 5".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 2".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 3".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 2".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 3".getBytes()));
		System.setIn(new ByteArrayInputStream("thisis 4".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 5".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 2".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 3".getBytes()));
		System.setIn(new ByteArrayInputStream("to 1".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 2".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 3".getBytes()));
		System.setIn(new ByteArrayInputStream("thisis 4".getBytes()));
		System.setIn(new ByteArrayInputStream("rep 5".getBytes()));
		
		assertEquals("true", outContent.toString().trim());
	}
}

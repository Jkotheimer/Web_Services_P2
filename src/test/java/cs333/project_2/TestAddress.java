package cs333.project_2;
import cs333.project_2.DOM.General.Address;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Address Class
 */
public class TestAddress {

	private Address fixture;

	@Test
	public void test_Address_Getters_N_Setters() {
		// Test Object Initialization
		fixture = new Address("1703 mamken ave","Beaton","Washington",90876);

		assertEquals("1703 mamken ave",fixture.getStreet());
		assertEquals("Beaton",fixture.getCity());
		assertEquals("Washington",fixture.getState());
		assertEquals(90876,fixture.getZipcode());

		// Test Updating Values

		fixture.setStreet("100 Yokos ave");
		fixture.setCity("Yokon");
		fixture.setState("Yorulia");
		fixture.setZipcode(90456);

		assertEquals("100 Yokos ave",fixture.getStreet());
		assertEquals("Yokon",fixture.getCity());
		assertEquals("Yorulia",fixture.getState());
		assertEquals(90456,fixture.getZipcode());

		assertEquals("100 Yokos ave, Yokon, Yorulia 90456", fixture.ConvertAddresstoString());
    }
}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestIcecream{
		@Test
			public void testIcecream() {
			Icecream icecream = new Icecream("cho",2.5);
			assertEquals(null,"[cho,$2.5]", icecream.getText());
		}

		@Test
		public void  testGetPrice() {
			Icecream icecream = new Icecream("cho",2.5);
			assertTrue(icecream.getPrice()==2.5);
		}

	}


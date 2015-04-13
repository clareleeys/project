import static org.junit.Assert.*;

import org.junit.Test;


public class TestDecoratorButton {

	@Test
	public void testDecoratorButton() {
		DecoratorButton db = new DecoratorButton("Strawberry",3.3);
		assertEquals(null,"[Strawberry,$3.3]", db.getText());
	}

	@Test
	public void testGetPrice() {
		DecoratorButton db = new DecoratorButton("M&M",2.5);
		assertTrue(db.getPrice()==2.5);
	}
	

}

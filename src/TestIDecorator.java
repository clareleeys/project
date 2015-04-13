import static org.junit.Assert.*;

import org.junit.Test;


public class TestIDecorator {
	@Test
	public void testGetPrice() {
		Icecream icecream = new Icecream("cho",2.5);
		Decorator cherry = new Decorator(3, icecream);
		Decorator MM = new Decorator(4, cherry);
		assertTrue(MM.getPrice()==9.5);
	}
	
	public void testIcecream() {
	Icecream icecream = new Icecream("cho",2.5);
	assertEquals(null,"[cho,$2.5]", icecream.getText());
}
	
	public void testDecoratorButton() {
		DecoratorButton db = new DecoratorButton("Strawberry",3.3);
		assertEquals(null,"[Strawberry,$3.3]", db.getText());
	}

}

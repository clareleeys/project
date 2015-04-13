import java.math.BigDecimal;
import java.math.RoundingMode;

public class Decorator implements IDecorator{
	private IDecorator m_icecream;
	private double m_price;
	public Decorator(double price, IDecorator icecream){
		m_icecream=icecream;
		m_price=price;
	}
	public double getPrice(){
		BigDecimal bd1, bd2;
		bd1 = new BigDecimal(m_price).setScale(2, RoundingMode.HALF_UP);
		bd2 = new BigDecimal(m_icecream.getPrice()).setScale(2, RoundingMode.HALF_UP);
		return bd1.add(bd2).doubleValue();
	}
}
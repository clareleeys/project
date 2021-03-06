import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces

import javax.swing.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;



public class Icecream extends JButton implements IDecorator{
	private String m_flavor;
	private double m_price;
	public Icecream(String flavor, double price){
		setText("["+flavor+",$"+price+"]");
		m_flavor=flavor;
		m_price=price;
	}
	
	public double getPrice(){
		BigDecimal bd;
		bd = new BigDecimal(m_price).setScale(2, RoundingMode.HALF_UP);
		m_price=bd.doubleValue();
		return m_price;
	}
}
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;
import java.util.*;
public class AdminDialog extends JDialog implements ActionListener {

	private String m_Desc;
	private double m_Price;
	private boolean m_IceCream;
	JRadioButton Icecream = new JRadioButton("Icecream");
	JRadioButton Decorator = new JRadioButton("Decorator");
	private boolean m_confirm=false;
	JButton btnOK = new JButton("OK");  // construct Label
	JButton btnCancel = new JButton("CANCEL");
	TextField txtDesc = new TextField("", 10);
	TextField txtPrice = new TextField("", 10);
	
	public boolean IsIceCream(){
		return m_IceCream;
	}
	public double getPrice(){
		return m_Price;
	}
	public String getDesc(){
		return m_Desc;
	}
	public boolean IsConfirm(){
		return m_confirm;
	}
	
	public AdminDialog(JFrame parent){
		super(parent);
		
		ButtonGroup bG = new ButtonGroup();
		bG.add(Icecream);
		bG.add(Decorator);
		this.setSize(100,200);
		this.setLayout( new GridLayout(4,1));
		JPanel TypePanel=new JPanel();
		TypePanel.setLayout(new FlowLayout());
		TypePanel.add(Icecream);
		TypePanel.add(Decorator);
		Icecream.setSelected(true);
		add(TypePanel);
		
		JPanel DescPanel=new JPanel();
		DescPanel.setLayout(new FlowLayout());
		JLabel lblDesc = new JLabel("Description");  // construct Label
		
		DescPanel.add(lblDesc);
		DescPanel.add(txtDesc);
		add(DescPanel);
		
		JPanel PricePanel=new JPanel();
		DescPanel.setLayout(new FlowLayout());
		JLabel lblPrice = new JLabel("Price");  // construct Label
		
		PricePanel.add(lblPrice);
		PricePanel.add(txtPrice);
		add(PricePanel);
		
		JPanel ButtonPanel=new JPanel();
		DescPanel.setLayout(new FlowLayout());
		
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
		ButtonPanel.add(btnOK);
		ButtonPanel.add(btnCancel);
		add(ButtonPanel);
		
		pack();

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnOK){
			m_confirm=true;
			m_Desc=txtDesc.getText();
			m_Price=Double.parseDouble(txtPrice.getText());
			if(Icecream.isSelected()){
				m_IceCream=true;
			}
			else{
				m_IceCream=false;
			}
		}
		dispose();
	}

}
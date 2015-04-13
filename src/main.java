import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;
import java.util.*;

public class main extends JFrame implements ActionListener {
	// Declare component 
   private TextField totalCount;
   private JButton btnNewIceCream;   
   private JButton btnAdmin=new JButton("System Administrator");   
   private JPanel panelNorth=new JPanel();
   private JPanel panelSouth=new JPanel();
   private JPanel panelWest=new JPanel();
   private JPanel panelCentre=new JPanel();
   private JPanel panelEast=new JPanel();
   private java.util.List<JButton> flavorButtonList=new ArrayList<JButton>();
   private java.util.List<JButton> decoratorButtonList=new ArrayList<JButton>();
   private boolean isEnableIcecream=false;
   private boolean isEnableDecorator=false;
   /** Constructor to setup GUI components and event handling */
   private IDecorator finalProduct=null;
   public main () {
	  
	  //set Layout
	  panelNorth.setLayout(new GridLayout(1,3));
	  panelSouth.setLayout(new GridLayout(1,3));
	  panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
	  panelCentre.setLayout(new BoxLayout(panelCentre, BoxLayout.Y_AXIS));
	  panelEast.setLayout(new FlowLayout());
	  setLayout(new BorderLayout());

	  
	  add(panelNorth,BorderLayout.NORTH);
	  add(panelSouth,BorderLayout.SOUTH);
	  add(panelWest,BorderLayout.WEST);
	  add(panelCentre,BorderLayout.CENTER);
	  add(panelEast,BorderLayout.EAST);
	  
	  //north panel
	  panelNorth.add(new JLabel("Ice-cream Flavor", SwingConstants.LEFT));
	  panelNorth.add(new JLabel("Decorator", SwingConstants.LEFT));
	  btnNewIceCream=new JButton("New Ice cream");
	  panelNorth.add(btnNewIceCream);                    // "super" Frame adds Button
	  btnNewIceCream.addActionListener(this);
	  
	  //south panel
	  panelSouth.add(btnAdmin);
	  btnAdmin.addActionListener(this);
	  
	  //Initial textField
	  totalCount=new TextField("Total: $0", 10);
	  totalCount.setEditable(false);
	  panelEast.add(totalCount);
	 
      setTitle("Icecream shop");  // "super" Frame sets title
      setSize(500, 200);        // "super" Frame sets initial window size
	  
	  Icecream  icebtn=new Icecream("Chocolate", 20.0);
		icebtn.addActionListener(this);
		flavorButtonList.add(icebtn);
		panelWest.add(icebtn);
		icebtn.setEnabled(isEnableIcecream);
	  icebtn=new Icecream("Vanilla", 20.0);
		icebtn.addActionListener(this);
		flavorButtonList.add(icebtn);
		panelWest.add(icebtn);
		icebtn.setEnabled(isEnableIcecream);
		
		
	 DecoratorButton  decoratorBtn=new DecoratorButton("M&M", 5.0);
	 decoratorBtn.addActionListener(this);
	 decoratorButtonList.add(decoratorBtn);
	 decoratorBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
	 decoratorBtn.setEnabled(isEnableDecorator);                           
	 panelCentre.add(decoratorBtn);
	 decoratorBtn=new DecoratorButton("Stawberry", 5.0);
	 decoratorBtn.addActionListener(this);
	 decoratorButtonList.add(decoratorBtn);
	 decoratorBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
	 decoratorBtn.setEnabled(isEnableDecorator);                           
	 panelCentre.add(decoratorBtn);
					
		//panelWest.revalidate(); 
		//panelWest.repaint();
		//setMinimumSize(getSize());
		//pack();
		//setMinimumSize(null);
 
      
	  setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	   addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent we) {
                        
                        System.exit(0);
                    }
                } );

      setVisible(true);         // "super" Frame shows
 
	  setMinimumSize(getSize());
	  pack();
	  setMinimumSize(null);
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
	   main app = new main();
   }
 
   /** ActionEvent handler - Called back upon button-click. */
   @Override
   public void actionPerformed(ActionEvent evt) {

	   //New ice-cream button function
		if(evt.getSource()==btnNewIceCream){
			finalProduct=null;
			totalCount.setText("Total: $0");
			for (Iterator<JButton> it =decoratorButtonList.iterator(); it.hasNext();){
				it.next().setEnabled(false);
				
			}
			isEnableDecorator=false;
			for (Iterator<JButton> it =flavorButtonList.iterator(); it.hasNext();){
				it.next().setEnabled(true);
				
			}
			isEnableIcecream=true;
			


		}
		   // ice-cream button action
		if(evt.getSource() instanceof Icecream){
			finalProduct=(IDecorator)evt.getSource();
			totalCount.setText("Total: $"+finalProduct.getPrice());
			for (Iterator<JButton> it =decoratorButtonList.iterator(); it.hasNext();){   
				it.next().setEnabled(true);  //After select ice-cream flavor, decorator button enable.
			}
			isEnableDecorator=true;
			for (Iterator<JButton> it =flavorButtonList.iterator(); it.hasNext();){
				it.next().setEnabled(false);
			}
			isEnableIcecream=false;
		}
		// Decorator button action
		if(evt.getSource() instanceof DecoratorButton){
			DecoratorButton btn=(DecoratorButton) evt.getSource();
			IDecorator newProduct=new Decorator(btn.getPrice(), finalProduct);		
			totalCount.setText("Total: $"+newProduct.getPrice());
			finalProduct=newProduct;

	        }
		
		// System Administration button action
		if(evt.getSource()==btnAdmin){
			AdminDialog dlg=new AdminDialog(this);
			dlg.setModal(true);
			dlg.setVisible(true);
			if(dlg.IsConfirm()){
				// add ice-cream button
				if(dlg.IsIceCream()){
					Icecream  b=new Icecream(dlg.getDesc(), dlg.getPrice());
					b.addActionListener(this);
					flavorButtonList.add(b);
					b.setEnabled(isEnableIcecream);
					panelWest.add(b);
					panelWest.revalidate(); 
					panelWest.repaint();
					setMinimumSize(getSize());
					pack();
					setMinimumSize(null);
				}else{
					// add decorator button
					DecoratorButton  b=new DecoratorButton(dlg.getDesc(), dlg.getPrice());
					b.addActionListener(this);
					decoratorButtonList.add(b);
					b.setAlignmentX(Component.CENTER_ALIGNMENT);
					b.setEnabled(isEnableDecorator);                           //disable new decorator button
					panelCentre.add(b);
					panelCentre.revalidate(); 
					panelCentre.repaint();
					setMinimumSize(getSize());
					pack();
					setMinimumSize(null);
				}
			
			}
			
		}
   }
} 

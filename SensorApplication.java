
package sensors;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//import sensor.TemperatureSensor;
import sensor.*;

public class SensorApplication extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String LEFT_AXIS = null;

	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
	
		/*JPanel  temperaturePnl = new JPanel();
		temperaturePnl.setBorder(new TitledBorder("Temperature"));
		add(temperaturePnl);
		
		JPanel pressurePn1=new JPanel();
		pressurePn1.setBorder(new TitledBorder("Pressure"));
		add(pressurePn1);
		
		JPanel radiationLev=new JPanel();
		radiationLev.setBorder(new TitledBorder("Radiation Level"));
		add(radiationLev);*/
		
	   Adapter[] adapters=new Adapter[]{
			   new PressureAdapter(new PressureSensor()),
				new RadiationAdapter(new RadiationSensor()), 
				new TempAdapter(new TemperatureSensor())
				};
		
		for(Adapter adapter:adapters) {
			
			JPanel  Pnl = new JPanel();
			JLabel label=new JLabel();
			
			Pnl.setBorder(new TitledBorder(adapter.getName()));
			Pnl.setLayout(new FlowLayout(FlowLayout.LEFT));
			
		    JProgressBar j=new JProgressBar(0,(int) adapter.getMax());
		    
		    j.setForeground(adapter.getColor());
		    j.setValue((int) adapter.getValue());

		    j.setOpaque(true);
		    label.setText(adapter.getMessage());
		    Pnl.add(j);
		    Pnl.add(label);
		    add(Pnl);
		}
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}
}

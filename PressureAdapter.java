package sensors;

import java.awt.Color;

import sensor.PressureSensor;

public class PressureAdapter implements Adapter {
private PressureSensor s;
private double value;
private String status;
private double max;

	
	public  PressureAdapter(PressureSensor s) {
		this.s=s;
		this.value=s.readValue();
		this.status=s.getReport();
		max=10.0;
	}
	public double getMax() {
		return this.max;
	}
	public double getValue() {
		return value;
	}
	public String getStatus() {
		return status;
	}
	public Color getColor() {
		if(status.equalsIgnoreCase("Critical")) return Color.YELLOW;
		else if(status.equalsIgnoreCase("OK")) return Color.GREEN;
		return Color.RED;
	}
	public String getMessage() {
		return status+"----->"+value;
	}
	public String getName() {
		return s.getSensorName();
	}
	
}

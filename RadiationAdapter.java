package sensors;

import java.awt.Color;

import sensor.RadiationSensor;

public class RadiationAdapter implements Adapter{
	
private RadiationSensor s;
private String status;
private double level;
private double max;
	
	public  RadiationAdapter(RadiationSensor s) {
		this.s=s;
		level=s.getRadiationValue();
		status=s.getStatusInfo();
		max=8;
	}
	public double getMax() {
		return this.max;
	}
	public double getValue() {
		return level;
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
		return status+"----->"+level;
	}
	public String getName() {
		return s.getName();
	}
}

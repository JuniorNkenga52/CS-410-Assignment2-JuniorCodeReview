package sensors;

import java.awt.*;

import sensor.TemperatureSensor;

public class TempAdapter implements Adapter{
	
	private TemperatureSensor s;
	private double value;
	private String status;
	private double max;
	
	public  TempAdapter(TemperatureSensor s) {
		this.s=s;
		value=s.senseTemperature();
		status=s.getTempReport();
		max=400.0;
    }
	public double getMax() {
		return this.max;
	}
	public double getValue() {
		return this.value;
	}
	public String getStatus() {
		return this.status;
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
		return s.getSensorType();
	}
}
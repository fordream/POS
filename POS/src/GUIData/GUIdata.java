package GUIData;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class GUIdata {
	
	public static Color buttonBorderColor = new Color(150, 150, 150);
	public static Color buttonColor = new Color(0, 174, 255);
	public static Color buttonColor2 = new Color(61, 134, 185);
	public static Color exitButtonColor = new Color(255, 210, 0);
	public static Color removeButtonColor = new Color(255, 174, 0);
	public static int buttonBorderThickness = 1;
	public static Color loginFrameColor = new Color(255, 255, 255);
	public static Color tableInnerPanelColor = new Color(245, 245, 245);
	
	public static Border buttonBorder = BorderFactory.createMatteBorder(0, 0, buttonBorderThickness, 0, buttonBorderColor);
	public static Border buttonBorder2 = BorderFactory.createMatteBorder(buttonBorderThickness,
			buttonBorderThickness, buttonBorderThickness, buttonBorderThickness, buttonBorderColor);

}

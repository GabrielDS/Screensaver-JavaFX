import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.util.Calendar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.GregorianCalendar;
import java.util.Date;

import java.text.SimpleDateFormat;

public class ScreenClockController implements Initializable
{

	@FXML
	Text time;

	@FXML
	Text period;

	Calendar time_system;

	SimpleDateFormat sdf_time;

	SimpleDateFormat sdf_period;

	public ScreenClockController()
	{
		sdf_time = new SimpleDateFormat("KK:mm");

		sdf_period = new SimpleDateFormat("a");

		time_system = new GregorianCalendar();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
	    time.setText( formatTextTime() );

	    period.setText( formatTextPeriod() );
	}

	public String formatTextTime()
	{
		return sdf_time.format( time_system.getTime() );
	}

	public String formatTextPeriod()
	{
		return sdf_period.format( time_system.getTime() );
	}
}
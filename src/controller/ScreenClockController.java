import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.util.Calendar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.SimpleDateFormat;

public class ScreenClockController implements Initializable, Runnable
{

	@FXML
	private Text time;

	@FXML
	private Text period;

	@FXML
	ImageView img;

	private Calendar time_system;

	private SimpleDateFormat sdf_time;

	private SimpleDateFormat sdf_period;

	private Thread interna;

	private String[] img_background;

	private boolean stop;

	private Random random_img;

	public ScreenClockController()
	{
		sdf_time = new SimpleDateFormat("KK:mm");

		sdf_period = new SimpleDateFormat("a");

		interna = null;

		stop = false;

		interna = new Thread( this, "Relogio" );

		img_background = new String[ 7 ];

		img_background[ 0 ] = "0.jpg";
		img_background[ 1 ] = "1.jpg";
		img_background[ 2 ] = "2.jpg";
		img_background[ 3 ] = "3.jpg";
		img_background[ 4 ] = "4.jpg";
		img_background[ 5 ] = "5.jpg";
		img_background[ 6 ] = "6.jpg";

		random_img = new Random();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		img.setImage( new Image ( img_background[ random_img.nextInt( 6 ) ] ) );

		time.setText( formatTextTime() );

		period.setText( formatTextPeriod() );

		interna.start();
	}

	@Override
	public void run()
	{
		while( Thread.currentThread() == interna && !stop )
		{
			try
			{
				Thread.sleep( 1000 );

				time.setText( formatTextTime() );

				period.setText( formatTextPeriod() );
			}
			catch( InterruptedException e )
			{
				// TODO
			}
		}
	}

	public void stop()
	{
		stop = true;
		interna = null;
	}

	public String formatTextTime()
	{
		time_system = new GregorianCalendar();

		return sdf_time.format( time_system.getTime() );
	}

	public String formatTextPeriod()
	{
		return sdf_period.format( time_system.getTime() );
	}
}
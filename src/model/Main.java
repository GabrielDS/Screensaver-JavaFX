import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.stage.StageStyle;

public class Main extends Application
{
	private final String SCREEN = "ScreenClock.fxml";

	@Override
	public void start( Stage stage ) throws IOException
	{
		stage.setScene( createScene( loadWindow() ) );

		// stage.initStyle(StageStyle.UNDECORATED);

		stage.setFullScreen( true );

		stage.setResizable( false );

		stage.sizeToScene();

		stage.show();
	}

	private GridPane loadWindow() throws IOException
	{
		return FXMLLoader.load(getClass().getResource( SCREEN ) );
	}

	private Scene createScene( GridPane pane ) throws IOException
	{
		Scene scene = new Scene( pane );

		return scene;
	}

	public static void main(String[] args)
	{
		launch( args );
	}
}
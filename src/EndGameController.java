/**
 * Created by Rishabh Jain AKA CodeGod on 05 30, 2019 at 13:33
 */
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Rishabh Jain AKA CodeGod on 05 28, 2019 at 16:33
 */
public class EndGameController implements Initializable {

    @FXML
    Button restartButton, quitButton;

    @FXML
    MenuItem backMenuItem;

    @FXML
    Label scoreLabel;

    @FXML
    BorderPane endGamePane;

    public Stage pStage;
    public int score;


    public EndGameController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void start(){
        init();
        restartControl();
        menuItem();
        quitControl();
    }

    private void init() {
        scoreLabel.setText("Score: " + score);
    }

    private void restartControl() {
        restartButton.setOnAction(e -> { restart();});
    }

    private void menuItem() {
        backMenuItem.setOnAction(e -> {
            restart();
        });
    }

    private void quitControl() {
        quitButton.setOnAction(e -> {
            System.exit(1);
        });
    }

    private void restart(){
        Platform.runLater(new Runnable() {
            @Override public void run() {

                try{
                    Starter  s = new Starter();
                    s.start(new Stage());
                }
                catch (Exception e){
                    System.out.println("Error in EndGameController: " + e.getMessage());
                }
            }
        });
        pStage.close();
    }

}

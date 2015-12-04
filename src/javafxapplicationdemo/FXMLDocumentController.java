/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationdemo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

/**
 *
 * @author denic
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label city;
    
    @FXML
    private Label other_data;
    
    @FXML
    private Label other_data1;
    
    @FXML
    private Label current_temp;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, MalformedURLException,JSONException {
        System.out.println("You clicked me!");
        
        OpenWeatherMap owm = new OpenWeatherMap("");
        owm.setApiKey("95b844c054292e842f1cb4fc3d5b4367");
        owm.setUnits(OpenWeatherMap.Units.METRIC);
        owm.setLang(OpenWeatherMap.Language.RUSSIAN);
        
        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("Saratov");
        
        city.setText(cwd.getCityName()+","+cwd.getSysInstance().getCountryCode());

        other_data.setText("Wind speed "+Float.toString(cwd.getWindInstance().getWindSpeed())+" meter/sec" + " Clouds "+cwd.getCloudsInstance().getPercentageOfClouds() + "%" + " Pressure "+cwd.getMainInstance().getPressure() + " hpa");
        current_temp.setText("Current Temp " + cwd.getMainInstance().getTemperature() +" C");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

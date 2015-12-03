/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ownpack;

import java.io.IOException;
import java.net.MalformedURLException;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;


/**
 *
 * @author denic
 */
public class OwmJapisExample1 {
    
    public static void main(String[] args)
            throws IOException, MalformedURLException,JSONException{

        // declaring object of "OpenWeatherMap" class
        OpenWeatherMap owm = new OpenWeatherMap("");
        owm.setApiKey("95b844c054292e842f1cb4fc3d5b4367");
        owm.setUnits(OpenWeatherMap.Units.METRIC);

        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("Saratov");

        //printing city name from the retrieved data
        System.out.println("City: " + cwd.getCityName());
        

        // printing the max./min. temperature
        System.out.println("Temperature: " + cwd.getMainInstance().getMaxTemperature()
                            + "/" + cwd.getMainInstance().getMinTemperature() + "\'C");
        // printing the max./min. temperature
        System.out.println("Pressure: " + cwd.getMainInstance().getPressure() + " hpa");
        System.out.println("Humidity: " + cwd.getMainInstance().getHumidity() + " %");
                            
    }
    
}

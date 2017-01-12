package library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

import play.Logger;

public class ConnectionHttp {
	
	public static String httpPost(String parameter, String urls) {
		try {
			//HTTP URL CONNECTION
            Logger.debug("--------------------------------------------------");
            Logger.debug("URL: "+urls+" and PARAMETER: "+parameter);
			URL url = new URL(urls);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.addRequestProperty("Content-Type","application/json");
			
			OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(parameter);
            wr.flush();
			String hasil = "";
			Logger.debug("Http Response Code     : "+connection.getResponseCode());
			if (connection.getResponseCode() == 200) {

                BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    hasil = hasil + line;
                }
    			Logger.debug("Connection Http Data : "+hasil);
    			Logger.debug("--------------------------------------------------");
    			connection.disconnect();
    			
    			return hasil;
            } else {
            	Logger.debug("Http Response Code "+connection.getResponseCode());
			}
		} catch (ConnectException e) {
			e.printStackTrace();
			Logger.debug("Failed - Connection refused");
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			Logger.debug("Failed - Read timed out");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public static String httpGet(String parameter, String urls) {
		try {
			//HTTP URL CONNECTION
            Logger.debug("--------------------------------------------------");
            Logger.debug("URL: "+urls+" and PARAMETER: "+parameter);
            Logger.debug("--------------------------------------------------");
			URL url = new URL(urls);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.addRequestProperty("Content-Type","application/json");
			
			OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(parameter);
            wr.flush();
			String hasil = "";
			Logger.debug("Http Response Code     : "+connection.getResponseCode());
			if (connection.getResponseCode() == 200) {

                BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    hasil = hasil + line;
                }
                Logger.debug("---------------------HASIL------------------------");
    			Logger.debug("Fund (json) Data = "+hasil);
    			Logger.debug("--------------------------------------------------");
    			connection.disconnect();
    			
    			return hasil;
            } else {
            	Logger.debug("Http Response Code "+connection.getResponseCode());
			}
		} catch (ConnectException e) {
			e.printStackTrace();
			Logger.debug("Failed - Connection refused");
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			Logger.debug("Failed - Read timed out");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}

}

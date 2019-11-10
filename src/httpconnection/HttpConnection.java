package httpconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnection {

	static HttpURLConnection connection;    
    
    public static StringBuffer returnStringBuffer(String stringUrl) throws IOException {
    	

    	StringBuffer responseContent = new StringBuffer();
        try {
            BufferedReader reader;
            String line;
            
        	
            URL url = new URL(stringUrl);
            connection = (HttpURLConnection) url.openConnection(); 
            
            // connection setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            //System.out.println(status); // 200 for connection successful.

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                    
                }
                reader.close();
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                	
                    responseContent.append(line);
                    
                }
                reader.close();
            }           
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e ){
            e.printStackTrace();
        } finally{
            connection.disconnect();
        }
		return responseContent;
    }


}

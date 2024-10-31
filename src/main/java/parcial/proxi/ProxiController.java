package parcial.proxi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxiController {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://";
    private boolean roundRobin = true;

    @GetMapping("/linearsearch")
	public String linearSearch(@RequestParam(value = "list") int[] list, @RequestParam(value = "value") int value ) throws IOException{
        String initialPathString = GET_URL + RoundRobin.round(roundRobin)+"/linearsearch?list=";
        System.out.println("Url inicial:"+initialPathString);
        for (int i = 0; i < list.length; i++) {
            if (i!=list.length-1) {
                initialPathString += list[i]+",";
            } else{
                initialPathString += list[i]+"";
            }
        }

        String url = initialPathString+"&value="+value;

        System.out.println("Url del servicio:"+url);
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        roundRobin = !roundRobin;

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            
            System.out.println("Response: " +response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return "";
	}

	@GetMapping("/binarysearch")
	public String binarySearch(@RequestParam(value = "list") int[] list, @RequestParam(value = "value") int value ) {
		
        return "";
	}

}

package ooshni.impactx;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Hashtable;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class HttpRequestTask extends AsyncTask<String, Void, String> {
	
	private Exception exception;

    protected String doInBackground(String... params) {
    	String path = params[0];
    	//Map map = params[1];
	
	//public static HttpResponse makeRequest(String path, Map params) throws Exception 
	//{
	    //instantiates httpclient to make request
    	
    	String username= "af116a19-e99d-4aee-980a-5b1b3ef2a5a9-bluemix";
		String password= "7b1d23d5438460a8d8ce6189e07abbbf5a12dab5b274c4d62a238b74f5220bb4";
		
	    DefaultHttpClient httpclient = new DefaultHttpClient();
	    httpclient.getCredentialsProvider().setCredentials(
                new AuthScope("af116a19-e99d-4aee-980a-5b1b3ef2a5a9-bluemix.cloudant.com", 443), 
                new UsernamePasswordCredentials(username, password));

	    //url with the post data
	    //String path2 = "https://af116a19-e99d-4aee-980a-5b1b3ef2a5a9-bluemix:7b1d23d5438460a8d8ce6189e07abbbf5a12dab5b274c4d62a238b74f5220bb4@af116a19-e99d-4aee-980a-5b1b3ef2a5a9-bluemix.cloudant.com";
    
	    HttpPost httpost = new HttpPost(path);

	    ////////////////////////
	    
	    Map<String, String> user = new Hashtable<String, String>();
	    user.put("name", "oohee");
	    user.put("id", "234");
	    
	    Map<String, String> impact = new Hashtable<String, String>();
	    impact.put("intensity", "0.8");
	    
	    Map<String, Map<String,String>> impactX = new Hashtable<String, Map<String,String>>();
	    impactX.put("user", user);
	    impactX.put("impact", impact);
	    
	    Map<String, Map<String,Map<String, String>>> map  = new Hashtable<String, Map<String,Map<String, String>>>();
	    map.put("impactX", impactX);
	    
	    //convert parameters into JSON object
	    try {
			JSONObject holder = getJsonObjectFromMap(map);
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    
	    //passes the results to a string builder/entity
	    //StringEntity se;

		try {
			StringEntity se = new StringEntity("");
			//se = new StringEntity("{\"name\":\"WOOHEE\", \"wsdfs\":200, \"gaaa\":100}");
		    se = new StringEntity("{\"impactX\": {\"user\": { \"name\": \"Bob Smith\",\"id\": \"2\"}, \"impact\": {\"intensity\": \"0.8\"}}}");
			//sets the post request as the resulting string
		    httpost.setEntity(se);
		    //sets a request header so the page receving the request
		    //will know what to do with it
		    httpost.setHeader("Accept", "application/json");
		    httpost.setHeader("Content-type", "application/json");
		    
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	    //Handles what is returned from the page 
	    ResponseHandler responseHandler = new BasicResponseHandler();
	    try {
	    	String httpResponse = httpclient.execute(httpost, responseHandler);
	    	return httpResponse;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "boo you failed" ;
	}
    
    protected void onPostExecute(HttpResponse feed) {
        // TODO: check this.exception 
        // TODO: do something with the feed
    }
	
	private static JSONObject getJsonObjectFromMap(Map params) throws JSONException {

	    //all the passed parameters from the post request
	    //iterator used to loop through all the parameters
	    //passed in the post request
	    Iterator iter = params.entrySet().iterator();

	    //Stores JSON
	    JSONObject holder = new JSONObject();

	    //using the earlier example your first entry would get email
	    //and the inner while would get the value which would be 'foo@bar.com' 
	    //{ fan: { email : 'foo@bar.com' } }

	    //While there is another entry
	    while (iter.hasNext()) 
	    {
	        //gets an entry in the params
	        Map.Entry pairs = (Map.Entry)iter.next();

	        //creates a key for Map
	        String key = (String)pairs.getKey();

	        //Create a new map
	        Map m = (Map)pairs.getValue();   

	        //object for storing Json
	        JSONObject data = new JSONObject();

	        //gets the value
	        Iterator iter2 = m.entrySet().iterator();
	        while (iter2.hasNext()) 
	        {
	            Map.Entry pairs2 = (Map.Entry)iter2.next();
	            data.put((String)pairs2.getKey(), (String)pairs2.getValue());
	        }

	        //puts email and 'foo@bar.com'  together in map
	        holder.put(key, data);
	    }
	    return holder;
	}
}

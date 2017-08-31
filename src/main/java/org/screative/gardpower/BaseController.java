package org.screative.gardpower;

import org.restexpress.Request;
import org.restexpress.Response;

import java.net.InetSocketAddress;
import java.util.HashMap;

/**
 * Created by sureya on 1/11/14.
 */
public class BaseController {
    public BaseController() {


    }
    public void testing(Request request, Response response){


        String details = request.getHeader("credentials");

        String[] resp = details.split("&");

        HashMap<String,String> results = new HashMap<String, String>();

        results.put("UserName",resp[0]);
        results.put("password",resp[1]);


        String browserName = request.getHeader("User-Agent");

        InetSocketAddress ipAdd = request.getRemoteAddress();

        String ip = ipAdd.toString();

        String path = request.getPath();

        System.out.println("path: "+path);
        System.out.println("Ip: "+ip+"-"+browserName);

        response.setBody(results.toString());


    }
    
    public static void postReq(Request request, Response response){

        System.out.println("Entered Post request method ");

        //String jsonInput = String.valueOf(request.getBodyFromUrlFormEncoded(true));
        String res = String.valueOf(request.getBodyFromUrlFormEncoded(false)).replace("=[]", "");
        res = res.substring(1,res.length()-1);

        try {
            JSONObject respJson = new JSONObject(res);
            /*
            Sample response to which contents are coded.
            {
                "name":"Sureya",
                "title":"Data Guy"
            }
            */
            String name = respJson.getString("name");
            String title = respJson.getString("title");
            String finalResponse = "Name is : "+name+" and title is : "+title;
            response.setBody(finalResponse);
        } catch (JSONException e) {
            e.printStackTrace();

        }
        response.setBody("I'm fine");

    }
    
}

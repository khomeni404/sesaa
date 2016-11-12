package net.softengine.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 23/01/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 23/01/16
 * Version : 1.0
 */

public class HttpURLConnectionExample {
    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

        // System.out.println("\nTesting 2 - Send Http POST request");
        // http.sendPost();

    }

    public static final String PUBLIC_KEY = "1013502933";
    public static final String PRIVATE_KEY = "{l4WqG&q";
    public static final String SENDER_MASK = "Khomeni";
    public static final String RECEIVER_NO = "8801717659287";
    public static final String MESSAGE = "HelloMessage";
    public static final int DELAY = 0;
    public static final int TYPE = 8; // Plaing Eng = 1, UNICODE = 8


    // HTTP GET request
    private void sendGet() throws Exception {
        String url = "http://www.sms4bd.net/HTTP.svc/SendSMS?" +
                "publickey=" + PUBLIC_KEY +
                "&privatekey=" + PRIVATE_KEY +
                "&sender=" + SENDER_MASK +
                "&receiver=" + RECEIVER_NO +
                "&message=" + MESSAGE +
                "&delay=" + DELAY +
                "&type=" + TYPE;
        //String url = "http://www.sms4bd.net/http.svc/SendSMS";
        String url3 = "http://www.sms4bd.net/HTTP.svc/SendSMS?publickey=10135024933&privatekey={l4WqG&q&sender=Khomeni&receiver=8801717659287&message=hello&delay=1000&type=8";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");


        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}

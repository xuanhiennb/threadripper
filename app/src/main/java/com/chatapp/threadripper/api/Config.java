package com.chatapp.threadripper.api;


public class Config {

    public final static String BASE_URL =
            "http://192.168.1.226:8083"; // for production
    // "http://192.168.0.43:3000";         // for localhost
    // "http://14.226.231.248";             // for test
//    http://68a5548e.ngrok.io

    // REST API
    public final static String API_ROUTE = BASE_URL + "/api/";

    // SOCKET API
    public final static String WEB_SOCKET_URL = "http://192.168.1.226:8083";
    public final static String WEB_SOCKET_ENDPOINT = "/ws/websocket";
    public final static String WEB_SOCKET_FULL_PATH = WEB_SOCKET_URL + WEB_SOCKET_ENDPOINT;

}

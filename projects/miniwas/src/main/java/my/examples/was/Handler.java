package my.examples.was;

import java.io.*;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

public class Handler extends Thread {
    private Connector connector;
    private Socket socket;
    private String method;
    private String path;
    private String protocolVersion;
    private String reqLine;
    private String[] reqLineArr;
    private Map<String, String> reqHeader = new LinkedHashMap<>();

    public Handler(Connector connector, Socket socket) {
        this.connector = connector;
        this.socket = socket;
    }

    public Map<String, String> getReqHeader() {
        return reqHeader;
    }

    public Connector getConnector() {
        return connector;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public String getReqLine() {
        return reqLine;
    }

    public String[] getReqLineArr() {
        return reqLineArr;
    }

    public void putRequestHeader(String key, String value) {
        reqHeader.put(key, value);
    }

    public void printRequestHeader() {
        for (String headerKey : reqHeader.keySet()) {
            String key = headerKey;
            String value = reqHeader.get(key);
            System.out.println(key + ": " + value);
        }
    }

    @Override
    public void run() {

        BufferedReader request = null;
        PrintWriter response = null;

        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            request = new BufferedReader(new InputStreamReader(in));
            response = new PrintWriter(new OutputStreamWriter(out));

            /******************** Request Line ********************/
            reqLine = request.readLine();
            reqLineArr = reqLine.split(" ");
            method = reqLineArr[0];
            path = reqLineArr[1];
            protocolVersion = reqLineArr[2];
            System.out.println(method + " " + path + " " + protocolVersion);

            /******************* Request Header *******************/
            String headerLine = null;
            while ((headerLine = request.readLine()) != null) {
                if("".equals(headerLine))
                    break;
                String[] headerMapArr = headerLine.split(": ");
                String key = headerMapArr[0];
                String value = headerMapArr[1];
                putRequestHeader(key, value);
            }
            printRequestHeader();

            Engine engine = new Engine(this, in, out, request, response);
            engine.startEngine();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

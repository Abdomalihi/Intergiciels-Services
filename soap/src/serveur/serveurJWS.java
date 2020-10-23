package serveur;

import services.banqueService;

import javax.xml.ws.Endpoint;

public class serveurJWS {
    //psvm + tab
    public static void main(String[] args) {
        String url="http://localhost:1992/";
        Endpoint.publish(url,new banqueService());
        System.out.println(url);
    }
}

package client;

import services.BanqueServiceService;
import services.BanqueWS;
import services.Compte;

import java.util.List;
cap
public class clientWS {
    public static void main(String[] args) {
        BanqueWS stub = new BanqueServiceService().getBanqueWSPort();
        double res = stub.conversionEuroToDhs(800);
        System.out.println("800 Euro en Dhs = " + res);
        Compte compte = stub.getCompte(1L);
        System.out.println(compte.getSolde());
        System.out.println("---------------------------");
        List<Compte> comptes = stub.getComptes();
        comptes.forEach(cp->{
            System.out.print("code  : " + cp.getCode() + " --> ");
            System.out.println("solde : " + cp.getSolde());
        });
    }
}

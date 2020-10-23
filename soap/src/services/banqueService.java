package services;

import model.compte;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(name = "BanqueWS")
public class banqueService {
    @WebMethod(operationName = "conversionEuroToDhs")
    public double conversion(@WebParam(name = "montant") double mt){
        return mt*11.3;
    }
    @WebMethod
    public compte getCompte(@WebParam(name = "code") Long code){
        return  new compte(code,Math.random()*80000,new Date());
    }
    @WebMethod
    public List<compte> getComptes(){
        List<compte> comptes = new ArrayList<>();
        comptes.add( new compte(1L,Math.random()*80000,new Date()));
        comptes.add( new compte(2L,Math.random()*80000,new Date()));
        return comptes;
    }
}

package gateway.Gatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallBackRestController {
    @GetMapping("/defaultCountries")
    public Map<String,String> restCountriesFallback(){
        Map<String,String> map=new HashMap<>();
        map.put("message","Default Rest Countries Fallback service");
        map.put("countries","Maroc, Algérie, Tunisie, ....");
        return map;
    }
    @GetMapping("/defaultSalat")
    public Map<String,String> muslimSalatBack(){
        Map<String,String> map=new HashMap<>();
        map.put("message","Default Muslim Fallback service");
        map.put("Fajr","07:00");
        map.put("DOHR","14:00");
        return map;
    }

}

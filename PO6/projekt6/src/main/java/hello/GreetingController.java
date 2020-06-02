package hello;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {private static final String template = "imie, %s!,wiek, %s,%s";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/bye") 

    public Greeting greeting(@RequestParam(value = "wiek", defaultValue = "30" ) String  wiek,
                             @RequestParam(value = "imie", defaultValue = "Anna" ) String imie,String kto )
    {
         if(imie.charAt(imie.length()-1)=='a'){
        kto="kobieta";
        }
        else{
        kto="mezczyzna";
        }

        return new Greeting(counter.incrementAndGet(), String.format(template, wiek,imie,kto));
    }
    private final AtomicLong nextCounter = new AtomicLong();
    @RequestMapping("/nowy") 

    public Greeting greetno(@RequestParam(value = "wzorzec", defaultValue = "1234" ) String imie,String zawiera) {
         if(imie.length()==4)
        {zawiera="zawiera";}
        else
        {zawiera="nie zawiera";}

        return new Greeting(nextCounter.incrementAndGet(), String.format(template, imie,zawiera));
        
    }
  
    
}
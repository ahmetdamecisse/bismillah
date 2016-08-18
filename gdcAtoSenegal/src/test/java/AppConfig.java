
import com.gdc.services.Imetier;
import com.gdc.services.Metier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author a618092
 */
@Configuration
public class AppConfig {
  @Bean
    public Imetier getMetier(){
        return new Metier();
    }
  
}

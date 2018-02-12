import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class ServiceConfiguration {
    
        @Bean
        public Endpoint endpoint() {
            EndpointImpl endpoint = new EndpointImpl(cxf(), new HelloWorldImpl());
            endpoint.publish("/HelloWorld");
            return endpoint;
        }
        
        @Bean
        public SpringBus cxf() {
            return new SpringBus();
        }
        
    }


import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


    public class AppInitializer implements WebApplicationInitializer {
        @Override
        public void onStartup(ServletContext container) {
    
            AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
            context.register(ServiceConfiguration.class);
    
            container.addListener(new ContextLoaderListener(context));
    
            // Register and map the dispatcher servlet
            ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new CXFServlet());
            dispatcher.setLoadOnStartup(1);
    
            dispatcher.addMapping("/services/*");
        }
    }

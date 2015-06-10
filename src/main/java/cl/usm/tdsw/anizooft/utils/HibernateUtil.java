package cl.usm.tdsw.anizooft.utils;
/*
import java.util.Calendar;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sun.istack.internal.logging.Logger;
/*
public final class HibernateUtil {
    private static final Logger LOGGER = Logger
                                   .getLogger(HibernateUtil.class);

private static HibernateUtil instance = null;
private static SessionFactory sessionFactory = null;
private HibernateUtil() {
super();
}


public static HibernateUtil getInstance() {
	synchronized (HibernateUtil.class) {
	if (instance == null) {
	    instance = new HibernateUtil();
	}
	return instance;
}
}

public SessionFactory getSessionFactory() {
    if(sessionFactory==null){
                   long inicio = Calendar.getInstance().getTimeInMillis();
            final Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry;
            
            //final File file=new File(PropertiesManager.getInstance().getBasePatch()+"administrador"+
            //                       File.separator+"hibernate"+File.separator+"hibernate.cfg.xml");
            
            final File file = 
            
            configuration.configure(file);
                                   
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).getBootstrapServiceRegistry();
            if (serviceRegistry != null) {
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
           
            LOGGER.info("demora configurar hibernate:"+ (Calendar.getInstance().getTimeInMillis() - inicio) +" ms");
           
    }
return sessionFactory;

}



public Session getSession() {
    long inicio = Calendar.getInstance().getTimeInMillis();
Session openSession = getSessionFactory().openSession();
LOGGER.info("demora abrir sesion:"+ (Calendar.getInstance().getTimeInMillis() - inicio) +" ms");
                   return openSession;
}
}*/

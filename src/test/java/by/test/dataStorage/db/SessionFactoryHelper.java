package by.test.dataStorage.db;

import by.test.models.Account;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryHelper {
  private static SessionFactory sessionFactory = null;

  static {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      StandardServiceRegistryBuilder.destroy( registry );
    }
  }

  public static SessionFactory createSessionFactory() {
    Configuration configuration = new Configuration();
    configuration.addAnnotatedClass(Account.class);
    configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/tutby_data");
    configuration.setProperty("hibernate.connection.username", "root");
    configuration.setProperty("hibernate.connection.password", "");
    configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    configuration.setProperty("hibernate.hbm2ddl.auto", "validate");
    configuration.setProperty("hibernate.show_sql", "true");
    configuration.setProperty("hibernate.connection.pool_size", "10");

    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties());
    sessionFactory = configuration.buildSessionFactory(builder.build());
    return sessionFactory;
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}

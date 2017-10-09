package pl.javastart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        Map<String, String> proporties = new HashMap<>();
        proporties.put("hibernate.connection.url","jdbc:postgresql://localhost:5432/jpa_2");
        proporties.put("javax.persistence.jdbc.user","gutek");
        proporties.put("javax.persistence.jdbc.password","daniel");
        proporties.put("javax.persistence.jdbc.driver","org.postgresql.Driver");
        proporties.put("javax.persistence.schema-generation.database.action","drop-and-create");
        emf.setPersistenceUnitName("spring-jpa-pu");
        emf.setJpaPropertyMap(proporties);
        emf.setJpaVendorAdapter(adapter);
        emf.setPackagesToScan("pl.javastart.model");
        return emf;
    }

    @Bean
    public JpaVendorAdapter createVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setShowSql(true);
        return adapter;
    }
}

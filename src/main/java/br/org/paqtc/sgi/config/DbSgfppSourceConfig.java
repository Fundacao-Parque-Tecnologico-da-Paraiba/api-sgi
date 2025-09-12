package br.org.paqtc.sgi.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "br.org.paqtc.sgi.repositories.dbsgfpp",
        entityManagerFactoryRef = "dbSgfppEntityManagerFactory",
        transactionManagerRef = "dbSgfppTransactionManager"
)
public class DbSgfppSourceConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "dbSgfppDataSource")
    public DataSource dbConfDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("second.datasource.driver-class-name")));
        dataSource.setUrl(Objects.requireNonNull(environment.getProperty("second.datasource.url")));
        dataSource.setUsername(Objects.requireNonNull(environment.getProperty("second.datasource.username")));
        dataSource.setPassword(Objects.requireNonNull(environment.getProperty("second.datasource.password")));

        return dataSource;
    }

    @Bean(name = "dbSgfppEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbConfEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dbConfDataSource());
        bean.setPackagesToScan("br.org.paqtc.sgi.entities.dbsgfpp");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(vendorAdapter);

        Map<String ,String> properties = new HashMap<>();
        properties.put("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getProperty("spring.datasource.show-sql"));
        bean.setJpaPropertyMap(properties);
        return bean;
    }

    @Bean(name = "dbSgfppTransactionManager")
    public PlatformTransactionManager dbConfTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(dbConfEntityManagerFactory().getObject());
        return transactionManager;
    }
}

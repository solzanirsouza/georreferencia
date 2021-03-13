package souza.solzanir.georreferencia.config.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager",
        basePackages = "souza.solzanir.georreferencia.repository"
)
@EnableTransactionManagement
public class PostgresDataSourceConfig {

    @Value("${spring.config.datasource.username}")
    private String username;

    @Value("${spring.config.datasource.password}")
    private String password;

    @Value("${spring.config.datasource.postgres.url}")
    private String url;

    @Value("${spring.config.datasource.postgres.driver-class-name}")
    private String driver;

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Bean(name = "postgres-db")
    public DataSource postgresDataSource() {
        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setDriverClassName(driver);
        driverManager.setUrl(url);
        driverManager.setUsername(username);
        driverManager.setPassword(password);
        return driverManager;
    }

    @Primary
    @Bean(name = "postgresEntityManagerFactory")
    public EntityManagerFactory postgresEntityManagerFactory(final @Qualifier("postgres-db") DataSource postgresDataSource) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(postgresDataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setJpaProperties(JpaProperties.additional());
        lef.setPackagesToScan("souza.solzanir.georreferencia.model.entity");
        lef.setPersistenceUnitName("postgresDb");
        lef.afterPropertiesSet();
        return lef.getObject();
    }

    @Bean(name = "postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManagerFactory") EntityManagerFactory postgresEntityManagerFactory) {
        return new JpaTransactionManager(postgresEntityManagerFactory);
    }
}


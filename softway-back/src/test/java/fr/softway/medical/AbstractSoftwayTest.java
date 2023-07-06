package fr.softway.medical;

import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.io.File;
import java.sql.Connection;

@SpringBootTest
@Transactional
public class AbstractSoftwayTest {

    @Autowired
    private WebApplicationContext context;

    protected ObjectMapper objectMapper;

    protected MockMvc mockMvc;
    protected static MSSQLServerContainer mssqlserver = new MSSQLServerContainer().acceptLicense();
    private static final String DRIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    @BeforeAll
    public static void setup() {
        mssqlserver.withInitScript("sql/init_database_schema.sql");
        mssqlserver.start();
        lunchLiquibase();
        System.setProperty("JDBC_URL", mssqlserver.getJdbcUrl());
    }

    @BeforeEach
    public void setUpMock() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    protected static void lunchLiquibase() {
        try {
            Liquibase liquibase = new Liquibase("db/changelog/changelog.sql", new ClassLoaderResourceAccessor(), new JdbcConnection(getDataSource().getConnection()));
            liquibase.update(new Contexts());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static void resetData(String dataSetFileName) {
        try {
            Connection con = DataSourceUtils.getConnection(getDataSource());
            IDatabaseConnection connection = new DatabaseConnection(con);
            FlatXmlDataSet additionalDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/dataset/" + dataSetFileName));
            DatabaseOperation.DELETE_ALL.execute(connection, additionalDataSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static void initData(String dataSetFileName) {
        try {
            Connection con = DataSourceUtils.getConnection(getDataSource());
            IDatabaseConnection connection = new DatabaseConnection(con);
            DatabaseConfig config = connection.getConfig();
            config.setProperty(DatabaseConfig.FEATURE_ALLOW_EMPTY_FIELDS, true);
            FlatXmlDataSet additionalDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/dataset/" + dataSetFileName));
            DatabaseOperation.INSERT.execute(connection, additionalDataSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(AbstractSoftwayTest.mssqlserver.getJdbcUrl());
        dataSource.setUsername(AbstractSoftwayTest.mssqlserver.getUsername());
        dataSource.setPassword(AbstractSoftwayTest.mssqlserver.getPassword());
        return dataSource;
    }
}
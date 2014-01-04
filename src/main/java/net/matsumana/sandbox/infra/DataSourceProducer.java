package net.matsumana.sandbox.infra;

import org.joda.time.DateTime;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

//@Singleton
@RequestScoped
public class DataSourceProducer {

    @Resource(lookup = "java:jboss/datasources/postgres-matsumana")
    DataSource dataSource1;

    @Resource(lookup = "java:jboss/datasources/postgres-matsumana2")
    DataSource dataSource2;

    @Produces
    DataSource getDataSource() {
        DateTime dt = new DateTime();
        int sec = Integer.parseInt(dt.toString("s"));
        if (sec % 2 == 0) {
            return dataSource1;
        } else {
            return dataSource2;
        }
    }
}

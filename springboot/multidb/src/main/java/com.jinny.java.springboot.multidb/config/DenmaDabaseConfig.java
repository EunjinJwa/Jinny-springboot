package com.jinny.java.springboot.multidb.config;

import com.zaxxer.hikari.HikariDataSource;
        import org.apache.ibatis.session.SqlSessionFactory;
        import org.mybatis.spring.SqlSessionFactoryBean;
        import org.mybatis.spring.SqlSessionTemplate;
        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.boot.context.properties.ConfigurationProperties;
        import org.springframework.boot.jdbc.DataSourceBuilder;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.transaction.annotation.EnableTransactionManagement;

        import javax.sql.DataSource;

@Configuration
@MapperScan(value="com.jinny.java.springboot.multidb.mapper.denma", sqlSessionFactoryRef = "denmaSqlSessionFactory")
@EnableTransactionManagement
public class DenmaDabaseConfig {

    @Bean(name ="denmaDataSource")
    @ConfigurationProperties(prefix ="spring.denmamysql.datasource.hikari")
    public DataSource db1DataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name ="denmaSqlSessionFactory")
    public SqlSessionFactory reBuildSqlSessionFactory(@Qualifier("denmaDataSource") DataSource mysqlDataSource, ApplicationContext applicationContext)throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/denma/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name ="denmaSqlSessionTemplate")
    public SqlSessionTemplate reBuildSqlSessionTemplate(SqlSessionFactory db1SqlSessionFactory)throws Exception {

        return new SqlSessionTemplate(db1SqlSessionFactory);
    }

}

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
@MapperScan(value="com.nsuslab.denma.backend.migration.mapper.rebuild", sqlSessionFactoryRef = "reBuildSqlSessionFactory")
@EnableTransactionManagement
public class ReBuildDabaseConfig {

    @Bean(name ="reBuildDataSource")
    @ConfigurationProperties(prefix ="spring.rebuildmysql.datasource.hikari")
    public DataSource db1DataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name ="reBuildSqlSessionFactory")
    public SqlSessionFactory reBuildSqlSessionFactory(@Qualifier("reBuildDataSource") DataSource mysqlDataSource, ApplicationContext applicationContext)throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper.rebuild/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name ="reBuildSqlSessionTemplate")
    public SqlSessionTemplate reBuildSqlSessionTemplate(SqlSessionFactory db1SqlSessionFactory)throws Exception {

        return new SqlSessionTemplate(db1SqlSessionFactory);
    }

}

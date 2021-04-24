package org.xi.mybatis.session;

import org.dom4j.Document;
import org.dom4j.Element;
import org.xi.mybatis.config.Configuration;

import org.dom4j.io.SAXReader;
import org.xi.mybatis.model.MappedStatement;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class SqlSessionFactory {

    private final Configuration conf = new Configuration();

    public SqlSessionFactory() {
        loadDbInfo();
        loadMappersInfo();
    }

    public void loadDbInfo() {
        InputStream inputStream = SqlSessionFactory.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf.setUrl(properties.getProperty("jdbc.url"));
        conf.setUsername(properties.getProperty("jdbc.username"));
        conf.setPassword(properties.getProperty("jdbc.password"));
        conf.setDriver(properties.getProperty("jdbc.driver-class-name"));
    }

    public void loadMappersInfo() {
        URL resources = SqlSessionFactory.class.getClassLoader().getResource("mapper");
        File mappers = new File(resources.getFile());
        if (mappers.isDirectory()) {
            File[] files = mappers.listFiles();
            for (File mapperFile : files) {
                loadMapperInfo(mapperFile);
            }
        }
    }

    public void loadMapperInfo(File file) {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(file);
            Element mapperElement = document.getRootElement();
            String namespace = mapperElement.attributeValue("namespace");
            for (Element element : mapperElement.elements("select")) {
                MappedStatement mappedStatement = new MappedStatement();
                mappedStatement.setSourceId(namespace + "." + element.attributeValue("id"));
                mappedStatement.setResultType(element.attributeValue("resultType"));
                mappedStatement.setSql(element.getText());
                mappedStatement.setNamespace(namespace);
                conf.getStatementMap().put(mappedStatement.getSourceId(), mappedStatement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(conf);
    }
}

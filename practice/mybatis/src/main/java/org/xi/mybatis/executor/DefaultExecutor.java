package org.xi.mybatis.executor;

import org.xi.mybatis.config.Configuration;
import org.xi.mybatis.model.MappedStatement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class DefaultExecutor implements Executor {

    private Configuration conf;

    public DefaultExecutor(Configuration conf) {
        this.conf = conf;
    }

    @Override
    public <E> List<E> query(MappedStatement mappedStatement, Object params) {
        List<E> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(conf.getUrl(), conf.getUsername(), conf.getPassword());
             PreparedStatement ps = connection.prepareStatement(mappedStatement.getSql())) {
            if (params!= null)
                ps.setObject(1, params);

            Class clazz = Class.forName(mappedStatement.getResultType());
            Method[] methods = clazz.getMethods();

            try (ResultSet resultSet = ps.executeQuery()) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                Map<String, String> columnNames = new HashMap<>(rsmd.getColumnCount());
                for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
                    String columnName = rsmd.getColumnName(i);
                    columnNames.put(getSetMethodName(columnName), columnName);
                }
                while (resultSet.next()) {
                    E t = (E) clazz.newInstance();
                    for (Method method : methods) {
                        String column = columnNames.getOrDefault(method.getName(), null);
                        if (column == null) continue;
                        method.invoke(t, resultSet.getObject(column));
                    }
                    result.add(t);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    private String getSetMethodName(String columnName) {
        return "set" + Arrays.stream(columnName.split("_")).map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).collect(Collectors.joining(""));
    }
}

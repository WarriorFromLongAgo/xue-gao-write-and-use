package com.xuegao.reflection;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ReflectionUtil {
    public static void setProToBeanFromResult(Object entity, ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();

        int count = rsmd.getColumnCount();
        Field[] decfields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < count; i++) {
            String columnName = rsmd.getColumnName(i + 1).replace("_", "").toUpperCase();
            for (int j = 0; j < decfields.length; j++) {
                String filedName = decfields[j].getName().toUpperCase();
                if (columnName.equalsIgnoreCase(filedName)) {
                    String simpleName = decfields[j].getType().getSimpleName();
                    if (simpleName.equals("int")) {
                        setProToBean(entity, decfields[j].getName(), resultSet.getInt(rsmd.getColumnName(i + 1)));
                    } else if (simpleName.equals("String")) {
                        setProToBean(entity, decfields[j].getName(), resultSet.getString(rsmd.getColumnName(i + 1)));
                    }
                    break;
                }
            }
        }
    }

    private static void setProToBean(Object bean, String name, Object value) {
        try {
            Field field = bean.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(bean, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

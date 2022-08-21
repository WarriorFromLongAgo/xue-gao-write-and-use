package com.xuegao.minimybatis.datasource.unpooled;

import com.xuegao.minimybatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Clinton Begin
 */

/**
 * 没有池化的数据源工厂
 */
public class UnpooledDataSourceFactory implements DataSourceFactory {

  private static final String DRIVER_PROPERTY_PREFIX = "driver.";
  private static final int DRIVER_PROPERTY_PREFIX_LENGTH = DRIVER_PROPERTY_PREFIX.length();

  protected DataSource dataSource;

  public UnpooledDataSourceFactory() {
    this.dataSource = new UnpooledDataSource();
  }

  @Override
  public void setProperties(Properties properties) {
    Properties driverProperties = new Properties();
    for (Object key : properties.keySet()) {
      String propertyName = (String) key;
      //作为可选项,你可以传递数据库驱动的属性。要这样做,属性的前缀是以“driver.”开 头的,例如
      //driver.encoding=UTF8
      if (propertyName.startsWith(DRIVER_PROPERTY_PREFIX)) {
        String value = properties.getProperty(propertyName);
        driverProperties.setProperty(propertyName.substring(DRIVER_PROPERTY_PREFIX_LENGTH), value);
      } else {
        throw new RuntimeException("Unknown DataSource property: " + propertyName);
      }
    }
  }

  @Override
  public DataSource getDataSource() {
    return dataSource;
  }

}

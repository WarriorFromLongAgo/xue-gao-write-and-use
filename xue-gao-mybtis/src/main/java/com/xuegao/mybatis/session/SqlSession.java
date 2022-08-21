/*
 *    Copyright 2009-2011 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.xuegao.mybatis.session;

import java.io.Closeable;
import java.util.List;

/**
 * The primary Java interface for working with MyBatis.
 * Through this interface you can execute commands, get mappers and manage transactions.
 *
 * @author Clinton Begin
 */

/**
 * 这是MyBatis主要的一个类，用来执行SQL，获取映射器，管理事务
 *
 * 通常情况下，我们在应用程序中使用的Mybatis的API就是这个接口定义的方法。
 *
 */
public interface SqlSession extends Closeable {
  /**
   * Retrieve a single row mapped from the statement key
   * 根据指定的SqlID获取一条记录的封装对象
   * @param <T> the returned object type 封装之后的对象类型
   * @param statement sqlID
   * @return Mapped object 封装之后的对象
   */
  <T> T selectOne(String statement);
  /**
   * Retrieve a single row mapped from the statement key and parameter.
   * 根据指定的SqlID获取一条记录的封装对象，只不过这个方法容许我们可以给sql传递一些参数
   * 一般在实际使用中，这个参数传递的是pojo，或者Map或者ImmutableMap
   * @param <T> the returned object type
   * @param statement Unique identifier matching the statement to use.
   * @param parameter A parameter object to pass to the statement.
   * @return Mapped object
   */
  <T> T selectOne(String statement, Object parameter);
  /**
   * Retrieve a list of mapped objects from the statement key and parameter.
   * 根据指定的sqlId获取多条记录
   * @param <E> the returned list element type
   * @param statement Unique identifier matching the statement to use.
   * @return List of mapped object
   */
  <E> List<E> selectList(String statement);

  /**
   * Retrieves current configuration
   * 得到配置
   * @return Configuration
   */
  Configuration getConfiguration();
}

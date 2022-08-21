package com.xuegao.minimybatis.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A parameter handler sets the parameters of the {@code PreparedStatement}
 *
 * @author Clinton Begin
 */

/**
 * 参数处理器
 * 
 */
public interface ParameterHandler {

  //得到参数
  Object getParameterObject();

  //设置参数
  void setParameters(PreparedStatement ps)
      throws SQLException;

}

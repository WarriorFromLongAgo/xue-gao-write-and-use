/*
 *    Copyright 2009-2012 the original author or authors.
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
package com.xuegao.minimybatis.builder;

import com.xuegao.minimybatis.session.MiniConfiguration;

/**
 * @author Clinton Begin
 */

/**
 * 构建器的基类，建造者模式
 *
 */
public abstract class BaseBuilder {
  //需要配置，类型别名注册，类型处理器注册3个东西
  protected final MiniConfiguration miniConfiguration;

  public BaseBuilder(MiniConfiguration miniConfiguration) {
    this.miniConfiguration = miniConfiguration;
  }

  public MiniConfiguration getMiniConfiguration() {
    return miniConfiguration;
  }

}

/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2021-2022 the original author or authors.
 */
package org.quickperf.web.spring;

import org.quickperf.spring.sql.QuickPerfProxyBeanPostProcessor;
import org.quickperf.spring.sql.QuickPerfSqlConfig;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({ DataSource.class})
@ConditionalOnBean(DataSource.class)
// In testing, a QuickPerfProxyBeanPostProcessor bean may be already created
@ConditionalOnMissingBean(QuickPerfProxyBeanPostProcessor.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@Import(QuickPerfSqlConfig.class)
@ConditionalOnProperty(value = "quickperf.enabled")
public class DatasourceProxyAutoConfiguration {

}

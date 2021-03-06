/*
 * Copyright (c) 2019, AngBoot Technology Corp, All Rights Reserved.
 *
 * The software and information contained herein are copyrighted and
 * proprietary to AngBoot Technology Corp. This software is furnished
 * pursuant to a written license agreement and may be used, copied,
 * transmitted, and stored only in accordance with the terms of such
 * license and with the inclusion of the above copyright notice. Please
 * refer to the file "COPYRIGHT" for further copyright and licensing
 * information. This software and information or any other copies
 * thereof may not be provided or otherwise made available to any other
 * person.
 */

package org.angboot.config;

import org.angboot.authority.AuthorizationService;
import org.angboot.authority.UserService;
import org.angboot.util.conditional.ConditionalOnOuterAuthorityEnabled;
import org.apache.dubbo.config.ReferenceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional(ConditionalOnOuterAuthorityEnabled.class)
@Configuration
public class OuterAuthorityConfiguration extends AngBootDubboConfiguration {

   @Bean()
   public UserService userService() {
      ReferenceConfig<UserService> reference = new ReferenceConfig<>();
      reference.setApplication(applicationConfig());
      reference.setRegistry(registryConfig());
      reference.setInterface(UserService.class);
      // TODO reference version
//      reference.setVersion("1.0.0");

      return reference.get();
   }

   @Bean()
   public AuthorizationService authorizationService() {
      ReferenceConfig<AuthorizationService> reference = new ReferenceConfig<>();
      reference.setApplication(applicationConfig());
      reference.setRegistry(registryConfig());
      reference.setInterface(AuthorizationService.class);
      // TODO reference version
//      reference.setVersion("1.0.0");

      return reference.get();
   }
}

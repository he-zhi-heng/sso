# sso 单点登录服务
1. security配置登录获取token ,并进行访问请求过滤


common模块, 提供基础的通用方法,utils,pojo等

Authentication模块  该服务负责接收客户端的身份认证请求，并验证用户的身份。如果验证成功，则生成一个认证令牌返回给客户端
JWTCreateService 服务 该服务负责根据用户的身份信息生成一个JWT令牌，并将令牌存储在Redis中以供后续使用。
JWTVerificationService 模块  该服务负责从Redis中获取JWT令牌，并验证令牌的有效性和唯一性。如果验证成功，则认为用户已经通过身份认证，允许其访问受保护的资源
Authorization 模块 该服务负责检查客户端是否已经通过身份认证，如果是，则允许其访问受保护的资源；如果不是，则拒绝访问请求


认证模块：负责用户身份的认证和授权，包括使用 Auth0 进行身份验证和授权，以及将用户信息存储在 Redis 中。

jwtservice 
令牌生成模块：负责生成 JWT 令牌，并将其存储在 Redis 中。
令牌验证模块：负责验证 JWT 令牌的有效性，并根据令牌中的信息进行授权操作。

登录服务模块：负责处理用户的登录请求，包括使用 Spring Security Gateway 对请求进行鉴权，并根据用户的权限返回相应的结果。

集成式身份验证令牌生成和验证服务模块：负责集成 Spring Security 自带的令牌生成和验证功能，以便在其他模块中使用。

组件代码	组件名称	说明
cola-auth	认证组件	提供认证服务
cola-user	用户中心	提供用户服务
cola-security 安全中心	提供凭证验证等安全服务
cola-notify	通知中心	提供消息通知服务




全系统的日志收集系统: ELK(后期引入logstash依赖已经修改log文件即可)

全系统的后台管理系统: 


目标：实现一种可以在多个应用程序之间共享用户身份的方案。这种方案应该支持多种身份验证方式，包括但不限于 Google、OAuth 和 JWT。
需求：
（1）在多个应用程序之间共享用户身份信息。
（2）支持多种身份验证方式，包括 Google、OAuth 和 JWT。
（3）在登录过程中提供无缝的用户界面。
（4）支持 SAML 和 OAuth 等标准协议。
（5）应该提供集中式的管理控制台，以便管理多个应用程序之间的身份验证和授权。
（6）应该提供安全机制，以确保只有授权用户才能访问应用程序和数据。
（7）应该支持集成式的身份验证令牌生成和验证功能。
解决方案：基于 Spring Boot 2.7.6 和 Auth0 2.0 实现单点登录。在此方案中，用户可以使用多种身份验证方式，包括 Google、OAuth 和 JWT，在多个应用程序之间共享用户身份信息。该方案还支持 SAML 和 OAuth 等标准协议，并提供集中式的管理控制台。该方案提供安全机制，以确保只有授权用户才能访问应用程序和数据。该方案还支持集成式的身份验证令牌生成和验证功能。
关键组件：
（1）Spring Security：提供身份验证和授权功能。
（2）Spring Gateway：负责身份验证令牌的转发和 SAML 的 SAMLRequest 解析。
（3）Auth0：提供身份验证和授权服务。
（4）JWT：用于身份验证令牌的生成和验证。
实现步骤：
（1）创建一个服务端证书。
（2）配置 Spring Security 和 Spring Gateway。
（3）集成 Auth0 身份验证和授权服务。
（4）创建一个集成式身份验证令牌生成和验证服务。
（5）测试和部署。


系统架构：基于 Spring Boot 2.7.6 和 Spring Cloud 框架搭建。
技术栈：采用 Java 和 Spring Framework 技术栈，包括 Spring Security、Spring Boot Actuator、Spring Cloud Config 等。
数据库：采用 MySQL 数据库。
服务发现：采用 nacos进行服务发现。
认证：采用 Auth0 身份验证和授权服务。
令牌存储：采用 Redis 存储身份验证令牌。
令牌验证：采用 Spring Security 自带的令牌验证功能。
系统服务：包括登录服务（Spring Security Gateway）、身份验证服务（Auth0）、令牌存储服务（Redis）、令牌验证服务（Spring Security）等。
用户界面：采用 Bootstrap 框架进行页面设计和开发，提供多种登录方式，包括 Google、OAuth 和 JWT。
安全性：对用户的身份信息进行加密存储，并采用 JWT 进行令牌验证和授权。
日志和监控：使用 Logback 和 Prometheus 进行日志和监控。
集成式身份验证令牌生成和验证服务：采用 Spring Security 自带的令牌生成和验证功能，在 Auth0 身份验证和授权服务中进行集成。
部署方案：采用 Docker 容器化技术进行部署，并采用 Kubernetes 进行集群管理。
监控和报警：使用 Prometheus 进行监控，并使用 Slack 进行报警。

以下是基于Spring Security, Gateway, Redis, JWT的单点登录需求文档:

概述
单点登录系统是一种用于认证用户并授权其访问受保护资源的系统。该系统集成了Spring Security, Gateway, Redis和JWT等功能，实现了用户凭证的安全管理和身份认证。该系统将为多个应用程序提供统一的认证和授权服务，从而简化用户认证过程，并提高系统的安全性。

目标
单点登录系统的目标是:

简化用户认证过程
减少用户密码的存储量
提高系统的安全性
简化应用程序之间的集成
功能
单点登录系统应具有如下功能:

用户注册和管理
单点登录和会话管理
安全令牌颁发和管理
角色和权限的管理
安全性检查和过滤

技术
单点登录系统应采用以下技术:

Spring Security:提供强大的安全特性和认证功能
Gateway:提供URL路由和请求转发功能
Redis:用于缓存用户凭证和会话信息
JWT:用于安全地传输用户凭证
实施步骤
单点登录系统的实施步骤如下:

安装和配置Spring Security和Gateway
创建Redis缓存桶，并将用户凭证和会话信息保存在其中
创建和使用JWT证书，并将其与Redis缓存桶关联起来
在应用程序中使用Spring Security进行认证和授权
部署和配置单点登录系统
集成其他应用程序和客户端
风险分析
单点登录系统存在的风险包括:

数据泄露或篡改
系统漏洞被利用
未经授权的访问
为了降低这些风险，单点登录系统应采取以下措施:

使用安全的加密算法进行数据传输和存储
定期更新系统和软件补丁
实施访问控制和身份验证机制
监控和分析系统活动以检测异常行为
总结
单点登录系统是一种重要的安全工具，可用于简化用户认证和提高系统安全性。它应该按照以上要求设计和实施，以确保最佳的用户体验和系统性能。

基于Spring Security, Gateway, Redis, JWT的单点登录系统设计方案如下:

数据库设计
我们将使用MySQL作为我们的数据库，并创建以下表:

users:存储用户的身份信息和其他相关信息
sessions:存储用户的会话信息，如登录时间、过期时间等
roles:存储用户的角色信息
permissions:存储用户拥有的权限信息
框架配置
我们将使用Spring Security来进行单点登录的认证和授权，并通过Gateway来实现URL路由和请求转发功能。我们将使用Redis来缓存用户凭证和会话信息。同时，我们将使用JWT来安全地传输用户凭证。

应用程序集成
我们将使用Spring Boot来开发单点登录系统的应用，并在其中集成Spring Security进行认证和授权。我们还将使用Gateway来处理HTTP请求，并根据需要进行相应的处理。我们还将通过JWT证书将用户凭证安全地传输到其他应用程序中。

部署和配置
我们将部署单点登录系统，并进行必要的配置，如端口号、SSL证书等。同时，我们将集成其他应用程序和客户端，以实现更好的用户体验。

风险管理
我们将采取一系列措施来降低单点登录系统存在的风险，如使用安全的加密算法进行数据传输和存储、定期更新系统和软件补丁、实施访问控制和身份验证机制以及监控和分析系统活动以检测异常行为等。



基于Spring Security, Gateway, Redis, JWT的单点登录系统模块设计方案如下:

用户注册和管理系统

用户可以注册账户并提供身份信息和其他相关信息
管理员可以管理用户账户和设置相关属性
用户可以修改自己的账户信息和密码
管理员可以为新用户分配角色和权限
用户可以查看自己拥有的角色和权限
管理员可以随时删除用户账户

单点登录和会话管理
用户可以通过输入URL进行单点登录
系统会为每个用户生成唯一的令牌，并与用户凭证一起存储在Redis中
用户可以通过令牌进行后续操作，如访问资源、发送消息等
当令牌过期后，系统会自动为用户重新生成令牌
管理员可以随时清除用户的令牌和会话信息

安全令牌颁发和管理
系统可以生成和颁发安全令牌，以供用户访问受保护的资源
系统可以使用JWT格式的安全令牌，以保证令牌的真实性和完整性
系统可以对令牌进行签名和验签，以确保令牌不被伪造或篡改
系统可以将令牌发送给用户，以便他们在后续的交互中使用

角色和权限管理
系统可以定义用户的角色和权限
用户可以添加和编辑自己的角色和权限
用户可以根据需要授予其他用户特定角色和权限
系统可以为每个角色和权限指定默认值，以便快速启用和配置

安全性检查和过滤
系统可以对用户提交的任何请求进行检查和过滤，以确保它们符合系统的安全性要求
系统可以限制对敏感数据的访问，并对可能的攻击进行防范
系统可以提供错误提示和警告，帮助管理员识别和处理安全问题



在设计单点登录服务时，各个模块之间的数据交互和通讯方式应该根据具体的需求和场景来确定。以下是一些常见的数据交互和通讯方式：

HTTP协议：HTTP协议是一种常用的网络通信协议，可以用于各个模块之间的数据交互和通讯。您可以使用RESTful API或WebSocket等技术实现HTTP协议的数据传输。

Redis:Redis是一种高性能的内存数据库，可以用于缓存用户信息、验证码等数据，从而提高系统的性能和响应速度。您可以使用Redis作为各个模块之间的数据共享和存储介质。

MongoDB:MongoDB是一种非关系型数据库，可以用于存储和管理用户信息、安全日志等数据。您可以使用MongoDB作为各个模块之间的数据共享和存储介质。

Kafka:Kafka是一种分布式的消息队列系统，可以用于异步处理和传递消息。您可以使用Kafka作为各个模块之间的异步通信机制，例如将验证结果、通知消息等异步发送给用户中心。

需要注意的是，不同的数据交互和通讯方式都有各自的优缺点和适用场景，您需要根据具体的业务需求和技术选型来选择合适的方案。同时，为了保证系统的安全性和稳定性，建议采用安全可靠的通信协议和加密技术，例如HTTPS、SSL/TLS等。

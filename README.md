# Spring Platform
_Spring Boot_ multi-module _Gradle_ project.

![Architecture](./docs/images/architecture.svg)


## Modules
### Spring Platform Dependencies
Manages shared dependency versions.

### Spring Platform Spring Boot Starter
Provides _Spring_ default configurations.

### Proto
Defines shared _Protocol Buffers_ (.proto) definitions.

### Gateway
Handles routing.

### Notification
Manages notifications using a **3-layer architecture**.
Expose _GraphQL_ endpoint and uses MongoDB for data persistence.

### Storage
Handles the storage, deletion, and updating of files using a **hexagonal architecture**.

## Features
### Native images
Enable native images build by setting the native property in the `gradle.properties` file 
or running gradle command with property flag `-Pnative=true`.

### Virtual Thread
```properties
spring.threads.virtual.enabled=true
```

### Security
### RBAC
By default, _Spring_ expects roles to be prefixes with `ROLE_`.

### Observability
https://opentelemetry.io/docs/zero-code/java/spring-boot-starter/getting-started/

## References
- [Creating a Multi Module Gradle Project](https://spring.io/guides/gs/multi-module)
- [Gradle Version Catalogs](https://docs.gradle.org/current/userguide/version_catalogs.html)
- [Gradle Platform](https://docs.gradle.org/current/userguide/platforms.html)
- [Checkstyle](https://checkstyle.org/)
- [Spring Boot Tracing](https://docs.spring.io/spring-boot/reference/actuator/tracing.html#actuator.micrometer-tracing.tracer-implementations.otel-otlp)
- [Spring Boot Virtual Threads](https://docs.spring.io/spring-boot/reference/features/spring-application.html#features.spring-application.virtual-threads)
- [Spring Security OAuth2 Resource Server](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/index.html)
- [Spring GRPC](https://docs.spring.io/spring-grpc/reference/index.html)

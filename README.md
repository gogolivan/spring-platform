# Spring Platform
_Spring Boot_ multi-module _Gradle_ project.

![System Architecture Dark](./docs/images/system-architecture-dark.svg#gh-dark-mode-only)
![System Architecture Light](./docs/images/system-architecture-light.svg#gh-light-mode-only)

## Native images
Enable native images build by setting the native property in the `gradle.properties` file 
or running gradle command with property flag `-Pnative=true`.

## Virtual Thread
```properties
spring.threads.virtual.enabled=true
```

## Spring Security
### RBAC
By default, _Spring_ expects roles to be prefixes with `ROLE_`.

## Observability
https://opentelemetry.io/docs/zero-code/java/spring-boot-starter/getting-started/

## Best Practices
- Use environment variables with defaults in _Spring_ properties
- Centralized version management using *Gradle* catalog `gradle/libs.versions.toml`

## References
- [Creating a Multi Module Gradle Project](https://spring.io/guides/gs/multi-module)
- [Gradle Version Catalogs](https://docs.gradle.org/current/userguide/version_catalogs.html)
- [Gradle Platform](https://docs.gradle.org/current/userguide/platforms.html)
- [Spring Boot Tracing](https://docs.spring.io/spring-boot/reference/actuator/tracing.html#actuator.micrometer-tracing.tracer-implementations.otel-otlp)
- [Spring Boot Virtual Threads](https://docs.spring.io/spring-boot/reference/features/spring-application.html#features.spring-application.virtual-threads)
- [Spring Security OAuth2 Resource Server](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/index.html)
- [Spring GRPC](https://docs.spring.io/spring-grpc/reference/index.html)
# Spring Platform
_Spring Boot_ multi-module _Gradle_ project.

![System Architecture Dark](./docs/images/system-architecture-dark.svg#gh-dark-mode-only)
![System Architecture Light](./docs/images/system-architecture-light.svg#gh-light-mode-only)

## Modules
### spring-platform-dependencies
### spring-platform-spring-boot-starter
### proto
### gateway
### notification
### storage

## Best Practices
- Use environment variables with defaults in _Spring_ properties
- Centralized version catalog `gradle/libs.versions.toml`

## References
- [Creating a Multi Module Gradle Project](https://spring.io/guides/gs/multi-module)
- [Gradle Version Catalogs](https://docs.gradle.org/current/userguide/version_catalogs.html)
- [Gradle Platform](https://docs.gradle.org/current/userguide/platforms.html)
- [Spring Boot Tracing](https://docs.spring.io/spring-boot/reference/actuator/tracing.html#actuator.micrometer-tracing.tracer-implementations.otel-otlp)
- [Spring GRPC](https://docs.spring.io/spring-grpc/reference/index.html)
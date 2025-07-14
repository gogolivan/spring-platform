package com.github.gogolivan.springplatform.storage;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

@AnalyzeClasses(packages = "com.github.gogolivan.springplatform.storage")
public class ArchitectureTest {

    private final JavaClasses CLASSES = new ClassFileImporter().importPackages(
            "com.github.gogolivan.springplatform.storage");


    /**
     * A rule that checks that none of the given classes access Java Util Logging.
     */
    @ArchTest
    public static final ArchRule FIELD_INJECTION_SHOULD_NOT_BE_USED = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    /**
     * A rule that checks that none of the given classes access the standard streams System.out and System.err.
     */
    @ArchTest
    public static final ArchRule STANDARD_OUTPUT_STREAMS_SHOULD_NOT_BE_USED = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;


    @Test
    public void onion_architecture_is_respected() {
        onionArchitecture()
                .domainModels("..domain.model..")
                .domainServices("..domain.port..")
                .applicationServices("..application..")
                .adapter("filesystem", "..adapter.filesystem..")
                .adapter("jpa", "..adapter.jpa..")
                .adapter("s3", "..adapter.s3..")
                .adapter("rest", "..adapter.rest..")
                .adapter("grpc", "..adapter.grpc..")
                .check(CLASSES);
    }
}

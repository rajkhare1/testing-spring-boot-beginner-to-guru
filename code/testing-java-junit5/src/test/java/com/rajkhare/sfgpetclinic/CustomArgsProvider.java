package com.rajkhare.sfgpetclinic;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomArgsProvider implements ArgumentsProvider {


    @Override
   public Stream<? extends Arguments> provideArguments(@SuppressWarnings("unused") ExtensionContext context)
            throws Exception {
        return Stream.of(
                Arguments.of("FL", 7, 10),
                Arguments.of("OH", 11, 8),
                Arguments.of("MI", 13, 5)
        );
    }

}

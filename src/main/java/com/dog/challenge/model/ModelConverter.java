package com.dog.challenge.model;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * @author sfe
 */
public class ModelConverter {

    //Expected ModelList will contain the following
    //  - Model(dog01, dog2)
    //  - Model(dog03, dog4)
    public static List<Model> convertDataToModelList(@NotNull String dogString) {
        return  Arrays.stream(dogString.split("\\n"))
                .map(line -> line.split(";"))
                .filter(arr -> arr.length == 2) // Assumption: exclude too small and too large arrays (too small -> at least one value is null)
                .filter(arr -> arr[0].length() > 0 && arr[1].length() > 0)
                .map(arr -> new Model(arr[0], arr[1]))
                .toList();
    }
}

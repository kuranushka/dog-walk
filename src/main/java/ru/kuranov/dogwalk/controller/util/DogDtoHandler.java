package ru.kuranov.dogwalk.controller.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.addition.Gender;
import ru.kuranov.dogwalk.model.entity.addition.PullingLeash;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DogDtoHandler {


    public DogDto updateDogDto(DogDto dogDto) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        dogDto.setDogDocuments(
                updateProperties(dogDto.getDogDocuments()));

//        dogDto.setGender(
//                updateProperties(Arrays.stream(Gender.values())
//                        .map(Gender::getName)
//                        .collect(Collectors.toList()), dogDto.getReturnedGender()));

        dogDto.setGender(updateProperties(Gender.class, dogDto.getReturnedGender()));
        dogDto.setPullingLeash(updateProperties(PullingLeash.class, dogDto.getReturnedPullingLeash()));


//        dogDto.setPullingLeash(
//                updateProperties(Arrays.stream(PullingLeash.values())
//                        .map(PullingLeash::getName)
//                        .collect(Collectors.toList()), dogDto.getReturnedPullingLeash()));
        return dogDto;
    }

    private Map<String, Boolean> updateProperties(Map<String, Boolean> properties) {
        return properties.entrySet().stream().map(entry -> {
            if (entry.getValue() == null) {
                entry.setValue(false);
            } else {
                entry.setValue(entry.getValue());
            }
            return entry;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, Boolean> updateProperties(Class<? extends Enum> type, String property) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {


//        Class<?> c = Class.forName(type.getName());
//        Object[] objects = c.getEnumConstants();
//        for (Object obj : objects) {
//            try {
//                Field keyField = obj.getClass().getDeclaredField("name");
//                keyField.setAccessible(true);
//                String sstr = keyField.get(obj).toString();
//            } catch (NoSuchFieldException e) {
//                System.out.println("value : " + obj);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }


        Object[] values = type.getEnumConstants();
        Field field = type.getDeclaredField("name");
        field.setAccessible(true);
        Map<String, Boolean> properties = new HashMap<>();
        for (Object obj : values) {
            if (field.get(obj).toString().equals(property)) {
                properties.put(field.get(obj).toString(), true);
            } else {
                properties.put(field.get(obj).toString(), false);
            }
        }
        return properties;
    }


//    private Map<String, Boolean> updateProperties(List<String> values, String property) {
//        Map<String, Boolean> properties = values.stream()
//                .collect(Collectors.toMap(key -> key, value -> false));
//        for (Map.Entry<String, Boolean> entry : properties.entrySet()) {
//            if (entry.getKey().equals(property)) {
//                entry.setValue(true);
//            }
//        }
//        return properties;
//    }
}
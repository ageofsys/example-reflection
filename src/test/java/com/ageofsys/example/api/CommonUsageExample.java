package com.ageofsys.example.api;

import com.ageofsys.example.case1.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("리플렉션 일반")
public class CommonUsageExample {

    /**
     * 1. .class 이용하기: 클래스에서 클래스 인스턴스 획득하기
     * 2. Object::getClass 메소드 이용하기: 인스턴스에서 클래스 인스턴스 획득하기
     * 3. Class.forName 메소드 이용하기: 클래스 존재 여부를 확정할 수 없을때 FQCN으로 클래스 인스턴스 획득하기
     */
    @Test
    @DisplayName("클래스 인스턴스 생성하기")
    void createClassInstance() {

        // .class 이용하기
        Class<Car> carClass = Car.class;
        assertNotNull(carClass);

        // Object::getClass 메소드 이용하기
        Car car = new Car();
        Class<? extends Car> aClass = car.getClass();
        assertNotNull(aClass);

        // Class.forName 메소드 이용하기
        try {
            Class<?> aClass1 = Class.forName("com.ageofsys.example.case1.Car");
            assertNotNull(aClass1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.example.learn.test;

import com.example.learn.anno.SimpleAnnotation;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/27 10:11
 */
public class Test1 {

    public static void main(String[] args) {
       testMethod();
    }

    @SimpleAnnotation("testStringValue")
    public static void testMethod(){
        //do something here
    }

    private static void annotationLogic() throws Exception{

        Class useAnnotationClass = Test1.class;
        for(Method method : useAnnotationClass.getMethods()) {
            SimpleAnnotation simpleAnnotation = (SimpleAnnotation)method.getAnnotation(SimpleAnnotation.class);
            if(simpleAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" value : " + simpleAnnotation.value());
                System.out.println(" --------------------------- ");
            }
        }
    }

}

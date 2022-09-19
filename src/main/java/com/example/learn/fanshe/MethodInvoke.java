package com.example.learn.fanshe;

import java.lang.reflect.Method;

public class MethodInvoke {
    public static void main(String[] args) throws Exception {
        // Method animalMethod = Animal.class.getDeclaredMethod("print",new Class[]{String.class});
        // System.out.println("animalMethod = " + animalMethod);
        // Animal animal = new Animal();
        // animalMethod.invoke(animal,"yellow");
        // Cat cat = new Cat();
        // Method catMethod = Cat.class.getDeclaredMethod("print", String.class);
        // catMethod.invoke(cat, "blue");
        // catMethod.invoke(animal, "yellow");
        Animal.inner inner = new Animal.inner("张师傅",12);
        System.out.println("inner.getInnerName() = " + inner.getInnerName());


        //
        // Method catMethod = Cat.class.getDeclaredMethod("print");
        //
        // Animal animal = new Animal();
        // Cat cat = new Cat();
        // animalMethod.invoke(cat,"yellow");
        // animalMethod.invoke(animal,"blue");
        //
        // catMethod.invoke(cat);
        // catMethod.invoke(animal);
        // Animal animal = new Animal();
        // Method[] methods = Animal.class.getDeclaredMethods();
        // for (Method method : methods) {
        //     method.setAccessible(true);
        //     int modifiers = method.getModifiers();
        //     Class<?>[] parameterTypes = method.getParameterTypes();
        //
        //     if (parameterTypes.length == 1){
        //         // method.invoke(animal,method.getName()+"yellow");
        //         method.invoke(method.getName()+"yellow");
        //     }
        // }

    }

}

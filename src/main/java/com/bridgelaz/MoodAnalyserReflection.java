package com.bridgelaz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserReflection {

    public static ToMoodAnalyses createMoodAnalyser(String message){
        try {
            Class.forName("com.bridgelaz.ToMoodAnalyses");
            Constructor<?> constructor = Class.forName("com.bridgelaz.ToMoodAnalyses").getConstructor(String.class);
            Object myobj = constructor.newInstance(message);
            return (ToMoodAnalyses) myobj;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor getConstructor(Class<?>... parameter) {
        try {
            Class.forName("com.bridgelaz.ToMoodAnalyses");
            Constructor<?> constructor = Class.forName("com.bridgelaz.ToMoodAnalyses").getConstructor(parameter);
            return constructor;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Object getObject(Constructor constructor, String... message){

        try {
            //Class.forName("com.bridgelaz.ToMoodAnalyses");
            //Constructor<?> constructor = Class.forName("com.bridgelaz.ToMoodAnalyses").getConstructor(String.class);
            Object myobj = constructor.newInstance(message);
            return (ToMoodAnalyses)myobj;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Method getMethod(String message) throws NoSuchMethodException {
        Constructor constructor = getConstructor();
        Object object = getObject(constructor);
        Method method = object.getClass().getDeclaredMethod(message,String.class);
        return method;

    }
}

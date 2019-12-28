package com.bridgelaz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;

public class MoodAnalyserFacory {

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
}

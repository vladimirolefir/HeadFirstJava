package com.headfirstjava;

/*
You must put a class into a directory structure that matches the package hierarchy
javac -d ../classes com/headfirstjava/PackageExercise.java
javac -d ../classes com/headfirstjava/*.java
java com.headfirstjava.PackageExercise # to execute from classes folder

# to create executable jar with package use this command from classes folder: jar -cvmf manifest.txt packEx.jar com

# jar commands for listing and extracting.
jar -tf packEx.jar # -tf stands for ‘Table File’ as in “show me a table of the JAR file”
jar -xf packEx.jar # extract the contents of a JAR (i.e. unjar). -xf stands for ‘Extract File’ and it works just like unzipping or untarring.
                   # If you extract the packEx.jar, you’ll see the META-INF directory and the com directory in your current directory
* */
public class PackageExercise {
    public static void main(String[] args) {
        System.out.println("I Rule!");
        System.out.println("The World");
    }
}
package com.agents;

/*
You must put a class into a directory structure that matches the package hierarchy
javac -d ../classes com/headfirstjava/PackageExercise.java
javac -d ../classes com/headfirstjava/*.java
java com.headfirstjava.PackageExercise # to execute from classes folder

# to create executable jar with package use this command from classes folder: jar -cvmf manifest.txt packEx.jar com

# jar commands for listing and extracting.
jar -tf packEx.jar # -tf stands for 'Table File' as in "show me a table of the JAR file"
jar -xf packEx.jar # extract the contents of a JAR (i.e. unjar). -xf stands for 'Extract File' and it works just like unzipping or untarring.
                   # If you extract the packEx.jar, you’ll see the META-INF directory and the com directory in your current directory

create MANIFESR.MF file with:
Manifest-Version: 1.0
PreMain-Class: com.agents.Agent007

javac -d ../classes com/agents/Agent007.java
ar -cvmf manifest.mf packagents.jar com
javac -d ../classes com/agents/AgentTester.java
java -javaagent:packagents.jar com/agents/AgentTester

* */
public class Agent007 {
    public static void premain(String args) {
        System.out.println("Hello! I`m java agent");
    }
}
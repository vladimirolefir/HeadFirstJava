package com.agents;

import java.lang.instrument.Instrumentation;

public class AgentCounter {
    public static void premain(String agentArgument, Instrumentation instrumentation) {
        System.out.println("Agent Counter");
        instrumentation.addTransformer(new ClassTransformer());
    }
}
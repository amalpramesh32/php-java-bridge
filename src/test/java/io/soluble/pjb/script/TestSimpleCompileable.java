package io.soluble.pjb.script;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngineManager;

import junit.framework.TestCase;

public class TestSimpleCompileable extends TestCase {

    private CompiledScript script;

    public TestSimpleCompileable(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        script = ((Compilable) (new ScriptEngineManager().getEngineByName("php"))).compile(
                "<?php echo 'Hello '.java_context()->get('hello').'!'; ?>");
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void test() throws Exception {
        script.getEngine().put("hello", "world!");
        script.eval();
        script.getEngine().put("hello", String.valueOf(this));
        script.eval();
    }
}

package org.sebi;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 2/27/13
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class ScaffoldTests extends TestCase {

    public void testDefaultStringRenderer() throws Exception{
        Scaffolder scaffolder = new Scaffolder();
        Map root = new HashMap();
        root.put("widgetType","String");
        scaffolder.setRoot(root);
        scaffolder.initConfig();
        scaffolder.createEngineAndFlush();
        assertEquals(scaffolder.getOutput().trim(),"I am the default string renderer");
    }

    public void testCustomStringRenderer() throws Exception{

        Scaffolder scaffolder = new Scaffolder();
        Map root = new HashMap();
        root.put("widgetType","String");
        scaffolder.setRoot(root);
        scaffolder.initConfig();

        //here we overload the default renderer with our renderer
        scaffolder.overrideDefaultRenderer("custom.tpl");
        scaffolder.createEngineAndFlush();
        assertEquals(scaffolder.getOutput().trim(),"I am the custom string renderer");
    }

    public void testDefaultDateRenderer() throws Exception{
        Scaffolder scaffolder = new Scaffolder();
        Map root = new HashMap();
        root.put("widgetType","Date");
        scaffolder.setRoot(root);
        scaffolder.initConfig();
        scaffolder.createEngineAndFlush();
        assertEquals(scaffolder.getOutput().trim(),"I am the default date renderer");
    }

    public void testCustomDateRenderer() throws Exception{

        Scaffolder scaffolder = new Scaffolder();
        Map root = new HashMap();
        root.put("widgetType","Date");
        scaffolder.setRoot(root);
        scaffolder.initConfig();

        //here we overload the default renderer with our renderer
        scaffolder.overrideDefaultRenderer("custom.tpl");
        scaffolder.createEngineAndFlush();
        assertEquals(scaffolder.getOutput().trim(),"I am the custom date renderer");
    }



}



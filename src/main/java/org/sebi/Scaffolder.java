package org.sebi;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 2/27/13
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class Scaffolder {

    private Configuration cfg = new Configuration();

    private Map root = new HashMap();

    private String output;

    public void createEngineAndFlush() throws  Exception{
        Template template;
        template = cfg.getTemplate("main.tpl");
        Writer out = new StringWriter();
        template.process(getRoot(),out);
        output = out.toString();

    }

    public void initConfig() {
        cfg.setClassForTemplateLoading(getClass(), "/templates");
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        cfg.addAutoImport("renderer","renderer.tpl");
        cfg.addAutoImport("selector","selector.tpl");
    }

    public void overrideDefaultRenderer(String template){
        cfg.addAutoImport("renderer",template);
    }


    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Map getRoot() {
        return root;
    }

    public void setRoot(Map root) {
        this.root = root;
    }

    public Configuration getCfg() {
        return cfg;
    }

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }

}

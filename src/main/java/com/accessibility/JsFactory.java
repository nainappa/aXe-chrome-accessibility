package com.accessibility;

import java.io.IOException;

import org.jsoup.Jsoup;


class JsFactory {

    ApplicationProperties applicationProperties;

    private static JsFactory INSTANCE = null;
    private String accessibility_content = null;

    private String jquery_content = null;

    private JsFactory() {
        try {
            this.applicationProperties = new ApplicationProperties("application.properties");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    synchronized static JsFactory getInstance() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new JsFactory();
            INSTANCE.load();
        }
        return INSTANCE;
    }

    private void load() throws IOException {
        jquery_content = Jsoup.connect(applicationProperties.getProperty("jquerycdnurl")).ignoreContentType(true).execute().body();
        accessibility_content = Jsoup.connect(applicationProperties.getProperty("applicationcdnurl")).ignoreContentType(true).execute().body();
    }

    String getAccessibility_content() {
        return accessibility_content;
    }

    String getJquery_content() {
        return jquery_content;
    }

}

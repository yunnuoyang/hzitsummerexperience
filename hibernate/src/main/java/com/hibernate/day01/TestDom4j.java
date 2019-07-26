package com.hibernate.day01;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;

public class TestDom4j {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = TestDom4j.class.getResourceAsStream("/goods.hbm.xml");
        Document rootNode = saxReader.read(inputStream);
        Element rootElement = rootNode.getRootElement();
        System.out.println(rootElement.getName());
//        Configuration

    }
}

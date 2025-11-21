package com.pan.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/4/3 17:30
 */
public class Test01 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        // 获取文件的路径
        String path = Test01.class.getClassLoader().getResource("test.xml").getPath();
        File file = new File(path);
        // 加载为Document对象
        Document document = documentBuilder.parse(file);
        // 获取文档基本属性
//        String xmlVersion = document.getXmlVersion();
//        String xmlEncoding = document.getXmlEncoding();
//        boolean xmlStandalone = document.getXmlStandalone();

        Element message = document.getDocumentElement();
        NodeList childNodes = message.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Element element = (Element) childNodes.item(i);
            String nodeName = element.getNodeName();
            String nodeValue = element.getNodeValue();
            System.out.println("nodeName: " + nodeName + " nodeValue: " + nodeValue);
        }


        System.out.println();
    }
}

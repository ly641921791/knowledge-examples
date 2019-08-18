package com.github.ly641921791.spring.web.servlet.http.message.converter.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "user")
public class User {

    @JacksonXmlProperty(localName = "id")
    private Long id;
    @JacksonXmlProperty(localName = "name")
    private String name;

}

package com.demo.soapwebservice.controller;

import com.demo.soapwebservice.details.GetCourseDetailsRequest;
import com.demo.soapwebservice.details.GetCourseDetailsResponse;
import com.demo.soapwebservice.service.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Endpoint
public class CourseDetailsController {

    @Autowired
    SoapService soapService;

    @PayloadRoot(namespace = "http://demo.com/details", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse getCourseDetailsResponse(@RequestPayload GetCourseDetailsRequest request) {
        return soapService.getCourseDetailsResponse(request.getId());
    }

    @Bean(name = "courses1")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setPortTypeName("CoursePort");
        defaultWsdl11Definition.setTargetNamespace("http://demo.com/details");
        defaultWsdl11Definition.setSchema(schema);
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema schema() {
        return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
    }

}

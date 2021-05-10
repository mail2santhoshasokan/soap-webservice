package com.demo.soapwebservice.service.impl;

import com.demo.soapwebservice.details.GetCourseDetailsResponse;
import com.demo.soapwebservice.exception.CourseNotFoundException;
import com.demo.soapwebservice.service.SoapService;
import org.springframework.stereotype.Component;

@Component
public class SoapServiceImpl implements SoapService {

    @Override
    public GetCourseDetailsResponse getCourseDetailsResponse(int id) {
        GetCourseDetailsResponse getCourseDetailsResponse = new GetCourseDetailsResponse();
        if (id == 1) {
            getCourseDetailsResponse.setId(1);
            getCourseDetailsResponse.setName("Hi There!");
        } else {
            throw new CourseNotFoundException("Course not found");
        }

        return getCourseDetailsResponse;
    }
}

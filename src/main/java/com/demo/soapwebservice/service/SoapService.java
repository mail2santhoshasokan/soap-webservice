package com.demo.soapwebservice.service;

import com.demo.soapwebservice.details.GetCourseDetailsResponse;
import org.springframework.stereotype.Service;

@Service
public interface SoapService {

    GetCourseDetailsResponse getCourseDetailsResponse(int id);

}

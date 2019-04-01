package com.sam.mongo.util;


import com.sam.mongo.model.Response;

public class Utility {

        public static <T> Response<T> createResponse(T obj, String message, String code){
            Response<T> response = new Response<T>();
            response.setResponseObject(obj);
            response.setResponseCode(code);
            response.setResponseMessage(message);
            return response;
        }
    }

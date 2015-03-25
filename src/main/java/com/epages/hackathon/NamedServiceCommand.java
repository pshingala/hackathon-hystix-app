package com.epages.hackathon;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * I am an HystrixCommand executing services. Each service runs in a Hystrix
 * thread pool name with the service name
 */
public class NamedServiceCommand extends HystrixCommand<String> {

    private NamedService service;

    public NamedServiceCommand(NamedService service) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(service.getName())));
        this.service = service;
    }

    @Override
    protected String run() throws Exception {
        return this.service.execute();
    }
    
    @Override
    protected String getFallback() {
        return "falback " + service.getName();
    }

}

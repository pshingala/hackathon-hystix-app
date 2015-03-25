package com.epages.hackathon;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * I am an HystrixCommand executing services.
 * Each service runs in a Hystrix thread pool name with the service name
 */
public class NamedServiceCommand extends HystrixCommand<String> {

    private NamedService service;

    public NamedServiceCommand(NamedService service) {
        super(HystrixCommandGroupKey.Factory.asKey(service.getName()));
        this.service = service;
    }

    @Override
    protected String run() throws Exception {
        return this.service.execute();
    }

}

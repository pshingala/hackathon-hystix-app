package com.epages.hackathon;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class ParameterizedHandler implements Handler {

    private final NamedService service;

    public ParameterizedHandler(NamedService service) {
        this.service = service;
    }

    @Override
    public void handle(Context context) throws Exception {
        final NamedServiceCommand namedServiceCommand = new NamedServiceCommand(service);
        final String value = namedServiceCommand.execute();
        context.getResponse().send("service value: " + value);
    }

}

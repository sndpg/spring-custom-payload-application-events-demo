package io.github.sndpg.events;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.core.ResolvableType;

public class MyCustomPayloadApplicationEvent<T> extends PayloadApplicationEvent<T> {

    /**
     * Create a new PayloadApplicationEvent.
     *
     * @param source  the object on which the event initially occurred (never {@code null})
     * @param payload the payload object (never {@code null})
     */
    public MyCustomPayloadApplicationEvent(Object source, T payload) {
        super(source, payload);
    }

    // workaround for java.lang.IllegalArgumentException: Mismatched number of generics specified for public class io.github.sndpg.events.MyCustomPayloadApplicationEvent
//    @Override
//    public ResolvableType getResolvableType() {
//        return ResolvableType.forClass(MyCustomPayloadApplicationEvent.class);
//    }

}

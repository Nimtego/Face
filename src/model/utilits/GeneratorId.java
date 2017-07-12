package model.utilits;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by myasnikov
 * on 12.07.2017.
 */
public class GeneratorId {
    private static AtomicLong idCounter = new AtomicLong();

    public static long createSerialNumber() {
        return idCounter.getAndIncrement();
    }
}

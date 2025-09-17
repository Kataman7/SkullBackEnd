package main.utils;

import org.sqids.Sqids;

import java.util.Arrays;

public class IdGenerator
{
    @Override
    public String toString() {

        Sqids sqids=Sqids.builder()
                .minLength(10)
                .build();

        return sqids.encode(Arrays.asList(1L,2L,3L));
    }
}

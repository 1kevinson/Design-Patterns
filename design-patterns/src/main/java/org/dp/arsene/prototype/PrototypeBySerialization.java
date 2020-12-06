package org.dp.arsene.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;


/**
 * More convenient way is to copy through serialization
 * */
public class PrototypeBySerialization {

    public static void main(String[] args) {
        final Foo foo = new Foo("oneT", "another");
        final var foo2 = SerializationUtils.roundtrip(foo);

        foo2.another = "jjk";

        System.out.println(foo);
        System.out.println(foo2);
    }

}


class Foo implements Serializable {
    public String oneThing, another;

    public Foo(String oneThing, String another) {
        this.oneThing = oneThing;
        this.another = another;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "oneThing='" + oneThing + '\'' +
                ", another='" + another + '\'' +
                '}';
    }
}
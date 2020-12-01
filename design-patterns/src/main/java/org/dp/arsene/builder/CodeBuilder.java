package org.dp.arsene.builder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CodeBuilder {

    public String className;
    public Map<String, String> fields = new HashMap<>();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        fields.putIfAbsent(name, type);
        return this;
    }

    @Override
    public String toString() {
        return toStringImpl();
    }

    private String toStringImpl() {
        final int indentSize = 2;
        final var newLine = System.lineSeparator();
        final var i = String.join("", Collections.nCopies(indentSize, " "));
        final String classRef = "public class";
        final String delimiter = ";";

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s %s%s", classRef, className, newLine));
        stringBuilder.append(String.format("{%s", newLine));

        for (Map.Entry<String, String> entry : fields.entrySet()) {
            stringBuilder.append(String.format("%s%s %s %s%s%s", i, "public", entry.getValue(), entry.getKey(), delimiter, newLine));
        }

        stringBuilder.append(String.format("}%s", newLine));

        return stringBuilder.toString();
    }

}


class DemoCodeBuilder {

    public static void main(String[] args) {
        final CodeBuilder builder = new CodeBuilder("Person");
        builder
            .addField("car", "String")
            .addField("age", "int");

        System.out.println(builder);
    }
}
package org.dp.arsene.builder;

import org.dp.arsene.builder.Builder.HtmlBuilder;

import java.util.ArrayList;
import java.util.Collections;

class NestedBuilder {

    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlBuilder("ul");
        // FLUENT BUILDER IN ACTION
        builder
            .addChild("li", "hello")
            .addChild("li", "world");
        System.out.println(builder);
    }
}


/**
 * Use Nested Classes for Builder Pattern
 */
class Builder {

    static class HtmlBuilder {
        private final String rootName;
        private HtmlElement root = new HtmlElement();

        public HtmlBuilder(String rootName) {
            this.rootName = rootName;
            root.name = rootName;
        }

        public HtmlBuilder addChild(String childName, String childText) {
            HtmlElement element = new HtmlElement(childName, childText);
            root.elements.add(element);
            // Introduce FLUENT BUILDER as return the reference to Current Object
            return this;
        }

        public void clear() {
            root = new HtmlElement();
            root.name = rootName;
        }

        @Override
        public String toString() {
            return root.toString();
        }

    }

    static class HtmlElement {
        private final String newLine = System.lineSeparator();
        public String name;
        public String text;
        public ArrayList<HtmlElement> elements = new ArrayList<>();

        public HtmlElement(String name, String text) {
            this.name = name;
            this.text = text;
        }

        public HtmlElement() {

        }

        private String toStringImpl(int indent) {
            final int indentSize = 2;
            StringBuilder stringBuilder = new StringBuilder();
            String i = String.join("", Collections.nCopies(indent * indentSize, " "));
            stringBuilder.append(String.format("%s<%s>%s", i, name, newLine));

            if (isTextValid()) {
                stringBuilder.append(String.join("", Collections.nCopies(indentSize * (indent + 1), " ")))
                        .append(text)
                        .append(newLine);
            }

            for (HtmlElement element : elements)
                stringBuilder.append(element.toStringImpl(indent + 1));

            stringBuilder.append(String.format("%s</%s>%s", i, name, newLine));
            return stringBuilder.toString();
        }

        private boolean isTextValid() {
            return text != null && !text.isEmpty();
        }

        @Override
        public String toString() {
            return toStringImpl(0);
        }
    }

}

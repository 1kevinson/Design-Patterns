package org.dp.arsene.builder;

public class DemoStringBuilder {

    public static void main(String[] args) {
        String hello = "hello";
        System.out.println("<p>" + hello + "</p>");

        String[] words = {"Hello", "word"};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ul>\n");
        for (String word : words) {
            stringBuilder.append(String.format("<li>%s</li>\n", word));
        }
        stringBuilder.append("</ul>");
        System.out.println(stringBuilder);
    }

}

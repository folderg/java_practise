package org.example;

public class Main {
    public static void main(String[] args) {
        CustomStringBuilder sb = new CustomStringBuilder();

        sb.append("Custom");
        System.out.println("1.append:  \"" + sb + "\"");
        sb.append(" String");
        System.out.println("2.append:  \"" + sb + "\"");
        sb.append(" Builder");
        System.out.println("3.append:  \"" + sb + "\"");
        sb.reverse();
        System.out.println("4.reverse:  \"" + sb + "\"");
        sb.delete(0, 7);
        System.out.println("5.delete:   \"" + sb + "\"");
        sb.append(42);
        System.out.println("6.append:   \"" + sb + "\"");

        sb.undo();
        System.out.println("undo1() ->       \"" + sb + "\"");

        sb.undo();
        System.out.println("undo2() ->       \"" + sb + "\"");

        sb.undo();
        System.out.println("undo3() ->       \"" + sb + "\"");

        sb.undo();
        System.out.println("undo4() ->       \"" + sb + "\"");

        sb.undo();
        System.out.println("undo5() ->       \"" + sb + "\"");

        sb.undo();
        System.out.println("undo6() ->       \"" + sb + "\"");

        sb.undo();
        System.out.println("undo7() ->       \"" + sb + "\"");
    }
}

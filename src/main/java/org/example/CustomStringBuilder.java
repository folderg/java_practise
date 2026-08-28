package org.example;

import java.util.ArrayDeque;

public class CustomStringBuilder {

    private final StringBuilder innerStringBuilder;

    private final ArrayDeque<String> actions;

    public CustomStringBuilder() {
        this.innerStringBuilder = new StringBuilder();
        this.actions = new ArrayDeque<>();
        saveSnapshot();
    }

    public CustomStringBuilder(int capacity) {
        this.innerStringBuilder = new StringBuilder(capacity);
        this.actions = new ArrayDeque<>();
        saveSnapshot();
    }

    public CustomStringBuilder(String str) {
        this.innerStringBuilder = new StringBuilder(str);
        this.actions = new ArrayDeque<>();
        saveSnapshot();
    }



    // ============= Новый функционал ===============

    private void saveSnapshot() {
        actions.push(innerStringBuilder.toString());
    }

    public CustomStringBuilder undo() {
        if (actions.size() <= 1) {
            return this;
        }
        actions.pop();
        innerStringBuilder.setLength(0);
        innerStringBuilder.append(actions.peek());
        return this;
    }

    // ===== Стандартное StingBuilder API с добавлением действий в историю  =====

    public CustomStringBuilder append(Object obj) {
        innerStringBuilder.append(obj);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder append(String str) {
        innerStringBuilder.append(str);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder append(char c) {
        innerStringBuilder.append(c);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder append(int i) {
        innerStringBuilder.append(i);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder append(long l) {
        innerStringBuilder.append(l);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder append(double d) {
        innerStringBuilder.append(d);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder append(boolean b) {
        innerStringBuilder.append(b);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder append(char[] chars) {
        innerStringBuilder.append(chars);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder delete(int start, int end) {
        innerStringBuilder.delete(start, end);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder deleteCharAt(int index) {
        innerStringBuilder.deleteCharAt(index);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder insert(int offset, String str) {
        innerStringBuilder.insert(offset, str);
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder reverse() {
        innerStringBuilder.reverse();
        saveSnapshot();
        return this;
    }

    public CustomStringBuilder replace(int start, int end, String str) {
        innerStringBuilder.replace(start, end, str);
        saveSnapshot();
        return this;
    }

    public int length() {
        return innerStringBuilder.length();
    }

    public int capacity() {
        return innerStringBuilder.capacity();
    }

    public void ensureCapacity(int minimumCapacity) {
        innerStringBuilder.ensureCapacity(minimumCapacity);
    }

    public void trimToSize() {
        innerStringBuilder.trimToSize();
    }

    public void setLength(int newLength) {
        if (newLength != innerStringBuilder.length()) {
            innerStringBuilder.setLength(newLength);
            saveSnapshot();
        }
    }

    public char charAt(int index) {
        return innerStringBuilder.charAt(index);
    }

    public void setCharAt(int index, char ch) {
        innerStringBuilder.setCharAt(index, ch);
        saveSnapshot();
    }

    public CharSequence subSequence(int start, int end) {
        return innerStringBuilder.subSequence(start, end);
    }

    public int compareTo(CustomStringBuilder other) {
        return innerStringBuilder.compareTo(other.innerStringBuilder);
    }

    @Override
    public String toString() {
        return innerStringBuilder.toString();
    }

}

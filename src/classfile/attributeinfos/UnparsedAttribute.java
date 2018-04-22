package classfile.attributeinfos;

import classfile.AttributeInfo;
import classfile.ClassReader;

/**
 * Created by yin on 18/4/17.
 */
public class UnparsedAttribute implements AttributeInfo {
    String name;
    long length;
    byte[] info;

    public UnparsedAttribute(String name, long length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.info = reader.readBytes((int)(this.length));
    }

    byte[] Info() {
        return this.info;
    }
}
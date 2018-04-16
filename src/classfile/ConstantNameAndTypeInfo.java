package classfile;

/**
 * Created by yin on 18/4/16.
 */
public class ConstantNameAndTypeInfo implements ConstantInfo {
    private int nameIndex;
    private int descriptorIndex;

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIndex = reader.readUint16();
        this.descriptorIndex = reader.readUint16();
    }

    public int getNameIndex() {
        return this.nameIndex;
    }

    public int getDescriptorIndex() {
        return this.descriptorIndex;
    }
}

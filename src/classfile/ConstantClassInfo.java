package classfile;

/**
 * Created by yin on 18/4/16.
 */
public class ConstantClassInfo implements ConstantInfo {
    private ConstantPool cp;
    private int nameIndex;

    public ConstantClassInfo(ConstantPool cp) {
        this.cp = cp;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIndex = reader.readUint16();
    }

    public String getName() {
        return this.cp.getUtf8(this.nameIndex);
    }

    public int getNameIndex() {
        return nameIndex;
    }
}

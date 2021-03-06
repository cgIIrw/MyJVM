package rtda.methodarea.rtcp.symref;

import classfile.constantpool.ConstantInfo;
import rtda.methodarea.rtcp.RuntimeConstantPool_;
import rtda.methodarea.rtcp.symref.SymRef;

public abstract class MemberRef extends SymRef {

    private String name;
    private String descriptor;

    public MemberRef(RuntimeConstantPool_ runtimeConstantPool) {
        super(runtimeConstantPool);
    }

    abstract void copyMemberRefInfo(ConstantInfo info);

    public String getName() {
        return name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }
}

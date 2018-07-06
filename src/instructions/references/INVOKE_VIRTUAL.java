package instructions.references;

import instructions.base.Index16Instruction;
import instructions.base.MethodInvokeLogic;
import rtda.Myframe;
import rtda.heap.*;

public class INVOKE_VIRTUAL extends Index16Instruction {
    @Override
    public void execute(Myframe frame) {
        Myclass currentClass = frame.getMyMethod().getMyclass();
        RuntimeConstantPool cp = currentClass.getRuntimeConstantPool();
        MethodRef methodRef = (MethodRef)cp.getConstant(index).getVal();
        MyMethod resolvedMethod = methodRef.resolvedMethod();

        if (resolvedMethod.isStatic()) {
            throw new IncompatibleClassChangeError();
        }
        Myobject ref = frame.getOperandStack().getRefFromTop(resolvedMethod.getArgSlotCount() - 1);

        if (ref == null) {
            // hack
            throw new NullPointerException();
        }

        if (resolvedMethod.isProtected()
                && resolvedMethod.getMyclass().isSuperClassOf(currentClass)
                && resolvedMethod.getMyclass().getPackageName().equals(currentClass.getPackageName())
                && ref.getMyclass() != currentClass
                && !ref.getMyclass().isSubClassOf(currentClass)) {
            throw new IllegalAccessError();
        }

        MyMethod methodToBeInvoked = MethodRef.lookupMethodInClass(currentClass.getSuperClass(),
                methodRef.getName(), methodRef.getDescriptor());

        if (methodToBeInvoked == null || methodToBeInvoked.isAbstract()) {
            throw new AbstractMethodError();
        }

        MethodInvokeLogic.invokeMethod(frame, methodToBeInvoked);
    }
}

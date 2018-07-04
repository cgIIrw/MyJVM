package instructions.constants.Ldc;

import classfile.CreateConstantInfo;
import instructions.base.Index16Instruction;
import rtda.Myframe;
import rtda.OperandStack;
import rtda.heap.Constant;
import rtda.heap.RuntimeConstantPool;

public class LDC2_W extends Index16Instruction {
    @Override
    public void execute(Myframe frame) {
        OperandStack stack = frame.getOperandStack();
        RuntimeConstantPool cp = frame.getMyMethod().getMyclass().runtimeConstantPool;
        Constant c = cp.getConstants(index);

        switch (c.getType()) {
            case CreateConstantInfo.CONSTANT_Long:
                stack.pushLong(((long)(c.getVal())));
                break;
            case CreateConstantInfo.CONSTANT_Double:
                stack.pushDouble(((double)(c.getVal())));
                break;
            default:
                throw new ClassFormatError();
        }
    }
}
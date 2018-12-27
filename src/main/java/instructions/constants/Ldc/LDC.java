package instructions.constants.Ldc;

import classfile.constantpool.ConstantInfoFactory;
import instructions.base.Index8Instruction;
import rtda.stack.OperandStack_;
import rtda.stack.StackFrame_;
import rtda.heap.Constant;
import rtda.heap.RuntimeConstantPool;

public class LDC extends Index8Instruction {
    @Override
    public void execute(StackFrame_ frame) {
        OperandStack_ stack = frame.getOperandStack();
        RuntimeConstantPool cp = frame.getMyMethod().getClass_().getRuntimeConstantPool();
        Constant c = cp.getConstant(index);

        switch (c.getType()) {
            case ConstantInfoFactory.CONSTANT_Integer:
                stack.pushInt((int)((long)(c.getVal()) & 0xffffffff));
                break;
            case ConstantInfoFactory.CONSTANT_Float:
                stack.pushFloat((float)(c.getVal()));
                break;
//            case ConstantInfoFactory.CONSTANT_Long:
//                break;
//            case ConstantInfoFactory.CONSTANT_Double:
//                break;
//            case ConstantInfoFactory.CONSTANT_String:
//                break;
//            case ConstantInfoFactory.CONSTANT_Class:
//                break;
//            case ConstantInfoFactory.CONSTANT_Fieldref:
//                break;
//            case ConstantInfoFactory.CONSTANT_Methodref:
//                break;
//            case ConstantInfoFactory.CONSTANT_InterfaceMethodref:
//                break;
            default:
                break;
            // todo
        }







    }
}

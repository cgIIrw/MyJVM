package instructions.constants;

import instructions.base.NoOperandsInstruction;
import rtda.stack.StackFrame_;

public class ICONST_4 extends NoOperandsInstruction {

    @Override
    public void execute(StackFrame_ frame) {
        frame.getOperandStack().pushInt(4);
    }
}

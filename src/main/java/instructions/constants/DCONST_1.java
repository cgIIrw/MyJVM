package instructions.constants;

import instructions.base.NoOperandsInstruction;
import rtda.stack.StackFrame_;

public class DCONST_1 extends NoOperandsInstruction {
    @Override
    public void execute(StackFrame_ frame) {
        frame.getOperandStack().pushDouble(1.0);
    }
}

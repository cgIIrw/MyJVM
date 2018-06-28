package instructions.math.add;

import instructions.base.NoOperandsInstruction;
import rtda.Myframe;
import rtda.OperandStack;

public class FADD extends NoOperandsInstruction {
    @Override
    public void execute(Myframe frame) {
        OperandStack stack = frame.getOperandStack();
        float f01 = stack.popFloat();
        float f02 = stack.popFloat();
        float result = f01 + f02;
        stack.pushFloat(result);
    }
}
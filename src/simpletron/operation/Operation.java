package simpletron.operation;

public interface Operation {

    void operationRead(int operand, Integer[] memory);

    void operationWrite(int operand, Integer[] memory);

    int operationLoad(int operand, Integer[] memory, int accumulator);

    void operationStore(int operand, Integer[] memory, int accumulator);

    int operationAdd(int operand, Integer[] memory, int accumulator);

    int operationSubtract(int operand, Integer[] memory, int accumulator);

    void operationDivide(int operand, Integer[] memory, int accumulator);

    int operationMultiply(int operand, Integer[] memory, int accumulator);

    void operationModule(int operand, Integer[] memory, int accumulator);

    int operationBranch(int operand, int instructionRegister);

    int operationBranchNeg(int operand, int instructionRegister, int accumulator);

    int operationBranchZero(int operand, int instructionRegister, int accumulator);

    void operationHalt(boolean exit);
}

package simpletron.operation;

import java.util.Scanner;

public class OperationImpl implements Operation{
    public OperationImpl() { }

    @Override
    public void operationRead(int operand, Integer[] memory) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an integer");
        memory[operand] = keyboard.nextInt();
    }

    @Override
    public void operationWrite(int operand, Integer[] memory) {
        System.out.println("value from memory: " + memory[operand]);
    }

    @Override
    public int operationLoad(int operand, Integer[] memory, int accumulator) {
        return memory[operand];
    }

    @Override
    public void operationStore(int operand, Integer[] memory, int accumulator) {
        memory[operand] = accumulator;
    }

    @Override
    public int operationAdd(int operand, Integer[] memory, int accumulator) {
        return memory[operand];
    }

    @Override
    public int operationSubtract(int operand, Integer[] memory, int accumulator) {
        return memory[operand] - accumulator;
    }

    @Override
    public void operationDivide(int operand, Integer[] memory, int accumulator) {

    }

    @Override
    public int operationMultiply(int operand, Integer[] memory, int accumulator) {
        return memory[operand];
    }

    @Override
    public void operationModule(int operand, Integer[] memory, int accumulator) {

    }

    @Override
    public int operationBranch(int operand, int instructionRegister) {
        return operand;
    }

    @Override
    public int operationBranchNeg(int operand, int instructionRegister, int accumulator) {
        return accumulator < 0 ? operand : instructionRegister;
    }

    @Override
    public int operationBranchZero(int operand, int instructionRegister, int accumulator) {
        return accumulator == 0 ? operand : instructionRegister;
    }

    @Override
    public void operationHalt(boolean exit) {

    }
}

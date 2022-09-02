package simpletron;

import simpletron.enums.OperationCodeEnum;
import simpletron.operation.OperationImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Simpletron {

    OperationImpl opActions = new OperationImpl();

    int accumulator = 0;         //registrador acumulador.
    int instructionCounter = 0;  //posição na memória que contém a instrução que está sendo executada.
    int operationCode = 0;       //indica operação que está sendo atualmente executada
    int operand = 0;             //indicar a posição da memória sobre a qual a instrução atual opera
    int instructionRegister = 0; // transfira a próxima instrução que vai ser executada da memória para uma variável instructionRegister
    Integer[] memory = new Integer[100];

    public void executeSimpletron() {

        Arrays.fill(memory, 0);
        System.out.println("Welcome to Simpletron!");

        File file = new File("C:\\Users\\Gabriel\\Desktop\\simpletronArchive2.txt");
        Scanner sFile = readFile(file);

        while (true) {
            assert sFile != null;
            if (!sFile.hasNext()) break;
            int instruction = parseInt(sFile.nextLine().substring(1));
            memory[instructionCounter] = instruction;
            operationCode = instruction / 100;
            operand = instruction % 100;
            execution(operationCode);
            instructionCounter++;
        }

        System.out.println("Simpletron loading completed!");
        System.out.println("Simpletron execution begins!");

        memoryDump(memory);
    }

    public Scanner readFile(File file) {
        Scanner scannedFile = null;
        try {
            scannedFile = new Scanner(file);
            return scannedFile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void memoryDump(Integer[] memory) {
        System.out.print(" ");
        for(int i = 0; i < 10; i++) {
            System.out.print("      " + i);
        }
        System.out.println();
        int initialPosition = 0;
        for(int i = 0; i < 10; i++) {
            System.out.print(i);
            for(int j = 0; j < 10; j++) {
                if (memory[initialPosition].equals(0)) {
                    System.out.print("  +0000");
                } else if (memory[initialPosition].toString().length() == 2) {
                    System.out.print("  +00" + memory[initialPosition]);
                } else if (memory[initialPosition].toString().length() == 3) {
                    System.out.print("  +0" + memory[initialPosition]);
                } else {
                    System.out.print("  +" + memory[initialPosition]);
                }
                initialPosition++;
            }
            System.out.println();
        }
    }

    public void execution(Integer operationCode) {
        if(OperationCodeEnum.fromCode(operationCode) != null) {
            switch (OperationCodeEnum.fromCode(operationCode)) {
                case "READ"      : opActions.operationRead(operand, memory); break;
                case "WRITE"     : opActions.operationWrite(operand, memory); break;
                case "LOAD"      : accumulator = opActions.operationLoad(operand, memory, accumulator); break;
                case "ADD"       : accumulator += opActions.operationAdd(operand, memory, accumulator); break;
                case "STORE"     : opActions.operationStore(operand, memory, accumulator); break;
                case "SUBTRACT"  : accumulator = opActions.operationSubtract(operand, memory, accumulator); break;
                case "DIVIDE"    : opActions.operationDivide(operand, memory, accumulator); break;
                case "MULTIPLY"  : accumulator *= opActions.operationMultiply(operand, memory, accumulator); break;
                case "MODULE"    : opActions.operationModule(operand, memory, accumulator); break;
                case "BRANCH"    : instructionRegister = opActions.operationBranch(operand, instructionRegister); break;
                case "BRANCHNEG" : instructionRegister = opActions.operationBranchNeg(operand, instructionRegister, accumulator); break;
                case "BRANCHZERO": instructionRegister = opActions.operationBranchZero(operand, instructionRegister, accumulator); break;
                case "HALT": opActions.operationHalt(true); break;
                default:
                    System.out.println("failure");
            }
        }
    }
}


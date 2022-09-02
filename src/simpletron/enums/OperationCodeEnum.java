package simpletron.enums;

public enum OperationCodeEnum {

    READ(10, "READ"),
    WRITE(11, "WRITE"),
    LOAD(20, "LOAD"),
    STORE(21,"STORE"),
    ADD(30, "ADD"),
    SUBTRACT(31,"SUBTRACT"),
    DIVIDE(32,"DIVIDE"),
    MULTIPLY(33,"MULTIPLY"),
    MODULE(34,"MODULE"),
    BRANCH(40,"BRANCH"),
    BRANCHNEG(41,"BRANCHNEG"),
    BRANCHZERO(42,"BRANCHZERO"),
    HALT(43,"HALT");

    private Integer code;
    private String operation;

    OperationCodeEnum(Integer code, String operation) {
        this.code = code;
        this.operation = operation;
    }

    public static String fromCode (Integer code) {
        for(OperationCodeEnum c : OperationCodeEnum.values()) {
            if(c.code.equals(code)) {
                return c.operation;
            }
        }
        return null;
    }
}

package kbslt.exception;

/**
 * @author Jean-Pierre Alonso.
 */
public abstract class BusinessException extends Exception {
    private String code;
    private Object[] params;

    public BusinessException() {
        // TODO Auto-generated constructor stub
    }

    public BusinessException(String arg0) {
        super();
        code = arg0;
    }

    public BusinessException(String arg0, Object...arg1) {
        super();
        code = arg0;
        params = arg1;
    }

    public BusinessException(Throwable arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    public BusinessException(String arg0, Throwable arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    public BusinessException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
        // TODO Auto-generated constructor stub
    }

    public String getCode() {
        return code;
    }

    public Object[] getParams() {
        return params;
    }

}

package meidator;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午5:40
 * <p/>
 * TODO
 */
public class AttributeMessage extends Message {

    private static final String KEY = "attrMsg";

    public AttributeMessage(Object data) {
        super(KEY, data);
    }
}

package meidator;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午5:31
 * <p/>
 * TODO
 */
public class Message {

    String key;// available receiver's key.
    Object data;// data in message.

    public Message(String key, Object data) {
        this.key = key;
        this.data = data;
    }
}

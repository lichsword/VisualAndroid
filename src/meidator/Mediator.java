package meidator;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午5:17
 * <p/>
 * 中介者、调停者
 */
public interface Mediator {

    public void send(Message message, Colleague colleague);

}

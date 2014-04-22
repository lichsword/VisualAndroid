package meidator;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午5:28
 * <p/>
 * 消息中介者、调停者
 */
public class AttributeMediator implements Mediator {

    private static AttributeMediator sInstance;

    private AttributeMediator() {

    }

    public static AttributeMediator getInstance() {
        if (null == sInstance) {
            sInstance = new AttributeMediator();
        }// end if
        return sInstance;
    }

    @Override
    public void send(Message message, Colleague colleague) {
        if (colleague instanceof AttributeColleague) {
            AttributeColleague sender = (AttributeColleague) colleague;
            for (AttributeColleague receiver : colleagues) {
                receiver.notify(message, sender);
            }
        } else {
            // TODO log
        }
    }

    ArrayList<AttributeColleague> colleagues = new ArrayList<AttributeColleague>();

    public void addColleague(AttributeColleague colleague) {
        colleagues.add(colleague);
    }

    public void removeColleague(AttributeColleague colleague) {
        colleagues.remove(colleague);
    }

}

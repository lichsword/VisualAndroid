package meidator;

import model.AttrTextView;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午5:33
 * <p/>
 * 能处理 属性消息 事件的同事
 */
public abstract class AttributeColleague extends Colleague {

    protected String name;

    public AttributeColleague() {
        mediator = AttributeMediator.getInstance();
    }

    /**
     * 发送消息
     *
     * @param message
     */
    public void send(Message message) {
        mediator.send(message, this);
    }

    /**
     * 接收消息
     *
     * @param message
     * @param sender
     */
    public void notify(Message message, AttributeColleague sender) {
        System.out.println("receive message");

        if (sender.equals(name)) {
            // ignore. not need handle self message.
            return;
        } // end if

        Object data = message.data;
        if (data instanceof AttrTextView) {
            refresh((AttrTextView) data);
        } else {
            // TODO log
        }
    }

    public abstract void refresh(AttrTextView textViewAttr);
}

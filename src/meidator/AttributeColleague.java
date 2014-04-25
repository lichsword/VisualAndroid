package meidator;

import coder.textview.ModelTextView;
import org.eclipse.swt.widgets.Composite;

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

    public AttributeColleague(Composite parent) {
        super(parent);
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
        if (data instanceof ModelTextView) {
            refresh((ModelTextView) data);
        } else {
            // TODO log
        }
    }

    public abstract void refresh(ModelTextView textViewAttr);
}

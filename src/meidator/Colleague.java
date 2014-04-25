package meidator;

import org.eclipse.swt.widgets.Composite;
import ui.Page;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午5:32
 * <p/>
 * 同事
 */
public abstract class Colleague extends Page {
    protected Mediator mediator;

    public Colleague(Composite parent) {
        super(parent);
    }
}

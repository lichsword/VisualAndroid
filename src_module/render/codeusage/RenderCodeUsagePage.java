package render.codeusage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import ui.IPage;
import ui.Page;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-25
 * Time: 上午11:10
 * <p/>
 * TODO
 */
public class RenderCodeUsagePage extends Page implements IPage {

    private Control mControl;

    public RenderCodeUsagePage(Composite parent) {
        super(parent);
        Text text = new Text(parent, SWT.NONE);
        mControl = text;
    }

    @Override
    public Control getControl() {
        return mControl;
    }
}

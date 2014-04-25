package designer;

import designer.codeusage.DesignCodeUsagePage;
import designer.textview.DesignTextViewPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;
import ui.IPage;
import ui.Page;


/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-24
 * Time: 下午3:50
 * <p/>
 * TODO
 */
public class DesignerPageGroup extends Page implements IPage {

    private Composite mComposite;
    // child tab folders.
    private TabFolder mTabFolder;

    public DesignerPageGroup(Composite parent) {
        super(parent);
        Group group = new Group(parent, SWT.NONE);
        mComposite = group;
        group.setText("设计器");
        group.addControlListener(mControlListener);

        mTabFolder = new TabFolder(group, SWT.NONE);

        // text view control
        {
            TabItem tabItem = new TabItem(mTabFolder, SWT.NONE);
            tabItem.setText("TextView");
            DesignTextViewPage page = new DesignTextViewPage(mTabFolder);
            tabItem.setControl(page.getControl());
        }

        // code usage control
        {
            TabItem tabItem = new TabItem(mTabFolder, SWT.NONE);
            tabItem.setText("Code Usage");
            DesignCodeUsagePage page = new DesignCodeUsagePage(mTabFolder);
            tabItem.setControl(page.getControl());
        }
    }


    private OnControlListener mControlListener = new OnControlListener();

    @Override
    public Control getControl() {
        return mComposite;
    }

    private class OnControlListener implements ControlListener {

        @Override
        public void controlMoved(ControlEvent e) {
            // TODO
        }

        @Override
        public void controlResized(ControlEvent e) {
            Rectangle rectangle = mComposite.getBounds();
            mTabFolder.setBounds(0, 0, rectangle.width, rectangle.height);
        }
    }

}

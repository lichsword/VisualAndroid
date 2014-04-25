package render;

import designer.IPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;
import render.textview.DesignTextViewPage;
import ui.Page;


/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-24
 * Time: 下午3:50
 * <p/>
 * TODO
 */
public class RenderPageGroup extends Page implements IPage {

    private Composite mComposite;
    // child tab folders.
    private TabFolder mTabFolder;

    public RenderPageGroup(Composite parent) {
        super(parent);
        Group group = new Group(parent, SWT.NONE);
        mComposite = group;
        group.setText("render group");
        group.addControlListener(mControlListener);

        mTabFolder = new TabFolder(group, SWT.NONE);

        // text view control
        TabItem tabItem = new TabItem(mTabFolder, SWT.NONE);
//        tabItem.setText("tabItem tabItem A");
//        Text text = new Text(mTabFolder, SWT.NONE);
//        text.setText("child text");
        tabItem.setText("TextView");
        DesignTextViewPage textViewPage = new DesignTextViewPage(mTabFolder);
        tabItem.setControl(textViewPage.getControl());
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

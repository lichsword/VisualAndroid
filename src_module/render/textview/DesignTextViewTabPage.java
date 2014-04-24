package render.textview;

import coder.textview.ModelTextView;
import meidator.AttributeColleague;
import meidator.AttributeMediator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import util.ColorUtil;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午5:52
 * <p/>
 */
public class DesignTextViewTabPage extends AttributeColleague {

    public static final String TAG = DesignTextViewTabPage.class.getSimpleName();

    private Group mGroup;

    public DesignTextViewTabPage(Composite parent) {
        name = TAG;

        initContentView(parent);

        registerMediator();
    }

    private void registerMediator() {
        AttributeMediator.getInstance().addColleague(this);
        // TODO
    }

    private void initContentView(Composite parent) {
        Group group = new Group(parent, SWT.NONE);
        mGroup = group;
        group.setText("设计 TextView");

        FillLayout fillLayout = new FillLayout();
        fillLayout.marginWidth = 10;
        fillLayout.marginHeight = 10;
        fillLayout.type = SWT.VERTICAL;
        group.setLayout(fillLayout);

        initChildView(group);

    }

    private void initChildView(Group parent) {
        Group childGroup = new Group(parent, SWT.VERTICAL);
        FillLayout fillLayout = new FillLayout();
        fillLayout.type = SWT.HORIZONTAL;
        childGroup.setLayout(fillLayout);

        mText = new Text(childGroup, SWT.MULTI);
    }


    private Text mText;

    public Group getGroup() {
        return mGroup;
    }

    @Override
    public void refresh(ModelTextView textViewAttr) {
        // TODO
        ColorUtil.RGBA rgba = ColorUtil.hexToRGBA(textViewAttr.getTextColor());
        if (null != rgba) {
            mText.setForeground(new Color(mText.getDisplay(), rgba.r, rgba.g, rgba.b));
        } else {
            // TODO log Or tip
        }
        mText.setText(textViewAttr.getText());

    }
}

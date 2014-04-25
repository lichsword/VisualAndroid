package render.textview;

import coder.textview.ModelTextView;
import meidator.AttributeColleague;
import meidator.AttributeMediator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import ui.IPage;
import util.ColorUtil;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午5:52
 * <p/>
 */
public class RenderTextViewPage extends AttributeColleague implements IPage {

    public static final String TAG = RenderTextViewPage.class.getSimpleName();


    public RenderTextViewPage(Composite parent) {
        super(parent);
        name = TAG;

        initContentView(parent);

        registerMediator();
    }

    private void registerMediator() {
        AttributeMediator.getInstance().addColleague(this);
        // TODO
    }

    private Composite mComposite;

    private void initContentView(Composite parent) {
        mComposite = new Composite(parent, SWT.NONE);
//        group.setText("设计 TextView");

        FillLayout fillLayout = new FillLayout();
        fillLayout.marginWidth = 10;
        fillLayout.marginHeight = 10;
        fillLayout.type = SWT.VERTICAL;
        mComposite.setLayout(fillLayout);

        initChildView(mComposite);

    }

    private void initChildView(Composite parent) {
        mText = new Text(parent, SWT.MULTI);
    }


    private Text mText;

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

    @Override
    public Control getControl() {
        return mComposite;  // TODO
    }
}

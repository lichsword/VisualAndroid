package designer.textview;

import coder.textview.ModelTextView;
import designer.IPage;
import meidator.AttributeColleague;
import meidator.AttributeMediator;
import meidator.Message;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;


/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午4:06
 * <p/>
 * TODO
 */
public class AttributeTextViewTabPage extends AttributeColleague implements IPage {

    public static final String TAG = AttributeTextViewTabPage.class.getSimpleName();

    private Composite mComposite;
    private Text[] mAttrText;

    public AttributeTextViewTabPage(Composite parent) {
        super(parent);
        name = TAG;

        initContentView(parent);
        registerMediator();
    }

    private void registerMediator() {
        AttributeMediator.getInstance().addColleague(this);
        // TODO
//        暂时 不考虑 destory，后期抽象出一个 onCreate() 和 onDestroy()
    }


    private void initContentView(final Composite parent) {

        Group group = new Group(parent, SWT.NONE);
        mComposite = group;
        group.setText("属性");

        FillLayout fillLayout = new FillLayout();
        fillLayout.marginWidth = 10;
        fillLayout.marginHeight = 10;
        fillLayout.type = SWT.VERTICAL;
        group.setLayout(fillLayout);


        mAttrText = new Text[3];
        initChildAttrTextColor(group);
        initChildAttrTextSize(group);
        initChildAttrTextString(group);
    }

    private void initChildAttrTextColor(Group group) {
        Group childGroup = new Group(group, SWT.VERTICAL);
        FillLayout fillLayout = new FillLayout();
        fillLayout.type = SWT.HORIZONTAL;
        childGroup.setLayout(fillLayout);
        Rectangle rect = group.getBounds();
        childGroup.setBounds(0, 0, rect.width, rect.height / 3);
        //
        final Label label = new Label(childGroup, SWT.LEFT);
        label.setText("颜色");
        final Text text = new Text(childGroup, SWT.MULTI);
        text.setText("#ff0000");
        mAttrText[0] = text;

        final Button button = new Button(childGroup, SWT.BORDER);
        button.addSelectionListener(mButtonSelectionListener);
        button.setText("设置");
    }

    private void initChildAttrTextSize(Group group) {
        Group childGroup = new Group(group, SWT.VERTICAL);
        FillLayout fillLayout = new FillLayout();
        fillLayout.type = SWT.HORIZONTAL;
        childGroup.setLayout(fillLayout);
        Rectangle rect = group.getBounds();
        childGroup.setBounds(0, 50, rect.width, rect.height / 3);
        //
        final Label label = new Label(childGroup, SWT.LEFT);
        label.setText("尺寸");
        final Text text = new Text(childGroup, SWT.MULTI);
        text.setText("18dp");
        mAttrText[1] = text;
        final Button button = new Button(childGroup, SWT.BORDER);
        button.addSelectionListener(mButtonSelectionListener);
        button.setText("设置");
    }

    private void initChildAttrTextString(Group group) {
        Group childGroup = new Group(group, SWT.VERTICAL);
        FillLayout fillLayout = new FillLayout();
        fillLayout.type = SWT.HORIZONTAL;
        childGroup.setLayout(fillLayout);
        Rectangle rect = group.getBounds();
        childGroup.setBounds(0, 2 * rect.height / 3, rect.width, rect.height / 3);
        //
        final Label label = new Label(childGroup, SWT.LEFT);
        label.setText("文本");
        final Text text = new Text(childGroup, SWT.MULTI);
        text.setText("click");
        mAttrText[2] = text;
        final Button button = new Button(childGroup, SWT.BORDER);
        button.addSelectionListener(mButtonSelectionListener);
        button.setText("设置");
    }

    private ModelTextView mAttr = new ModelTextView();

    @Override
    public void refresh(ModelTextView textViewAttr) {
        // TODO
    }

    private ButtonSelectionListener mButtonSelectionListener = new ButtonSelectionListener();

    @Override
    public Control getControl() {
        return mComposite;
    }

    private class ButtonSelectionListener implements SelectionListener {

        @Override
        public void widgetSelected(SelectionEvent e) {
            mAttr.setTextColor(mAttrText[0].getText());
            mAttr.setTextSize(mAttrText[1].getText());
            mAttr.setText(mAttrText[2].getText());

            System.out.println(mAttr.dump());

            send(new Message("attrMsg", mAttr));
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
            // TODO
        }
    }
}

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
public class AttributeTabPage {

    private Group mGroup;

    public AttributeTabPage(Composite parent) {
        initContentView(parent);
    }

    public Group getGroup() {
        return mGroup;
    }

    private void initContentView(final Composite parent) {

        Group group = new Group(parent, SWT.NONE);
        mGroup = group;
        group.setText("属性");

        FillLayout fillLayout = new FillLayout();
        fillLayout.marginWidth = 10;
        fillLayout.marginHeight = 10;
        fillLayout.type = SWT.VERTICAL;
        group.setLayout(fillLayout);

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

        String colorString = text.getText();

        final Button button = new Button(childGroup, SWT.MULTI);
        button.setText("设置");
        button.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // TODO
//                text2.setForeground(new Color(parent.getDisplay(), 0, 255, 0));
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO
            }
        });

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
        final Button button = new Button(childGroup, SWT.MULTI);
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
        final Button button = new Button(childGroup, SWT.MULTI);
        button.setText("设置");
    }
}

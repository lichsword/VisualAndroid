import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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

    public Group getGroup(){
        return mGroup;
    }

    private void initContentView(final Composite parent) {

        Group group = new Group(parent, SWT.NONE);
        mGroup = group;
        group.setText("属性");

        FillLayout fillLayout = new FillLayout();
        fillLayout.marginWidth = 10;
        fillLayout.marginHeight = 10;
        group.setLayout(fillLayout);

        final Label label = new Label(group, SWT.LEFT);
        label.setText("颜色");
        final Text colorText = new Text(group, SWT.MULTI);
        colorText.setText("#ff0000");

        String colorString = colorText.getText();

        final Button button = new Button(group, SWT.MULTI);
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
}

package template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-24
 * Time: 下午3:06
 * <p/>
 * TODO
 */
public class TemplateManager {

    public static void main(String[] args) {
        String result = TemplateManager.getInstance().get("singleton");
        System.out.println(result);
    }

    public static final String TAG = TemplateManager.class.getSimpleName();

    private static TemplateManager sInstance;

    public static TemplateManager getInstance() {
        if (null == sInstance) {
            sInstance = new TemplateManager();
        }// end if
        return sInstance;
    }

    private TemplateManager() {
        // TODO
    }

    /**
     * Get template string content.
     *
     * add cache level TODO next version.
     * @param templateName
     * @return
     */
    public String get(String templateName) {
        String result;
        InputStream inputStream = getClass().getResourceAsStream(templateName + ".tpl");
        StringBuilder sb = new StringBuilder();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while (null != (line = reader.readLine())) {
                sb.append(line);
            }// end while
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }


}

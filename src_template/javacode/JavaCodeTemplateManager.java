package javacode;

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
public class JavaCodeTemplateManager {

    public static void main(String[] args) {
        String result = JavaCodeTemplateManager.getInstance().get("singleton");
        System.out.println(result);
    }

    public static final String TAG = JavaCodeTemplateManager.class.getSimpleName();

    private static JavaCodeTemplateManager sInstance;

    public static JavaCodeTemplateManager getInstance() {
        if (null == sInstance) {
            sInstance = new JavaCodeTemplateManager();
        }// end if
        return sInstance;
    }

    private JavaCodeTemplateManager() {
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

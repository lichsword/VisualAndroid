package coder.textview;

/**
 * Created with IntelliJ IDEA.
 * User: lichsword
 * Date: 14-4-22
 * Time: 下午6:14
 * <p/>
 * TODO
 */
public class ModelTextView {
    private String textColor;
    private String textSize;
    private String text;

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public void setTextSize(String textSize) {
        this.textSize = textSize;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getTextSize() {
        return textSize;
    }

    public String getText() {
        return text;
    }

    public String dump() {
        StringBuilder sb = new StringBuilder();
        sb.append("textColor=" + textColor + ";");
        sb.append("textSize=" + textSize + ";");
        sb.append("text=" + text + ";");
        return sb.toString();
    }
}

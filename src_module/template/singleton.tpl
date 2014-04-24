public class %s {

    private static final String TAG = %s.class.getSimpleName();

    private static %s sInstance;

    private %s() {
    }

    /**
     * 单例，取引用
     *
     * @return
     */
    public static %s getInstance() {
        if (null == sInstance) {
            sInstance = new %s();
        }// end if
        return sInstance;
    }
}
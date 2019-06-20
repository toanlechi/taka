package vn.magik.hometest.models;

/**
 * Class contain info services.
 */
public class Services {
    /**
     * Id icon.
     */
    private int icon;
    /**
     * Name service
     */
    private String name;

    /**
     * Constructor.
     *
     * @param icon icon
     * @param name name
     */
    public Services(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

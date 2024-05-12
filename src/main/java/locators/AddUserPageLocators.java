package locators;

public class AddUserPageLocators {
    public static final String ROLE_FIELD_CSS_SELECTOR = "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div";
    public static final String SELECTED_ROLE_CSS_SELECTOR = "div[role=\"listbox\"] > [role=\"option\"]";
    public static final String STATUS_FIELD_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div";
    public static final String SELECTED_STATUS_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]";
    public static final String EMPLOYEE_NAME_FIELD_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input";
    public static final String SELECTED_EMPLOYEE_NAME_CSS_SELECTOR = "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > div > div.oxd-autocomplete-dropdown.--positon-bottom > div > span";
    public static final String USERNAME_FIELD_CSS_SELECTOR = "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(4) > div > div:nth-child(2) > input";
    public static final String PASSWORD_FIELD_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input";
    public static final String REPEAT_PASSWORD_FIELD_CSS_SELECTOR = "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > div:nth-child(2) > input";
    public static final String SAVE_BUTTON_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]";
}

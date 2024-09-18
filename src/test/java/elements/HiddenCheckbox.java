package elements;

import com.codeborne.selenide.SelenideElement;

public class HiddenCheckbox {
    private SelenideElement selenideElement;

    /**
     * @param selenideElement
     */
    public HiddenCheckbox(SelenideElement selenideElement) {
        this.selenideElement = selenideElement;
    }

    public void setFlag(boolean flag) {
        if (!selenideElement.isSelected() && flag)
            selenideElement.click();
    }

    public void set() {
        setFlag(true);
    }

    public void remove() {
        setFlag(false);
    }
}
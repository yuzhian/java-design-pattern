package behavioral.mediator.sample;

import java.awt.*;

public class ColleagueButton extends Button implements Colleague {

    public ColleagueButton(String caption) {
        super(caption);
    }

    public void setMediator(Mediator mediator) {            // 保存Mediator
    }

    public void setColleagueEnabled(boolean enabled) {      // Mediator下达启用/禁用的指示
        setEnabled(enabled);
    }
}

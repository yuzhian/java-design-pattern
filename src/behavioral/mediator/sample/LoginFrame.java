package behavioral.mediator.sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // 构造函数。
    // 生成并配置各个Colleague后，显示对话框。
    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        // 使用布局管理器生成4×2窗格
        setLayout(new GridLayout(4, 2));
        // 生成各个Colleague
        createColleagues();
        // 配置
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        // 设置初始的启用起用/禁用状态
        colleagueChanged();
        // 显示
        pack();
        setVisible(true);
    }

    // 生成各个Colleague。
    public void createColleagues() {
        // 生成
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        // 设置Mediator
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);
        // 设置Listener
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // 接收来自于Colleague的通知然后判断各Colleague的启用/禁用状态。
    public void colleagueChanged() {
        if (checkGuest.getState()) { // Guest mode
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else { // Login mode
            textUser.setColleagueEnabled(true);
            userPassChanged();
        }
    }

    // 当textUser或是textPass文本输入框中的文字发生变化时
    // 判断各Colleague的启用/禁用状态
    private void userPassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            buttonOk.setColleagueEnabled(textPass.getText().length() > 0);
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}

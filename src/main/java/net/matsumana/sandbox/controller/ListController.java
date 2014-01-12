package net.matsumana.sandbox.controller;

import com.google.common.collect.Lists;
import lombok.*;
import net.matsumana.sandbox.application.ListApplication;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

//import javax.annotation.PostConstruct;
//import javax.enterprise.context.RequestScoped;

@Named
//@RequestScoped  // RequestScoped + ステートレスモードだとdataTableの値が保持されないので、バリデーションエラー時に値がクリアされてしまう。
@ViewScoped
public class ListController implements Serializable {

    @Setter
    @Getter
//    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class ListItem {
        String value1;
        String value2;
    }

    @Getter
    @Setter
    @NotNull
    @Size(min = 1, max = 3)
    String code;

    @Getter
    String name;

    @Getter
    List<ListItem> items;

    @Inject
    ListApplication listApplication;

    //    @PostConstruct
    public void postAddToView() {
        if (FacesContext.getCurrentInstance().isPostback()) {
            System.out.println("postAddToView postback");
        } else {
            System.out.println("postAddToView not postback");
            name = listApplication.init();
            items = Lists.newArrayList(new ListItem("AAA", "BBB"));
        }
    }

    public void preRender() {
        System.out.println("preRender");
    }

    public String create() {
        listApplication.create();

        // 登録が終わったら画面を初期状態に戻すためにリダイレクトする
        return "index?faces-redirect=true";
    }
}

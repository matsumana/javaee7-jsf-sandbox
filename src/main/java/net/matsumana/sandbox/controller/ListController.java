package net.matsumana.sandbox.controller;

import lombok.Getter;
import net.matsumana.sandbox.application.ListApplication;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ListController implements Serializable {

    @Getter
    String name;

    @Inject
    ListApplication listApplication;

    @PostConstruct
    public void init() {
        name = listApplication.init();
    }

    public String create() {
        listApplication.create();

        return null;
    }
}

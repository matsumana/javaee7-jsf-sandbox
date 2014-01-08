package net.matsumana.sandbox.infra;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@AnnotateWith(annotations = {
//        @Annotation(type = Singleton.class, target = AnnotationTarget.CLASS),
        @Annotation(type = RequestScoped.class, target = AnnotationTarget.CLASS),
        @Annotation(type = Inject.class, target = AnnotationTarget.CONSTRUCTOR)
})
public @interface DaoConfig {
}

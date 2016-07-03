package com.ianchiu.twjug.tutorial.annotationprocessor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Created by ian on 6/26/16.
 */
@SupportedAnnotationTypes({"com.ianchiu.twjug.tutorial.annotationprocessor.HelloWorld"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class HelloWorldProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        for(TypeElement typeElement : annotations) {
            for(Element element : roundEnv.getElementsAnnotatedWith(typeElement)) {
                messager.printMessage(Diagnostic.Kind.NOTE, "Hello " + element.toString());
            }
        }
        return true;
    }
}

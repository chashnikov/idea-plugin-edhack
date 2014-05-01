package org.edhack;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiKeyword;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * @author nik
 */
public class ShowHelpAnnotator implements Annotator {
  @Override
  public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    if (element instanceof PsiKeyword && element.getText().equals(PsiKeyword.PUBLIC)) {
      Annotation infoAnnotation = holder.createInfoAnnotation(element, "'public' keyword is used to declare members which are visible to all other classes");
      infoAnnotation.setEnforcedTextAttributes(new TextAttributes(null, null, Color.green, EffectType.LINE_UNDERSCORE, 0));
    }
  }
}

// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SDSingleLineStatement extends PsiElement {

  @NotNull
  List<SDArgument> getArgumentList();

  @Nullable
  SDIdentifierName getIdentifierName();

  @NotNull
  SDKeyword getKeyword();

}